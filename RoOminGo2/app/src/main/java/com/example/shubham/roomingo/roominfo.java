package com.example.shubham.roomingo;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class roominfo extends Activity{

    TextView Total,Rent,Vac,Mob,Own,Room;
    EditText id;
    DatabaseHelper myDb;
    SQLiteDatabase sqLiteDatabase;
    String rid;
    Button btdis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roominfo);

        id = (EditText)findViewById(R.id.editText6);
        Room = (TextView)findViewById(R.id.textView13);
        Rent = (TextView)findViewById(R.id.textView26);
        Own = (TextView)findViewById(R.id.textView15);
        Total = (TextView)findViewById(R.id.textView17);
        Vac = (TextView)findViewById(R.id.textView24);
        Mob = (TextView)findViewById(R.id.textView28);
        btdis = (Button)findViewById(R.id.button6);

        Room.setVisibility(View.GONE);
        Rent.setVisibility(View.GONE);
        Own.setVisibility(View.GONE);
        Total.setVisibility(View.GONE);
        Vac.setVisibility(View.GONE);
        Mob.setVisibility(View.GONE);


        addData();


    }
    public void addData() {
        btdis.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        rid = id.getText().toString();
                        myDb = new DatabaseHelper(getApplicationContext());
                        sqLiteDatabase = myDb.getReadableDatabase();
                        Cursor cursor = myDb.gerInfo1(rid, sqLiteDatabase);
                        Cursor cursor1 = myDb.gerInfo3(sqLiteDatabase);
                        if (cursor.moveToFirst()) {

                            String room= cursor.getString(0);
                            String own = cursor.getString(1);
                            String total = cursor.getString(2);
                            String vac = cursor.getString(3);
                            String rent = cursor.getString(4);
                            String mob = cursor.getString(5);


                            Room.setText(room);
                            Own.setText(own);
                            Total.setText(total);
                            Vac.setText(vac);
                            Rent.setText(rent);
                            Mob.setText(mob);


                            Rent.setVisibility(View.VISIBLE);
                            Own.setVisibility(View.VISIBLE);
                            Total.setVisibility(View.VISIBLE);
                            Vac.setVisibility(View.VISIBLE);
                            Mob.setVisibility(View.VISIBLE);
                            Room.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            Toast.makeText(roominfo.this, "ID not Registered", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

    }


}
