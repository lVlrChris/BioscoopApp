package com.groep2.bioscoopapp.dataaccess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;

/**
 * Created by Kevin van Loon on 27-3-2018.
 */

public class SqlConnection extends SQLiteOpenHelper {

    public SqlConnection(Context context) {
        super(context, SqlContract.DATABASE_NAME, null, SqlContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SqlContract.Ticket.CREATE_TABLE);
        db.execSQL(SqlContract.User.CREATE_TABLE);
        db.execSQL(SqlContract.Presentation.CREATE_TABLE);
        db.execSQL(SqlContract.Room.CREATE_TABLE);
        db.execSQL(SqlContract.Seat.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SqlContract.Ticket.DROP_TABLE);
        db.execSQL(SqlContract.User.DROP_TABLE);
        db.execSQL(SqlContract.Presentation.DROP_TABLE);
        db.execSQL(SqlContract.Room.DROP_TABLE);
        db.execSQL(SqlContract.Seat.DROP_TABLE);
        onCreate(db);
    }
}
