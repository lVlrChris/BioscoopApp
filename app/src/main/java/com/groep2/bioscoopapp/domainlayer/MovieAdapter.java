package com.groep2.bioscoopapp.domainlayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.groep2.bioscoopapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;



/**
 * Created by Kevin van Loon on 26-3-2018.
 */

public class MovieAdapter extends ArrayAdapter<Movie>{

    public MovieAdapter(Context context, ArrayList<Movie> movies){
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Movie movie = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.movie_listitem,
                    parent,
                    false
            );

        }

        TextView name = (TextView) convertView.findViewById(R.id.ml_title);
        name.setText(movie.getTitle());

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        String startOfImageUrl = "https://image.tmdb.org/t/p/w500" + movie.getImageUrl();
        Picasso.with(getContext()).load(startOfImageUrl).into(imageView);

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        return convertView;
    }
}
