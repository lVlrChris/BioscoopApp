package com.groep2.bioscoopapp.domainlayer;

import java.io.Serializable;

/**
 * Created by Kevin van Loon on 27-3-2018.
 */

public class Seat implements Serializable{

    private int seatID;
    private boolean isTaken;

    public Seat(int seatID) {
        this.seatID = seatID;
        this.isTaken = false;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }


}
