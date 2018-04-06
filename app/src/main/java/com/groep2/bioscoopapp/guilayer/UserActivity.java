package com.groep2.bioscoopapp.guilayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.groep2.bioscoopapp.R;
import com.groep2.bioscoopapp.applicationlogic.SqlListener;
import com.groep2.bioscoopapp.applicationlogic.TicketAdapter;
import com.groep2.bioscoopapp.applicationlogic.TicketManager;

public class UserActivity extends AppCompatActivity {


    ListView tickets;
    TicketAdapter adapter;
    TicketManager ticketManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        ticketManager= ticketManager.getInstance(getApplicationContext());

        //Zet de titel van de film
        tickets = findViewById(R.id.au_tickets);
        adapter = new TicketAdapter(this, ticketManager.getTickets());
        ticketManager.setTicketAdapter(adapter);
        tickets.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
