package com.groep2.bioscoopapp.domainlayer;

import java.util.ArrayList;

/**
 * Created by Kevin van Loon on 26-3-2018.
 */

public class MovieFactory {

    private ArrayList<Movie> movies;

    public MovieFactory(){
        this.movies = new ArrayList<Movie>();
    }

    public ArrayList<Movie> getMovies(){
        return this.movies;
    }

    public void restMovies(){
        this.movies.clear();
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }
}
