package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.PlayerInformationRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Component
public class KnightService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Autowired
    QuestRepository questRepository;


    public List<Knight> getAllKnights() {

        Collection<Knight> allKnights = knightRepository.getAllKnights();
        if(!allKnights.isEmpty()) {
            return new ArrayList<>(knightRepository.getAllKnights());
        }
        return new ArrayList<>();
    }


    public void saveKnight(Knight knight) {
        knightRepository.createKnight(knight);
    }

    public Knight getKnight(Integer id) {
        return knightRepository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        knightRepository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) {
        knightRepository.updateKnight(knight.getId(), knight);
    }

    public int collectRewards() {
        Supplier<Stream<Knight>> streamSupplier  = () -> knightRepository.getAllKnights().stream().filter(knight -> {
            Quest quest = knight.getQuest();
            if (quest == null) {
                return false;
            }
            return quest.isCompleted();
        });
        int sum = streamSupplier.get()
                .mapToInt(knight -> knight.getQuest().getReward())
                .sum();

        streamSupplier.get().forEach(knight -> knight.setQuest(null));

        return sum;
    }

    @Transactional
    public void getMyGold() {
        List<Knight> allKnights = getAllKnights();
//        allKnights.forEach( knight -> knight.getQuest().isCompleted());
        allKnights.forEach( knight -> {
            Quest quest = knight.getQuest();
            if(quest != null) {
                boolean completed = quest.isCompleted();
                if(completed) {
                    questRepository.update(quest);
                }
            }
        });

        PlayerInformation first = playerInformationRepository.getFirst();
        int currentGold = first.getGold();
        first.setGold(currentGold + collectRewards());
        playerInformationRepository.update(first);
    }


}
