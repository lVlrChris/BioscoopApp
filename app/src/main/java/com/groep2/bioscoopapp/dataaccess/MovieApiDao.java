package com.groep2.bioscoopapp.dataaccess;

import com.groep2.bioscoopapp.domainlayer.Movie;
import com.groep2.bioscoopapp.applicationlogic.MovieListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Kevin van Loon on 27-3-2018.
 */

public class MovieApiDao implements MovieApiListener {
    protected final String API_URL = "https://api.themoviedb.org/3/discover/movie?primary_release_date.gte=2017-11-15&primary_release_date.lte=2018-03-22&api_key=374be9bb54260058257acf1f992673db";

    private MovieListener listener;
    private ArrayList<Movie> movies;

    public MovieApiDao(MovieListener listener) {
        movies = new ArrayList<>();
        this.listener = listener;

        ApiConnection connection = new ApiConnection(this);
        String[] urls = new String[]{API_URL};
        connection.execute(urls);
    }

    public ArrayList<Movie> getAllMovies() {
        return movies;
    }

    @Override
    public void onResultSetAvailable(JSONObject resultSet) {
        //This parses the JSONObject
        try {
            JSONArray jsonArray = resultSet.getJSONArray("results");

            for (int i = 0; i < jsonArray.length(); i++) {
                Movie movie = new Movie();

                String title = jsonArray.getJSONObject(i).getString("title");
                movie.setTitle(title);
                String url = jsonArray.getJSONObject(i).getString("backdrop_path");
                movie.setSmallImageUrl(url);
                String bigUrl = jsonArray.getJSONObject(i).getString("poster_path");
                movie.setBigImageUrl(bigUrl);
                String desc = jsonArray.getJSONObject(i).getString("overview");
                movie.setDescription(desc);
                int ID = jsonArray.getJSONObject(i).getInt("id");
                movie.setMovieID(ID);

                listener.onMovieExecute(movie);
            }
        } catch (Exception e) {

        }
    }
}