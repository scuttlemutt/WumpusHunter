package com.example.jon_2.wumpushunter;

import java.util.ArrayList;

/**
 * Created by Jon_2 on 11/24/2016.
 */
public class Maze {


    ArrayList rooms;
    /**
     * Standard Maze
     */
    public Maze(){

        this.rooms = new ArrayList();
    }

    /**
     * default dohecahedron, 20 rooms, 3 vertex
     */
    ArrayList<Room> generateMaze(){

        ArrayList<Room> toReturn=new ArrayList();
        for (int i=0;i<4;i++){
            toReturn.add(new Room(i));
        }
        // Create 20 rooms total
        ///For each room, while the room has less than two connections, search for another room with less than two connections, then add a connection to both it and the found one.
        for(int i=4;i<20;i++){
            Room room = new Room(i);

            //while this newly created room has less than 3 connections
            while(room.getConnections().size()<3){
                //iterate through each room until you find one that has <3 connections, and connect the two, then break
                innerLoop: for(int n=0;n<i;n++){
                    Room currentRoom = (Room)toReturn.get(n);
                    //if the current room n doesn't have 3 connections AND isn't already connected to this, connect them
                    if(currentRoom.getConnections().size()<3 && !currentRoom.getConnections().contains(n) && i!=n){
                        currentRoom.getConnections().add(i);
                        room.getConnections().add(n);
                       // System.out.println("Connected room" +currentRoom.getConnections().get(i) +" to room "+currentRoom.getConnections().get(i));

                    }
                    int foo=room.getConnections().size();
                    if (foo==3) break innerLoop;

                }

            }

            toReturn.add(room);
        }
        //debug messages
        for(int i=0;i<toReturn.size();i++){
            String s = toReturn.get(i).getID()+ ": Connected to "+toReturn.get(i).getConnections().toArray();
            System.out.println(toReturn.get(i).getID());
        }

        return toReturn;
    }

    ArrayList<Room> generateMaze2(){

        ArrayList<Room> toReturn=new ArrayList();
        for (int i=0;i<20;i++){
            toReturn.add(new Room(i));
        }
        // Create 20 rooms total
        ///For each room, while the room has less than two connections, search for another room with less than two connections, then add a connection to both it and the found one.
        for(int i=4;i<20;i++){
            Room room = new Room(i);

            //while this newly created room has less than 3 connections
            while(room.getConnections().size()<3){
                //iterate through each room until you find one that has <3 connections, and connect the two, then break
                innerLoop: for(int n=0;n<i;n++){
                    Room currentRoom = (Room)toReturn.get(n);
                    //if the current room n doesn't have 3 connections AND isn't already connected to this, connect them
                    if(currentRoom.getConnections().size()<3 && !currentRoom.getConnections().contains(n) && i!=n){
                        currentRoom.getConnections().add(i);
                        room.getConnections().add(n);
                        // System.out.println("Connected room" +currentRoom.getConnections().get(i) +" to room "+currentRoom.getConnections().get(i));

                    }
                    int foo=room.getConnections().size();
                    if (foo==3) break innerLoop;

                }

            }

            toReturn.add(room);
        }
        //debug messages
        for(int i=0;i<toReturn.size();i++){
            String s = toReturn.get(i).getID()+ ": Connected to "+toReturn.get(i).getConnections().toArray();
            System.out.println(toReturn.get(i).getID());
        }

        return toReturn;
    }


    void printMaze(){

    }
    void generateMaze(int size){


    }
}
