package com.groep2.bioscoopapp.guilayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

    private Presentation chosenPresentation;
    ListView presentations = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        presentations = findViewById(R.id.ad_presentationList);
        Button orderButton = findViewById(R.id.ad_reserveren);




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
        desc.setMovementMethod(new ScrollingMovementMethod());
        desc.setText(movie.getDescription());

        //Maakt fake data presentation aans
        Presentation presentation1 = new Presentation(movie, new Room(1), "17:00");
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


                for (int z = 0; z < presentations.getCount(); z++ ){
                    presentations.getChildAt(z).setBackgroundColor(getResources().getColor(R.color.white));
                }
                presentations.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Maakt nieuwe intent aan
                Intent intent = new Intent(getApplicationContext(),OrderActivity.class);
                //Geeft movie object mee aan de intent
                intent.putExtra("Presentation", chosenPresentation);
                //Start de nieuwe activity
                startActivity(intent);
            }
        });


    }
}
