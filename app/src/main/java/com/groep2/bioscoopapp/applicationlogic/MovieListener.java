package com.groep2.bioscoopapp.applicationlogic;

import com.groep2.bioscoopapp.domainlayer.Movie;

/**
 * Created by Kevin van Loon on 26-3-2018.
 */

public interface MovieListener {
    void onMovieExecute(Movie movie);
}
