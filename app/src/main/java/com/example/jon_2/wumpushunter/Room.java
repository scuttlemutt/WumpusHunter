package com.example.jon_2.wumpushunter;

/**
 * Created by Jon_2 on 11/24/2016.
 */
public class Room {


    boolean hasWumpus;
    boolean hasBats;
    boolean hasPit;

    public boolean isHasWumpus() {
        return hasWumpus;
    }

    public boolean isHasBats() {
        return hasBats;
    }

    public void setHasBats(boolean hasBats) {
        this.hasBats = hasBats;
    }

    public boolean isHasPit() {
        return hasPit;
    }

    public void setHasPit(boolean hasPit) {
        this.hasPit = hasPit;
    }

    public boolean getHasWumpus() {
        return hasWumpus;
    }

    public void setHasWumpus(boolean hasWumpus) {
        this.hasWumpus = hasWumpus;
    }
}
