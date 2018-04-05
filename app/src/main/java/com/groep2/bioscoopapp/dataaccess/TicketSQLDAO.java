package com.groep2.bioscoopapp.dataaccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import com.groep2.bioscoopapp.applicationlogic.MovieManager;
import com.groep2.bioscoopapp.applicationlogic.PresentationManager;
import com.groep2.bioscoopapp.applicationlogic.SqlListener;
import com.groep2.bioscoopapp.applicationlogic.TicketManager;
import com.groep2.bioscoopapp.domainlayer.Movie;
import com.groep2.bioscoopapp.domainlayer.Presentation;
import com.groep2.bioscoopapp.domainlayer.Seat;
import com.groep2.bioscoopapp.domainlayer.StudentTicket;
import com.groep2.bioscoopapp.domainlayer.Ticket;
import com.groep2.bioscoopapp.domainlayer.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kevin van Loon on 27-3-2018.
 */

public class TicketSQLDAO extends AsyncTask<String, Void, Cursor> {

    private SqlConnection connection;
    private SQLiteDatabase db;
    private SqlListener listener;
    private PresentationManager presentationManager;

    public TicketSQLDAO(Context context, SqlListener listener) {
        connection = new SqlConnection(context);
        presentationManager = PresentationManager.getInstance();
        this.listener = listener;
        //Get or make database
        db = connection.getWritableDatabase();
    }

    public int insertTicket(Ticket ticket) {
        ContentValues values = new ContentValues();
        values.put(SqlContract.Ticket.COLUMN_NAME_USER_ID, ticket.getUser().getUserId());
        values.put(SqlContract.Ticket.COLUMN_NAME_PRESENTATION_ID, ticket.getPresentation().getId());
        values.put(SqlContract.Ticket.COLUMN_NAME_SEAT_ID, ticket.getSeat().getSeatID());

        //insert ticket
        long newRowId;
        newRowId = db.insert(SqlContract.Ticket.TABLE_NAME, null, values);

        Log.d("SQLDAO", ticket.toString() + " added!");

        return (int) newRowId;
    }

    public void selectAllTickets() {
        this.execute("");
    }

    @Override
    protected Cursor doInBackground(String... params) {
        String[] projection = {
                SqlContract.Ticket._ID,
                SqlContract.Ticket.COLUMN_NAME_USER_ID,
                SqlContract.Ticket.COLUMN_NAME_PRESENTATION_ID,
                SqlContract.Ticket.COLUMN_NAME_SEAT_ID
        };

        //Defining clause
        String selectionClause = null;

        //Array for selection arguments
        String[] selectionArgs = {""};

        //Standard sorting method
        String sortOrder = SqlContract.Ticket._ID + " ASC";

        //Initialize result
        Cursor result = null;

        //check to see if searchID is empty
        if(TextUtils.isEmpty(params[0])) {
            selectionClause = null;
            selectionArgs[0] = "";

            result = db.rawQuery("SELECT * FROM " + SqlContract.Ticket.TABLE_NAME,null);

        } else {
            selectionClause = SqlContract.Ticket._ID + "=?";
            selectionArgs[0] = params[0];

            //Query execution
            result = db.query(
                    SqlContract.Ticket.TABLE_NAME,
                    projection,
                    selectionClause,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);
        }
        return result;
    }

    @Override
    protected void onPostExecute(Cursor cursor) {
        ArrayList<Ticket> result = new ArrayList<>();

        Cursor qCursor = cursor;

        if (qCursor != null) {
            while (qCursor.moveToNext()) {
                int id = qCursor.getInt(0);
                int userID = qCursor.getInt(1);
                int presentationID = qCursor.getInt(2);
                String seatID = qCursor.getString(3);

                //TODO: Make the actual tickets
                Ticket newTicket = new StudentTicket(new User(userID),
                        presentationManager.getPresentation(presentationID),
                        new Seat(new Random().nextInt(8 ) + 1));
                result.add(newTicket);
            }
        }

        listener.onQueryExecute(result);
    }
}