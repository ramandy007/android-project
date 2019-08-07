package com.example.assignment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button light,dark;
    ConstraintLayout layout;

   String color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        light=findViewById(R.id.Light_Theme);
        dark=findViewById(R.id.Dark_Theme);
        layout = findViewById(R.id.layout);

        SharedPreferences sp = getBaseContext().getSharedPreferences("secrets", Context.MODE_PRIVATE);

        color = sp.getString("123","-1");
        Log.i("MainActivity ",color);

        if(color !=null)
        {
            layout.setBackgroundColor(Integer.parseInt(color));}

        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.WHITE );
                color= String.valueOf(Color.WHITE);
                Log.d("MainActivity ",color);

                saveData(v);

            }
        });

        dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.BLACK );
                color= String.valueOf(Color.BLACK);
                Log.d("MainActivity ",color);
                saveData(v);

            }
        });
    }

    public void saveData(View v){

        SharedPreferences sp = getSharedPreferences("secrets", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(String.valueOf(123),color);
        edit.commit();
        Log.d("savedata ",color);
    }
}
