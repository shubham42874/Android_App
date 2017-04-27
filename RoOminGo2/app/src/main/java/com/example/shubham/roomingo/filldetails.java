package com.example.shubham.roomingo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class filldetails extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editRoom , editTotal , editVac , editOwn , editCon , editRent;
    Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filldetails);


        myDb = new DatabaseHelper(this);

        editRoom = (EditText)findViewById(R.id.editText14);
        editTotal = (EditText)findViewById(R.id.editText15);
        editVac = (EditText)findViewById(R.id.editText16);
        editOwn = (EditText)findViewById(R.id.editText17);
        editCon = (EditText)findViewById(R.id.editText18);
        editRent = (EditText)findViewById(R.id.editText19);
        btAdd = (Button)findViewById(R.id.button8);
        Adddata();

        //Button signin =(Button)findViewById(R.id.button5);


    }
    public void Adddata(){
        btAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDb.insertData2(editRoom.getText().toString(),
                                editOwn.getText().toString(),
                                editTotal.getText().toString(),
                                editVac.getText().toString(),
                                editCon.getText().toString(),
                                editRent.getText().toString());
                        if(isInserted= true)
                            Toast.makeText(filldetails.this,"Registered",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(filldetails.this,"not Registered",Toast.LENGTH_LONG).show();

                        Intent int7 = new Intent(filldetails.this, MainActivity.class);
                        startActivity(int7);

                    }

                }

        );
    }


}
