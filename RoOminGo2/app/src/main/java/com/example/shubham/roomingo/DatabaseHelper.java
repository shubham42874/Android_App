package com.example.shubham.roomingo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Final.db";
    public static final String TABLE_NAME1 = "OwnerInfo";
    public static final String TABLE_NAME2= "Details";

    public static final String Col1 = "OwnerName";
    public static final String Col2 = "Password";
    public static final String Col3 = "MobNum";
    public static final String Col4 = "Total";
    public static final String Col5 = "Vacc";
    public static final String Col6 = "RoomName";
    public static final String Col7 = "Rent";
    public  static final String Col8 = "ID";


    SQLiteDatabase db;
    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME2 + " (RoomName TEXT , OwnerName TEXT,Total INTEGER,Vacc INTEGER , MobNum INTEGER , Rent INTEGER, ID INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 0)");
        db.execSQL("create table " + TABLE_NAME1 + " (OwnerName TEXT,Password BLOB,MobNum INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        onCreate(db);
    }

    public boolean insertData1(String OwnerName , String Password , String MobNum ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col1,OwnerName);
        contentValues.put(Col2,Password);
        contentValues.put(Col3,MobNum);
        long result = db.insert(TABLE_NAME1,null,contentValues);
            if(result == -1)
                return false;
        else
                return true;
    }
    public boolean insertData2(String RoomName ,String OwnerName , String Total , String Vacc , String MobNum, String Rent){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col6,RoomName);
        contentValues.put(Col1,OwnerName);
        contentValues.put(Col4,Total);
        contentValues.put(Col5,Vacc);
        contentValues.put(Col3,MobNum);
        contentValues.put(Col7,Rent);
        long result = db.insert(TABLE_NAME2,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor gerInfo(SQLiteDatabase db){
        Cursor cursor;
        String[] projection = {Col6,Col8};
        cursor = db.query(TABLE_NAME2,projection,null,null,null,null,null);
        return cursor;

    }
    public Cursor gerInfo3(SQLiteDatabase db){
        Cursor cursor;
        String[] projection = {Col1,Col3,Col4,Col5,Col6,Col7};
        cursor = db.query(TABLE_NAME2,projection,null,null,null,null,null);
        return cursor;

    }
    public Cursor gerInfo1(String roomname , SQLiteDatabase db){
        Cursor cursor;
        String[] projection = {Col1,Col6,Col4,Col5,Col7,Col3};
        String selection = Col8+"= ?";
        String[] selection_args = {roomname};

        cursor = db.query(TABLE_NAME2,projection,selection,selection_args,null,null,null);
        return cursor;

    }

    public void insertCon(Contact c)
    {

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String querry = " select * from OwnerInfo ";
        Cursor cursor = db.rawQuery(querry,null);

        values.put(Col1,c.getName());
        values.put(Col2,c.getPass());
        values.put(Col3,c.getMob());

        db.insert(TABLE_NAME1,null,values);
    }

    public  String searchpass(String uname)
    {
        SQLiteDatabase db;
        db = this.getReadableDatabase();
        //String[] projection = {Col1,Col2};
        String query = "SELECT OwnerName , Password FROM "+ TABLE_NAME1;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b = "not found ";
        if(cursor.moveToFirst())
        {
            do{
                a=cursor.getString(0);

                if(a.equals(uname))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return  b;
    }

    public boolean update(String name ,String total , String vac){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues con = new ContentValues();
        con.put(Col1,name);
        con.put(Col4,total);
        con.put(Col5,vac);
        db.update(TABLE_NAME2,con,Col1+" =?",new String[]{name});
        return true;
    }



   /* public Cursor getlist(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.rawQuery("SELECT"+Col1 +"FROM "+ TABLE_NAME1,null);
        return data;
    }*/

}
