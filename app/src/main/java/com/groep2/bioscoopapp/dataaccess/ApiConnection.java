package com.groep2.bioscoopapp.dataaccess;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Kevin van Loon on 27-3-2018.
 */

public class ApiConnection extends AsyncTask<String, Void, String> {

    private MovieApiListener listener;

    public ApiConnection(MovieApiListener listener) {
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

    @Override
    protected void onPostExecute(String response) {
        try {
            JSONObject resultSet = new JSONObject(response);
            listener.onResultSetAvailable(resultSet);
        } catch (Exception e) {

        }
    }
}
