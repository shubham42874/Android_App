package com.example.shubham.roomingo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Shubham on 05-04-2017.
 */
public class dbhelp extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Romingodb.db";
    public static final String TABLE_NAME = "Details";
    public static final String Col1 = "RoomName";
    public static final String Col2 = "Total";
    public static final String Col3 = "Vac";
    public static final String Col4 = "Own";
    public static final String Col5 = "Con";

    public dbhelp(Context context){
        super(context,DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (RoomName TEXT, Total INTEGER ,Vac INTEGER, Own TEXT , Con TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData1(String RoomName , String Total , String Vac , String Own , String Con ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col1,RoomName);
        contentValues.put(Col2,Total);
        contentValues.put(Col3,Vac);
        contentValues.put(Col4,Own);
        contentValues.put(Col5,Con);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}
