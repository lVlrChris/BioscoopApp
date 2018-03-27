package com.groep2.bioscoopapp.guilayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.groep2.bioscoopapp.R;
import com.groep2.bioscoopapp.domainlayer.Movie;
import com.groep2.bioscoopapp.domainlayer.MovieAdapter;
import com.groep2.bioscoopapp.domainlayer.MovieAsyncTask;
import com.groep2.bioscoopapp.domainlayer.MovieFactory;
import com.groep2.bioscoopapp.domainlayer.MovieListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MovieListener {

    MovieFactory factory = new MovieFactory();
    MovieAdapter adapter;
    ListView moviesListView;
    ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movies = new ArrayList<>();

        recieveMovies();
        movies = factory.getMovies();

        moviesListView = findViewById(R.id.am_listview);

        adapter = new MovieAdapter(this, movies);
        moviesListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


    @Override
    public void onMovieExecute(Movie movie) {
        factory.addMovie(movie);
        adapter.notifyDataSetChanged();
    }

    public void recieveMovies(){
        MovieAsyncTask task = new MovieAsyncTask(this);
        String[] urls = new String[] {"https://api.themoviedb.org/3/discover/movie?primary_release_date.gte=2017-11-15&primary_release_date.lte=2018-03-22&api_key=374be9bb54260058257acf1f992673db"};
        task.execute(urls);
    }
}
