package com.groep2.bioscoopapp.guilayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.groep2.bioscoopapp.R;
import com.groep2.bioscoopapp.applicationlogic.TicketManager;
import com.groep2.bioscoopapp.domainlayer.Movie;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        //Lege intent.
        Intent intent;
        //Lege movie.
        TicketManager manager;
        //Maakt een intent aan van de meegegeven intent.
        intent = getIntent();
        //Haalt de gegevens op uit de meegegeven movie.
        manager = (TicketManager) intent.getSerializableExtra("Manager");
        //Zet de titel van de film

        TextView test = (TextView) findViewById(R.id.ap_info);
        test.setText(manager.getTickets().toString());
    }
}
