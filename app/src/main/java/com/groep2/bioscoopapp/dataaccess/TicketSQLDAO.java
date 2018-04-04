package com.groep2.bioscoopapp.dataaccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.groep2.bioscoopapp.domainlayer.Ticket;

import java.io.Serializable;

/**
 * Created by Kevin van Loon on 27-3-2018.
 */

//TODO: Make this async.
public class TicketSQLDAO {

    private SqlConnection connection;
    private SQLiteDatabase db;

    public TicketSQLDAO(Context context) {
        connection = new SqlConnection(context);
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

        return (int)newRowId;
    }
}
