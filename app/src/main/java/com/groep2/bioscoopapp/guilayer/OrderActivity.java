package com.groep2.bioscoopapp.guilayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.groep2.bioscoopapp.R;
import com.groep2.bioscoopapp.domainlayer.Movie;
import com.groep2.bioscoopapp.domainlayer.Presentation;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class OrderActivity extends AppCompatActivity {

    private final int STUDENT_PRICE = 8;

    private final int ADULT_RPICE = 10;

    private final int CHILD_RPICE = 5;
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
        time.setText("Op " + presentation.getDate() + " in zaal " + presentation.getRoom());


        setTicketPrices();

        Button calculateButton = (Button) findViewById(R.id.ao_calculatePriceButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText amountStudentTickets = (EditText) findViewById(R.id.ao_studentTicketsAmount);
                int z = Integer.parseInt(amountStudentTickets.getText().toString());
                EditText amountAdultTickets = (EditText) findViewById(R.id.ao_adultTicketsAmount);
                int x = Integer.parseInt(amountAdultTickets.getText().toString());
                EditText amountChildTickets = (EditText) findViewById(R.id.ao_childTicketsAmount);
                int y = Integer.parseInt(amountChildTickets.getText().toString());

                x = x * ADULT_RPICE;
                z = z * STUDENT_PRICE;
                y = y * CHILD_RPICE;
                int totalPrice = 0;
                totalPrice = z + x + y;
                TextView result = (TextView) findViewById(R.id.ao_calculateResult);

                result.setText(Integer.toString(totalPrice));
            }
        });

    }

    public void setTicketPrices(){
        TextView studentPrice = (TextView) findViewById(R.id.ao_studentPrice);
        studentPrice.setText(Integer.toString(STUDENT_PRICE));

        TextView adultPrice = (TextView) findViewById(R.id.ao_adultPRice);
        adultPrice.setText(Integer.toString(ADULT_RPICE));

        TextView childPrice = (TextView) findViewById(R.id.ao_childPrice);
        childPrice.setText(Integer.toString(CHILD_RPICE));
    }
}
