package com.groep2.bioscoopapp.domainlayer;

import java.io.Serializable;

/**
 * Created by Kevin van Loon on 28-3-2018.
 */

public abstract class Ticket implements Serializable {

    private int id;
    private User user;
    private Presentation presentation;
    private Seat seat;
    private int price;
    private String name;

    public Ticket(User user, Presentation presentation, Seat seat) {
        this.user = user;
        this.presentation = presentation;
        this.seat = seat;
    }

    //get/set ID (from db row)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    abstract int getPrice();

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return this.presentation.getMovie().getTitle() + this.presentation.getRoom() + this.presentation.getDate() + this.seat.toString();
    }
}

