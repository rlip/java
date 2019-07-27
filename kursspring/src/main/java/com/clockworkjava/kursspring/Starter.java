package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.repository.InMemoryRepository;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.PlayerInformationRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import com.clockworkjava.kursspring.services.QuestService;
import com.clockworkjava.kursspring.utils.Role;
import com.clockworkjava.kursspring.utils.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public void run(String... strings) throws Exception {

        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        PlayerInformation p1 = new PlayerInformation("user1", "user1");
        PlayerInformation p2 = new PlayerInformation("user2", "user2");
        playerInformationRepository.persistPlayerInformation(p1);
        playerInformationRepository.persistPlayerInformation(p2);

        Role user1RoleUSER = new Role("user1", "USER");
        Role user2RoleUSER = new Role("user2", "USER");
        Role userRoleADMIN = new Role("user2", "ADMIN");

        roleRepository.presistRole(user1RoleUSER);
        roleRepository.presistRole(user2RoleUSER);
        roleRepository.presistRole(userRoleADMIN);

        questService.assignRandomQuest("Percival");
    }

}
