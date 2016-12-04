package com.example.jon_2.wumpushunter;

import java.util.ArrayList;

/**
 * Created by Jon_2 on 11/24/2016.
 */
public class Room {


    int id;
    public boolean hasWumpus;
    private boolean hasBats;
    private boolean hasPit;
    private ArrayList<Integer> connections;


    public Room(int id){
        this.id =id;
        this.connections = new ArrayList<Integer>();

    }
    public Room(boolean _hasWumpus, boolean _hasBats, boolean _hasPit, ArrayList<Integer> _connections){
        this.hasWumpus = _hasWumpus;
        this.hasBats = _hasBats;
        this.hasPit = _hasPit;
        this.connections = _connections;


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

    public ArrayList<Integer> getConnections()
    {
        return connections;
    }

    public int getID(){
        return id;
    }
}
