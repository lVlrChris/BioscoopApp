package com.groep2.bioscoopapp.dataaccess;

import android.provider.BaseColumns;

public final class SqlContract {

    //private constructor to prevent instantiating
    private SqlContract() {}

    //Database info
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "bioscoop.db";

    //Standard query stuff
    public static final String TEXT_TYPE = " TEXT";
    public static final String INT_TYPE = " INTEGER";
    public static final String COMMA_SEP = ",";

    //Inner classes to define table and column names
    //Ticket table
    public static class Ticket implements BaseColumns {
        //Ticket columns
        public static final String TABLE_NAME = "Ticket";
        public static final String COLUMN_NAME_USER_ID = "UserID";
        public static final String COLUMN_NAME_PRESENTATION_ID = "PresentationID";
        public static final String COLUMN_NAME_SEAT_ID = "SeatID";

        //Create Table Query
        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME_USER_ID + INT_TYPE + COMMA_SEP +
                COLUMN_NAME_PRESENTATION_ID + INT_TYPE + COMMA_SEP +
                COLUMN_NAME_SEAT_ID + INT_TYPE + " )";

        //Drop Table query
        public static  final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class User implements BaseColumns {
        public static final String TABLE_NAME = "User";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY )";

        public static  final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class Presentation implements BaseColumns {
        public static final String TABLE_NAME = "Presentation";
        public static final String COLUMN_NAME_DATETIME = "TimeDate";
        public static final String COLUMN_NAME_ROOM_ID = "RooomID";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME_DATETIME + " DATETIME," +
                COLUMN_NAME_ROOM_ID + INT_TYPE + "  )";

        public static  final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class Room implements BaseColumns {
        public static final String TABLE_NAME = "Room";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY )";

        public static  final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class Seat implements BaseColumns {
        public static final String TABLE_NAME = "Seat";
        public static final String COLUMN_NAME_TICKET_ID = "TicketID";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME_TICKET_ID + INT_TYPE + " )";

        public static  final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
