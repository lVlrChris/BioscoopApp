package com.groep2.bioscoopapp.domainlayer;

/**
 * Created by Kevin van Loon on 27-3-2018.
 */

public class Presentation {

    Movie movie;
    Room room;
    String date;

    public Presentation(Movie movie, Room room, String date) {
        this.movie = movie;
        this.room = room;
        this.date = date;
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
}
