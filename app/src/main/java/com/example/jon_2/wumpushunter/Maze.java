package com.example.jon_2.wumpushunter;

import java.util.ArrayList;

/**
 * Created by Jon_2 on 11/24/2016.
 */
public class Maze {


    ArrayList<Room> rooms;
    /**
     * Standard Maze
     */
    public Maze(){

        this.rooms = new ArrayList();
    }


    /**
     * default dohecahedron, 20 rooms, 3 vertex
     */
    ArrayList<Room> generateMaze(int sides){

        int vertexes=20;
        int vertexConnections=3;
        //if (sides==12){ vertexes = 20; connections = 3;}
        if (sides==20){ vertexes = 12; vertexConnections = 5;}

        ArrayList<Room> toReturn=new ArrayList();
        for (int i=0;i<vertexes;i++){
            toReturn.add(new Room(i));
        }
        // For each room, connect to others until you have 3 connections
        for(int i=0;i<vertexes;i++){
            Room currentRoom= toReturn.get(i);
            //while it has less than 3 connections
            for(int n=0;currentRoom.getConnections().size()<vertexConnections;n++){
                Room possibleConnection = toReturn.get(n);
                if(possibleConnection.getID()!=currentRoom.getID() && possibleConnection.getConnections().size()<vertexConnections && n!=i){
                    currentRoom.getConnections().add(n);
                    possibleConnection.getConnections().add(i);
                }
            }

        }

        //debug messages
        for(int i=0;i<toReturn.size();i++){
            String s = toReturn.get(i).getID()+ " Connected to "+toReturn.get(i).getConnections().toString();
            System.out.println(s);
        }

        return toReturn;
    }


    void printMaze(){
        for(int i=0;i<rooms.size();i++){
            String s = rooms.get(i).getID()+ " Connected to "+rooms.get(i).getConnections().toString();
            System.out.println(s);
        }

    }

}
