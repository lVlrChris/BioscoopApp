package com.groep2.bioscoopapp.applicationlogic;

import android.util.Log;

import com.groep2.bioscoopapp.domainlayer.Movie;
import com.groep2.bioscoopapp.domainlayer.Presentation;
import com.groep2.bioscoopapp.domainlayer.Room;

import java.util.ArrayList;

public class PresentationManager {

    private static PresentationManager instance;

    private ArrayList<Presentation> presentations;
    private MovieManager movieManager;

    //Constructor protected to make singleton
    protected PresentationManager() {
        presentations = new ArrayList<>();
        movieManager = MovieManager.getInstance();
        fillFakeData();
    }

    //Singleton instance
    public static PresentationManager getInstance() {
        if (instance == null) {
            instance = new PresentationManager();
        }
        return instance;
    }

    //Geeft alle presentaties van een specifieke Movie
    public ArrayList<Presentation> getMoviePresentations(Movie specMovie) {
        ArrayList<Presentation> results = new ArrayList<>();

        for (Presentation pres : presentations) {
            if (pres.getMovie().getMovieID() == specMovie.getMovieID()) {
                results.add(pres);
            }
        }
        return results;
    }

    public ArrayList<Presentation> getPresentations() {
        return presentations;
    }

    public void fillFakeData() {
        for (Movie movie : movieManager.getMovies()) {
            presentations.add(new Presentation(movie, new Room(1), "17:00"));
            presentations.add(new Presentation(movie, new Room(1), "21:00"));
        }
    }
}
