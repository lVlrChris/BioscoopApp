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
import com.groep2.bioscoopapp.applicationlogic.MovieAdapter;
import com.groep2.bioscoopapp.applicationlogic.MovieListener;

public class MainActivity extends AppCompatActivity implements MovieListener {

    MovieManager movieManager;
    MovieAdapter adapter;
    ListView moviesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.movieManager = MovieManager.getInstance(this);

        setupUI();
    }

    public void setupUI() {
        Button infobutton = findViewById(R.id.am_infoCinemaButton);
        moviesListView = findViewById(R.id.am_listview);

        adapter = new MovieAdapter(this, movieManager.getMovies());
        moviesListView.setAdapter(adapter);

        //Als er op een item uit de list wordt geklikt
        moviesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = movieManager.getMovies().get(position);
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
        movieManager.addMovie(movie);
        adapter.notifyDataSetChanged();
    }

    public void imageClick(View view) {
        Intent intent = new Intent(getApplicationContext(),UserActivity.class);
        startActivity(intent);
    }
}
