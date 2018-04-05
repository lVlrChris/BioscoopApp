package com.groep2.bioscoopapp.applicationlogic;

import android.util.Log;

import com.groep2.bioscoopapp.dataaccess.MovieApiDao;
import com.groep2.bioscoopapp.domainlayer.Movie;

import java.util.ArrayList;

/**
 * Created by Kevin van Loon on 27-3-2018.
 */

public class MovieManager {

    private static MovieManager instance;
    private MovieApiDao movieApiDao;

    private ArrayList<Movie> movies;

    //Constructor private to make singleton
    private MovieManager(MovieListener listener){
        movieApiDao = new MovieApiDao(listener);
        this.movies = new ArrayList<Movie>();
    }

    //Singleton instance
    public static MovieManager getInstance(MovieListener listener) {
        if(instance == null) {
            instance = new MovieManager(listener);
        }

        return instance;
    }

    //Constructor for later use (when listener is already assigned)
    public static MovieManager getInstance() {
        if(instance == null) {
            Log.d("", "Manager isntance doesn't exist, use getInstance with listener");
        }

        return instance;
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
