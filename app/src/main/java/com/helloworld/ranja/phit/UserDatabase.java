package com.helloworld.ranja.phit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDatabase extends SQLiteOpenHelper{

    public static final String Username = "username";
    public static final String Password = "password";

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String COLUMN_ID = "id";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_USERNAME ="Username";
    private static final String COLUMN_PASS = "Password";
    SQLiteDatabase db;
    private static final String TABLE_CREATE ="create table " + TABLE_NAME + "( " + Username +"text not null," + Password +"text not null)";

    public UserDatabase(Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    public void insertContact(Contact c){
    db=this.getWritableDatabase();
    ContentValues values = new ContentValues();

    String query = "select + from contacts";
    Cursor cursor = db.rawQuery( query,null );


   //values.put(COLUMN_ID, count);
    values.put(COLUMN_USERNAME, c.getUsername());
    values.put(COLUMN_PASS, c.getPassword());

    db.insert(TABLE_NAME,null,values);
    db.close();
    }

    /*public String searchUsername(String namestr){
        db=this.getReadableDatabase();
        String query = "select namestr,pass from" + TABLE_NAME +" Where namestr" + namestr;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst())
        {

        }
        return b;
    }
    /*public String searchPassword(String passstr){
        db=this.getReadableDatabase();
        String query = "select passstr,pass from" + TABLE_NAME +" Where passstr" + passstr;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst())
        {

        }
        return b;
    }*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="DROP TABLE IF EXISTS " +TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}

