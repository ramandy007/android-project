package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button b,sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // uncomment this for horizontal scrollview
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.loginB);
        sign=findViewById(R.id.registerB);
        //uncomment this for vertical scroll view
        //setContentView(R.layout.vertical_scroll_view);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,login.class);
                startActivity(i);

            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,signup.class);
                startActivity(i);
            }
        });

    }
}

