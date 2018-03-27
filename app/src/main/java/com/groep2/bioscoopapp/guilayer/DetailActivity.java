package com.groep2.bioscoopapp.guilayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.groep2.bioscoopapp.R;
import com.groep2.bioscoopapp.domainlayer.Movie;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Lege intent.
        Intent intent;
        //Lege movie.
        Movie movie;
        //Maakt een intent aan van de meegegeven intent.
        intent = getIntent();
        //Haalt de gegevens op uit de meegegeven movie.
        movie = (Movie) intent.getSerializableExtra("Movie");
        //Zet de titel van de film
        TextView title = (TextView) findViewById(R.id.test);
        title.setText(movie.getTitle());

        //Zet het plaatje van de film
        ImageView movieImage = (ImageView) findViewById(R.id.ad_movieImage);
        String startOfImageUrl = "https://image.tmdb.org/t/p/w500" + movie.getBigImageUrl();
        Picasso.with(this).load(startOfImageUrl).into(movieImage);

        //Zet de beschrjiving van de film
        TextView desc = findViewById(R.id.ad_description);
        desc.setText(movie.getDescription());
    }
}
