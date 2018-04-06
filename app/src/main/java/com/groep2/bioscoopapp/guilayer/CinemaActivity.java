package com.groep2.bioscoopapp.guilayer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    public void launchMap(View view){
        Intent intent = null;

        intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.nl/maps/place/Path%C3%A9+Breda/@51.5839355,4.7770626,14.74z/data=!4m5!3m4!1s0x47c69f7f704bcddd:0x39798afaa1dc4718!8m2!3d51.5897361!4d4.7850448"));
        startActivity(intent);
        //geo:51.5850876,4.7910311

//        String address = "http://maps.google.com/maps?daddr= +

    }
}
