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
import com.groep2.bioscoopapp.applicationlogic.TicketManager;
import com.groep2.bioscoopapp.domainlayer.AdultTicket;
import com.groep2.bioscoopapp.domainlayer.ChildTicket;
import com.groep2.bioscoopapp.domainlayer.Movie;
import com.groep2.bioscoopapp.domainlayer.Presentation;
import com.groep2.bioscoopapp.domainlayer.StudentTicket;
import com.groep2.bioscoopapp.domainlayer.Ticket;
import com.groep2.bioscoopapp.domainlayer.User;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.groep2.bioscoopapp.applicationlogic.TicketManager.getInstance;

public class OrderActivity extends AppCompatActivity {

    private final int STUDENT_PRICE = 8;
    private final int ADULT_RPICE = 10;
    private final int CHILD_RPICE = 5;
    private ArrayList<Ticket> tickets = new ArrayList<>();
    Presentation presentation;
    TicketManager ticketManager;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        result = (TextView) findViewById(R.id.ao_calculateResult);
        ticketManager = getInstance(getApplicationContext());
        //Lege intent.
        Intent intent;
        //Lege presentation.
      //  final Presentation presentation;
        //Maakt een intent aan van de meegegeven intent.
        intent = getIntent();
        //Haalt de gegevens op uit de meegegeven presentation.
        presentation = (Presentation) intent.getSerializableExtra("Presentation");

        TextView amountOfFreeSeats = (TextView) findViewById(R.id.ao_amountOfSeats);
        amountOfFreeSeats.setText("Nog " + presentation.getRoom().getAmountOfFreeSeats() + " plaatsen over!");

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

                int totalTickets = getTotalTickets();

                if (totalTickets <= presentation.getRoom().getAmountOfFreeSeats()) {
                    int xSum = getAdultTickets() * ADULT_RPICE;
                    int zSum = getStudentTickets() * STUDENT_PRICE;
                    int ySum = getChildTickets() * CHILD_RPICE;
                    int totalPrice = zSum + xSum + ySum;
                    result.setText("Totaal €" +Integer.toString(totalPrice));
                } else{
                    result.setText("Er zijn nog " + presentation.getRoom().getAmountOfFreeSeats() + " plaatsen over");
                }
            }
        });

    }

    public void setTicketPrices(){
        TextView studentPrice = (TextView) findViewById(R.id.ao_studentPrice);
        studentPrice.setText("€" +Integer.toString(STUDENT_PRICE));

        TextView adultPrice = (TextView) findViewById(R.id.ao_adultPRice);
        adultPrice.setText("€" +Integer.toString(ADULT_RPICE));

        TextView childPrice = (TextView) findViewById(R.id.ao_childPrice);
        childPrice.setText("€" + Integer.toString(CHILD_RPICE));
    }

    public int getStudentTickets(){
        EditText amountStudentTickets = (EditText) findViewById(R.id.ao_studentTicketsAmount);
        int z = 0;
        if (amountStudentTickets.getText().length() != 0) {
            z = Integer.parseInt(amountStudentTickets.getText().toString());
        }
        return z;
    }

    public int getAdultTickets(){
        EditText amountAdultTickets = (EditText) findViewById(R.id.ao_adultTicketsAmount);
        int x = 0;
        if (amountAdultTickets.getText().length() != 0) {
            x = Integer.parseInt(amountAdultTickets.getText().toString());
        }
        return x;
    }

    public int getChildTickets(){
        EditText amountChildTickets = (EditText) findViewById(R.id.ao_childTicketsAmount);
        int y = 0;
        if (amountChildTickets.getText().length() != 0) {
            y = Integer.parseInt(amountChildTickets.getText().toString());
        }

        return y;
    }

    public int getTotalTickets(){
        int total;
        return total = getAdultTickets() + getChildTickets() + getStudentTickets();
    }

    public void paymentButtonClicked(View view) {

        if (getTotalTickets() > 0 && getTotalTickets() <= presentation.getRoom().getSeats().size()) {
            Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
            for (int i = 0; i < getStudentTickets(); i++) {
                Ticket studentTicket = new StudentTicket(new User(1), presentation, presentation.getRoom().getASeat());
                ticketManager.addTicket(studentTicket);
            }

            for (int i = 0; i < getChildTickets(); i++) {
                Ticket ChildTicket = new ChildTicket(new User(1), presentation, presentation.getRoom().getASeat());
                ticketManager.addTicket(ChildTicket);
            }

            for (int i = 0; i < getAdultTickets(); i++) {
                Ticket adultTicket = new AdultTicket(new User(1), presentation, presentation.getRoom().getASeat());
                ticketManager.addTicket(adultTicket);
            }

            startActivity(intent);
            finish();
        } else if (getTotalTickets() == 0){
            result.setText("Kies minimaal 1 kaartje");
        } else if (getTotalTickets() > presentation.getRoom().getSeats().size()){
            result.setText("Er zijn nog " + presentation.getRoom().getSeats().size() + " stoelen beschikbaar");
        }
    }


}
