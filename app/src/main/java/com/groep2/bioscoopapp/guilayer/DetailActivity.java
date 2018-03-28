package com.groep2.bioscoopapp.guilayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.groep2.bioscoopapp.R;
import com.groep2.bioscoopapp.domainlayer.Movie;
import com.groep2.bioscoopapp.domainlayer.Presentation;
import com.groep2.bioscoopapp.domainlayer.Room;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    Presentation chosenPresentation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ListView presentations = findViewById(R.id.ad_presentationList);



        //Lege intent.
        Intent intent;
        //Lege movie.
        Movie movie;
        //Maakt een intent aan van de meegegeven intent.
        intent = getIntent();
        //Haalt de gegevens op uit de meegegeven movie.
        movie = (Movie) intent.getSerializableExtra("Movie");
        //Zet de titel van de film
        TextView title = (TextView) findViewById(R.id.ad_title);
        title.setText(movie.getTitle());

        //Zet het plaatje van de film
        ImageView movieImage = (ImageView) findViewById(R.id.ad_movieImage);
        String startOfImageUrl = "https://image.tmdb.org/t/p/w500" + movie.getBigImageUrl();
        Picasso.with(this).load(startOfImageUrl).into(movieImage);

        //Zet de beschrjiving van de film
        TextView desc = findViewById(R.id.ad_description);
        desc.setText(movie.getDescription());

        //Maakt fake data presentation aans
        final Presentation presentation1 = new Presentation(movie, new Room(1), "17:00");
        Presentation presentation2 = new Presentation(movie, new Room(1), "21:00");

        //Vult de presentations
        final ArrayList<Presentation> presentationList = new ArrayList<>();
        presentationList.add(presentation1);
        presentationList.add(presentation2);

        //Adapter van presentations
        ArrayAdapter<Presentation> adapter=new ArrayAdapter<Presentation>(this,
                android.R.layout.simple_list_item_1,
                presentationList);

        //Set adapter en on click
        presentations.setAdapter(adapter);
        presentations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Haalt de gegeven presentation op
                Presentation presentation = presentationList.get(i);
                //Stopt deze in de huidige presentation
                chosenPresentation = presentation;
                //Melding dat de prsentation gekozen is (tijdelijk)
                Toast.makeText(getApplicationContext(), presentation.toString(), Toast.LENGTH_SHORT).show();
                
            }
        });


    }
}
