package com.groep2.bioscoopapp.domainlayer;

import java.io.Serializable;

/**
 * Created by Kevin van Loon on 27-3-2018.
 */

public class Presentation implements Serializable {

    private int id;
    private Movie movie;
    private Room room;
    private String date;

    public Presentation(int id, Movie movie, Room room, String date) {
        this.id = id;
        this.movie = movie;
        this.room = room;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Zaal : " + this.room + ", " + this.date;
    }
}
