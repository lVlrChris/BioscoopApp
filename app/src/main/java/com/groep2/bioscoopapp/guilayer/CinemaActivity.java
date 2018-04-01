package com.groep2.bioscoopapp.guilayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.groep2.bioscoopapp.R;
import com.groep2.bioscoopapp.domainlayer.Cinema;

import org.w3c.dom.Text;

public class CinemaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema);

        Cinema cinema = new Cinema(" Bioscoop Breda ", "06-12345678", "avans.cinema@avans.nl",  "Lovendijkstraat 6, Breda");
        String telStartString = "Telefoon : ";
        String mailStartString = "E-mail : ";
        String adresStartSTring = "Adres : ";

        TextView biosName = findViewById(R.id.ca_cinemaname);
        biosName.setText(cinema.getName());
        TextView adres = findViewById(R.id.ca_adress);
        adres.setText(adresStartSTring + cinema.getAdress());
        TextView mail = findViewById(R.id.ca_email);
        mail.setText(mailStartString + cinema.getMail());
        TextView tel = findViewById(R.id.ca_phoneNumber);
        tel.setText(telStartString + cinema.getTel());

    }
}
