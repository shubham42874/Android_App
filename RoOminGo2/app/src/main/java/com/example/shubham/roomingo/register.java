package com.example.shubham.roomingo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Shubham on 06-03-2017.
 */
public class register extends Activity {
    DatabaseHelper myDb;
    EditText editOwn , editPass , editMob;
    Button btAdd  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        myDb = new DatabaseHelper(this);

        editOwn = (EditText)findViewById(R.id.editText);
        editPass = (EditText)findViewById(R.id.editText2);
        editMob = (EditText)findViewById(R.id.editText3);
        btAdd = (Button)findViewById(R.id.button5);

        addData();


    }

    public void addData() {
        btAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDb.insertData1(editOwn.getText().toString(),
                                editPass.getText().toString(),
                                editMob.getText().toString());
                        if (isInserted = true)
                            Toast.makeText(register.this, "Registered", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(register.this, "not Registered", Toast.LENGTH_LONG).show();
                        Intent int7 = new Intent(register.this, filldetails.class);
                        startActivity(int7);
                    }
                }
        );

//
    }
}
