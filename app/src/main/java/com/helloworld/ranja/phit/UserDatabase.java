package com.helloworld.ranja.phit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDatabase extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME ="Username";
    private static final String COLUMN_PASS = "Password";
    SQLiteDatabase db;
    private static final String TABLE_CREATE=" create table contacts (id integer primary key not null, AUTO_INCREMENT" +
            "username text not null, Password text not null)";

    public UserDatabase(Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="DROP TABLE IF EXISTS " +TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}

