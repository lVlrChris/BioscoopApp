package com.groep2.bioscoopapp.domainlayer;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Kevin van Loon on 26-3-2018.
 */

public class MovieAsyncTask extends AsyncTask<String, Void, String> {

    private MovieListener listener;

    public MovieAsyncTask(MovieListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... params) {

        BufferedReader bufferedReader = null;
        String response = "";

        try {
            URL url = new URL(params[0]);
            URLConnection connection = url.openConnection();

            bufferedReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            response = bufferedReader.readLine().toString();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                response += line;
            }

        } catch (Exception e) {
            return null;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return response;
    }

    protected void onPostExecute(String response) {

        try {
            JSONObject object = new JSONObject(response);
            JSONArray jsonArray = object.getJSONArray("results");



            for (int i = 0; i < jsonArray.length(); i++){
                Movie movie = new Movie();

                String title = jsonArray.getJSONObject(i).getString("title");
                movie.setTitle(title);
                String url = jsonArray.getJSONObject(i).getString("backdrop_path");
                movie.setImageUrl(url);
                listener.onMovieExecute(movie);
            }

        }catch (Exception e){

        }
    }
}
