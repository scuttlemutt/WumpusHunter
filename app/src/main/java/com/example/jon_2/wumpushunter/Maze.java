package com.example.jon_2.wumpushunter;

import java.util.ArrayList;
import java.util.Random;

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
        if (sides==14){ vertexes = 12; vertexConnections = 3;}


        ArrayList<Room> toReturn=new ArrayList();
        for (int i=0;i<vertexes;i++){
            toReturn.add(new Room(i));
        }
        // For each room, connect to others until you have 3 connections
        for(int i=0;i<vertexes;i++){
            Room currentRoom= toReturn.get(i);
            Random rand = new Random();
            //while it has less than 3 connections
            while(currentRoom.getConnections().size()<vertexConnections){
               // Room possibleConnection = toReturn.get(n);
                Room possibleConnection = toReturn.get(rand.nextInt((vertexes-1 - 0) + 1) + 0);
                if(possibleConnection.getID()!=currentRoom.getID() &&
                        possibleConnection.getConnections().size()<vertexConnections &&
                        possibleConnection.getID()!=i &&
                        !currentRoom.getConnections().contains(possibleConnection.getID())){
                    currentRoom.getConnections().add(possibleConnection.getID());
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


    ArrayList<Room> generateMaze2(int _vertexes, int _connections){

        int vertexes=_vertexes;
        int vertexConnections=_connections;

        ArrayList<Room> toReturn=new ArrayList();
        for (int i=0;i<vertexes;i++){
            toReturn.add(new Room(i));
        }
        // For each room, connect to others until you have 3 connections
        for(int i=0;i<vertexes;i++){
            int deadLock=0;
            Room currentRoom= toReturn.get(i);
            Random rand = new Random();
            //while it has less than 3 connections
            while(currentRoom.getConnections().size()<vertexConnections){
                deadLock++;
                // Room possibleConnection = toReturn.get(n);
                Room possibleConnection = toReturn.get(rand.nextInt((vertexes-1 - 0) + 1) + 0);
                if(possibleConnection.getID()!=currentRoom.getID() &&
                        possibleConnection.getConnections().size()<vertexConnections &&
                        possibleConnection.getID()!=i &&
                        !currentRoom.getConnections().contains(possibleConnection.getID())){
                    currentRoom.getConnections().add(possibleConnection.getID());
                    possibleConnection.getConnections().add(i);
                    deadLock=0;
                }
                if (deadLock==100){
                    return generateMaze2(_vertexes, _connections);
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


}
