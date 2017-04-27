package com.example.shubham.roomingo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Shubham on 19-03-2017.
 */
public class details extends AppCompatActivity {
    SQLiteDatabase sq;
    DatabaseHelper myDb;
    Cursor cursor;
    listDataAdapter listDataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ListView tpListview = (ListView) findViewById(R.id.listView);
        listDataAdapter = new listDataAdapter(getApplicationContext(),R.layout.smak_layout);
        tpListview.setAdapter(listDataAdapter);
        myDb = new DatabaseHelper(getApplicationContext());

        sq = myDb.getReadableDatabase();
        cursor = myDb.gerInfo(sq);
        if(cursor.moveToFirst())
        {
            do{

                String RoomName,id;
                id = cursor.getString(0);
                RoomName = cursor.getString(1);
                dataprovider dataprovider= new dataprovider(id,RoomName);
                listDataAdapter.add(dataprovider);
            }while (cursor.moveToNext());
        }

        tpListview.setAdapter(listDataAdapter);

        tpListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                int j;
                for (j=0;j<10;j++) {
                    if (i == j) {
                        Intent myintent = new Intent(view.getContext(), roominfo.class);


                        startActivityForResult(myintent, j);
                    }
                }
        }


                                      }

        );

        /*myDb = new DatabaseHelper(this);
        ArrayList<String> thelist  = new ArrayList<>();
        Cursor data = myDb.getlist();

        if(data.getCount()==0)
        {
            Toast.makeText(details.this,"The dtabase was empty ", Toast.LENGTH_LONG).show();
        }else{
            while (data.moveToNext()){
                thelist.add(data.getString(1));
                ListAdapter tpAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                tpListview.setAdapter(tpAdapter);
            }
        }*/
    }


}
