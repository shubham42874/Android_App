package com.example.shubham.roomingo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Updatation extends AppCompatActivity {

    DatabaseHelper myDb;
    String e;
    EditText total,vac;
    TextView tv;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatation);
        myDb = new DatabaseHelper(this);
        total = (EditText)findViewById(R.id.editText11);
        vac = (EditText)findViewById(R.id.editText21);
        tv = (TextView) findViewById(R.id.textView29);
        bt = (Button)findViewById(R.id.button9);
        Intent i = getIntent();
        e=i.getStringExtra("Username");
        tv.setText(e);
        update();

    }
    public void update(){
        bt.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        boolean isUpdate = myDb.update(tv.getText().toString(),total.getText().toString(),vac.getText().toString());
                        if (isUpdate == true)
                            Toast.makeText(Updatation.this, "Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Updatation.this, "not Updated", Toast.LENGTH_LONG).show();


                    }
                }
        );

    }


}
