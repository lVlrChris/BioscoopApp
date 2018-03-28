package com.groep2.bioscoopapp.guilayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.groep2.bioscoopapp.R;
import com.groep2.bioscoopapp.applicationlogic.MovieManager;
import com.groep2.bioscoopapp.domainlayer.Movie;
import com.groep2.bioscoopapp.domainlayer.MovieAdapter;
import com.groep2.bioscoopapp.domainlayer.MovieAsyncTask;
import com.groep2.bioscoopapp.domainlayer.MovieFactory;
import com.groep2.bioscoopapp.domainlayer.MovieListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MovieListener {

    MovieManager manager = new MovieManager();
    MovieAdapter adapter;
    ListView moviesListView;
    ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button infobutton = findViewById(R.id.am_infoCinemaButton);
        movies = new ArrayList<>();
        //haalt movies op
        recieveMovies();
        //vult de movies
        movies = manager.getMovies();
        moviesListView = findViewById(R.id.am_listview);

        adapter = new MovieAdapter(this, movies);
        moviesListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //Als er op een item uit de list wordt geklikt
        moviesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = movies.get(position);
                //Maakt nieuwe intent aan
                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                //Geeft movie object mee aan de intent
                intent.putExtra("Movie", movie);
                //Start de nieuwe activity
                startActivity(intent);
            }
        });

        infobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CinemaActivity.class);
                startActivity(intent);
            }
        });


    }

    //callback
    @Override
    public void onMovieExecute(Movie movie) {
        manager.addMovie(movie);
        adapter.notifyDataSetChanged();
    }

    //Voert asyncuit
    public void recieveMovies(){
        MovieAsyncTask task = new MovieAsyncTask(this);
        String[] urls = new String[] {"https://api.themoviedb.org/3/discover/movie?primary_release_date.gte=2017-11-15&primary_release_date.lte=2018-03-22&api_key=374be9bb54260058257acf1f992673db"};
        task.execute(urls);
    }
}
