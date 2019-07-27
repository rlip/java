package com.clockworkjava.kursspring.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Quest {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;

    private int reward = 100;

    protected int lengthInSeconds = 10;

    private boolean started = false;

    private boolean completed = false;

    protected LocalDateTime startDate;

    public Quest() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        if (started) {
            this.startDate = LocalDateTime.now();
        }
        this.started = started;
    }

    public boolean isCompleted() {
        if (completed) {
            return true;
        }
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime localDateTime = startDate.plusSeconds(lengthInSeconds);

        boolean isAfter = now.isAfter(localDateTime);

        if (isAfter) {
            this.completed = true;
        }

        return isAfter;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Quest(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }
}
