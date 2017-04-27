package com.example.shubham.roomingo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        Button search=(Button)findViewById(R.id.button);
        Button reg=(Button)findViewById(R.id.button2);
        Button upd=(Button)findViewById(R.id.button3);
        final Button exit=(Button)findViewById(R.id.button10);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int1= new Intent(MainActivity.this,register.class);
                startActivity(int1);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int4= new Intent(MainActivity.this,details.class);
                startActivity(int4);
            }
        });

       upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int2= new Intent(MainActivity.this,security.class);
                startActivity(int2);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                System.exit(0);
            }
        });
    }

}
