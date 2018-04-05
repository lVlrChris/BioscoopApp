package com.groep2.bioscoopapp.dataaccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import com.groep2.bioscoopapp.applicationlogic.SqlListener;
import com.groep2.bioscoopapp.applicationlogic.TicketManager;
import com.groep2.bioscoopapp.domainlayer.Presentation;
import com.groep2.bioscoopapp.domainlayer.StudentTicket;
import com.groep2.bioscoopapp.domainlayer.Ticket;
import com.groep2.bioscoopapp.domainlayer.User;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Kevin van Loon on 27-3-2018.
 */

public class TicketSQLDAO extends AsyncTask<String, Void, Cursor> {

    private SqlConnection connection;
    private SQLiteDatabase db;
    private SqlListener listener;

    public TicketSQLDAO(Context context, SqlListener listener) {
        connection = new SqlConnection(context);
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

        //TODO: Make query without selection clause
        //check to see if searchID is empty
        if(TextUtils.isEmpty(params[0])) {
            selectionClause = "";
            selectionArgs[0] = "";
        } else {
            selectionClause = SqlContract.Ticket._ID + "=?";
            selectionArgs[0] = params[0];
        }

        String sortOrder = SqlContract.Ticket._ID + " ASC";

        //Query execution
//        Cursor result = db.query(
//                SqlContract.Ticket.TABLE_NAME,
//                projection,
//                selectionClause,
//                selectionArgs,
//                null,
//                null,
//                sortOrder);

        Cursor result = db.query(
                SqlContract.Ticket.TABLE_NAME,
                projection,
                SqlContract.Ticket._ID + "=?",
                params,
                null,
                null,
                null);

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
                String presentationID = qCursor.getString(2);
                String seatID = qCursor.getString(3);

                Ticket newTicket = new StudentTicket(new User(userID), null, null);
                result.add(newTicket);
            }
        }

        listener.onQueryExecute(result);
    }
}