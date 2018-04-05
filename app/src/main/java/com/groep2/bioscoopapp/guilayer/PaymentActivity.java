package com.groep2.bioscoopapp.guilayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.groep2.bioscoopapp.R;
import com.groep2.bioscoopapp.applicationlogic.TicketAdapter;
import com.groep2.bioscoopapp.applicationlogic.TicketManager;

public class PaymentActivity extends AppCompatActivity {

    ListView ticketsListview;
    TicketAdapter adapter;
    TicketManager ticketManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        ticketManager= ticketManager.getInstance(getApplicationContext());

        //Zet de titel van de film
        ticketsListview = findViewById(R.id.ap_ticketList);
        adapter = new TicketAdapter(this, ticketManager.getOrderTickets());
        ticketsListview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
