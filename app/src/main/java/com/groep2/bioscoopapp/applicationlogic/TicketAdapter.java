package com.groep2.bioscoopapp.applicationlogic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.groep2.bioscoopapp.R;
import com.groep2.bioscoopapp.domainlayer.Movie;
import com.groep2.bioscoopapp.domainlayer.Ticket;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Kevin van Loon on 1-4-2018.
 */

public class TicketAdapter extends ArrayAdapter<Ticket> {

    public TicketAdapter(Context context, ArrayList<Ticket> tickets){
        super(context, 0, tickets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Ticket ticket = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.ticket_listitem,
                    parent,
                    false
            );

        }

        TextView name = (TextView) convertView.findViewById(R.id.tl_movie);
        name.setText(ticket.getPresentation().getMovie().getTitle());

        TextView room = (TextView) convertView.findViewById(R.id.tl_room);
        room.setText(ticket.getPresentation().getRoom().toString());

//        TextView price = (TextView) convertView.findViewById(R.id.tl_price);
//        price.setText(ticket.getPrice());
        //

//        TextView room = convertView.findViewById(R.id.tl_room);
//        room.setText(ticket.getPresentation().getRoom().getRoomID());

        TextView time = convertView.findViewById(R.id.tl_time);
        time.setText(ticket.getPresentation().getDate());
//
        TextView seat = (TextView) convertView.findViewById(R.id.tl_seat);
        seat.setText(ticket.getSeat().toString()) ;

        return convertView;
    }
}
