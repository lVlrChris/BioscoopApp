package com.groep2.bioscoopapp.domainlayer;

/**
 * Created by Kevin van Loon on 27-3-2018.
 */

public class Room {
    private int RoomID;

    public Room(int roomID) {
        RoomID = roomID;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    @Override
    public String toString() {
        return Integer.toString(this.getRoomID());
    }
}
