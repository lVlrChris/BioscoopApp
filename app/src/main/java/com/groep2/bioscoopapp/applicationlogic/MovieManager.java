package com.groep2.bioscoopapp.applicationlogic;

import com.groep2.bioscoopapp.dataaccess.MovieApiDao;
import com.groep2.bioscoopapp.domainlayer.Movie;

import java.util.ArrayList;

/**
 * Created by Kevin van Loon on 27-3-2018.
 */

public class MovieManager {

    private MovieApiDao movieApiDao;

    private ArrayList<Movie> movies;

    public MovieManager(MovieListener listener){
        movieApiDao = new MovieApiDao(listener);
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
