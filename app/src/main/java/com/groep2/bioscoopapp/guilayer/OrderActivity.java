package com.groep2.bioscoopapp.guilayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.groep2.bioscoopapp.R;
import com.groep2.bioscoopapp.domainlayer.Movie;
import com.groep2.bioscoopapp.domainlayer.Presentation;
import com.squareup.picasso.Picasso;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //Lege intent.
        Intent intent;
        //Lege presentation.
        Presentation presentation;
        //Maakt een intent aan van de meegegeven intent.
        intent = getIntent();
        //Haalt de gegevens op uit de meegegeven presentation.
        presentation = (Presentation) intent.getSerializableExtra("Presentation");

        ImageView movieImage = findViewById(R.id.ao_movieImage);
        String startOfImageUrl = "https://image.tmdb.org/t/p/w500" + presentation.getMovie().getBigImageUrl();
        Picasso.with(getApplicationContext()).load(startOfImageUrl).into(movieImage);

        TextView movieTitle = findViewById(R.id.ao_movieTitle);
        movieTitle.setText(presentation.getMovie().getTitle());

        TextView time = findViewById(R.id.ao_time);
        time.setText(presentation.getDate() +" "+ presentation.getRoom());


    }
}
