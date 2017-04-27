package com.example.shubham.roomingo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class security extends AppCompatActivity {

    DatabaseHelper myDb = new DatabaseHelper(this) ;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);
        add();


    }

    public void add()
    {

        Button login = (Button)findViewById(R.id.button4);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()== R.id.button4);
                {
                    EditText a = (EditText)findViewById(R.id.editText4);
                    String str = a.getText().toString();
                    EditText b = (EditText)findViewById(R.id.editText5);
                    String pas = b.getText().toString();

                    String password = myDb.searchpass(str);
                    if(pas.equals(password))
                    {
                        Intent i = new Intent(security.this,Updatation.class);
                        i.putExtra("Username",str);
                        startActivity(i);
                    }
                    else
                    {
                        Toast temp = Toast.makeText(security.this,"Password not matched ",Toast.LENGTH_SHORT);
                        temp.show();
                    }
                }


            }
        });
    }



    //addData();
    }

   /* public void onButtonClick(View v){
        if(v.getId()== R.id.button4);
        {
            EditText a = (EditText)findViewById(R.id.editText4);
            String str = a.getText().toString();
            EditText b = (EditText)findViewById(R.id.editText5);
            String pas = b.getText().toString();

            String password = myDb.searchpass(str);
            if(pas.equals(password))
            {
                Intent i = new Intent(security.this,register.class);
                //i.putExtra("Username",str);
                startActivity(i);
            }
            else
            {
                Toast temp = Toast.makeText(security.this,"Password not matched ",Toast.LENGTH_SHORT);
                temp.show();
            }
        }
    }*/
    /*public void addData() {
        btAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText a = (EditText)findViewById(R.id.editText4);
                        String str = a.getText().toString();
                        EditText b = (EditText)findViewById(R.id.editText5);
                        String pas = b.getText().toString();

                        String password = myDb.searchpass(str);
                        if(pas.equals(password))
                        {
                            Intent i = new Intent(security.this,tp.class);
                            i.putExtra("Username",str);
                            startActivity(i);
                        }
                        else
                        {
                            Toast temp = Toast.makeText(security.this,"Password not matched ",Toast.LENGTH_SHORT);
                            temp.show();
                        }
                    }
                });
    }*/
