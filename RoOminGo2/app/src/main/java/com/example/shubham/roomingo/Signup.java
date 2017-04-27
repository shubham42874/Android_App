package com.example.shubham.roomingo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    DatabaseHelper myDb = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }


    public void onSignUpClick(View v)
    {
        if(v.getId()==R.id.button11)
        {
            EditText name = (EditText)findViewById(R.id.editText7);
            EditText pass1 = (EditText)findViewById(R.id.editText8);
            EditText pass2 = (EditText)findViewById(R.id.editText9);
            EditText mob = (EditText)findViewById(R.id.editText10);

            String namestr = name.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();
            String mobstr = mob.getText().toString();

            if(!pass1str.equals(pass2str))
            {
                Toast pass = Toast.makeText(Signup.this," password dont match ", Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                boolean isInserted = myDb.insertData1(namestr,
                        pass1str,
                        mobstr);
                if (isInserted = true)
                    Toast.makeText(Signup.this, "Registered", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Signup.this, "not Registered", Toast.LENGTH_LONG).show();
            }
        }

    }
}
