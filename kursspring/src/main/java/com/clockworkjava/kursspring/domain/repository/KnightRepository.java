package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

public interface KnightRepository {

    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Optional<Knight> getKnight(String name);

    void deleteKnight(Integer id);

    void createKnight(Knight knight);

    Knight getKnightById(Integer id);

    default void updateKnight(int id, Knight knight) {
        System.out.println("Not implemented");
    }

    void updateKnight(Knight knight);
}
