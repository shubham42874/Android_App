package com.example.shubham.roomingo;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Shubham on 17-04-2017.
 */
public class edit extends AppCompatActivity{

    DatabaseHelper myDb;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

    }
}
