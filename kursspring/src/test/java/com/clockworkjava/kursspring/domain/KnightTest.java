package com.clockworkjava.kursspring.domain;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class KnightTest {

    @Test
    public void testIfQuestMarkedAsStarted(){

        Knight knight = new Knight("Percival", 25);
        Quest quest = new Quest("Testowe zadanie");

        knight.setQuest(quest);

        assertTrue(knight.getQuest().isStarted());

    }
}
