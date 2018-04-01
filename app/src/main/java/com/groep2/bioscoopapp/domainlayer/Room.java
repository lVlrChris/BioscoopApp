package com.groep2.bioscoopapp.domainlayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin van Loon on 27-3-2018.
 */

public class Room implements Serializable {
    private int RoomID;
    private List<Seat> seats;

    public Room(int roomID) {
        this.RoomID = roomID;
        this.seats = createSeats();
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public ArrayList<Seat> createSeats(){
        ArrayList seats = new ArrayList();
        seats.add(new Seat(1));
        seats.add(new Seat(2));
        seats.add(new Seat(3));
        seats.add(new Seat(4));
        seats.add(new Seat(5));
        seats.add(new Seat(6));
        seats.add(new Seat(7));
        seats.add(new Seat(8));

        return seats;
    }

    public int getAmountOfFreeSeats(){
        int counter = 0;
        for (Seat d : seats){
            if (!d.isTaken()){
                counter++;
            }
        }
        return counter;
    }

    public Seat getASeat(){
        Seat seat = seats.get(0);
        return seat;
    }

    @Override
    public String toString() {
        return Integer.toString(this.getRoomID());
    }
}
