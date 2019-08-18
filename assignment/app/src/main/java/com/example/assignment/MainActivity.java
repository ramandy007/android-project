package com.example.assignment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button light,dark;
    ConstraintLayout layout;
    Fragment f1,f2;

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

                saveData();

            }
        });

        dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.BLACK );
                color= String.valueOf(Color.BLACK);
                Log.d("MainActivity ",color);
                saveData();

            }
        });
    }

    public void saveData(){

        SharedPreferences sp = getSharedPreferences("secrets", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(String.valueOf(123),color);
        edit.commit();
        Log.d("savedata ",color);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){
            case R.id.dark_menu:
                Toast.makeText(getApplicationContext(),"dark has been clicked",Toast.LENGTH_SHORT).show();
                layout.setBackgroundColor(Color.BLACK );
                color= String.valueOf(Color.BLACK);
                Log.d("MainActivity ",color);
                saveData();
                return true;
            case R.id.white_menu:
                Toast.makeText(getApplicationContext(),"light has been clicked",Toast.LENGTH_SHORT).show();
                layout.setBackgroundColor(Color.WHITE );
                color= String.valueOf(Color.WHITE);
                Log.d("MainActivity ",color);

                saveData();
                return true;
            default:
                return false;


        }

    }


    public void respond(ArrayList<String> i) {
        FragmentManager fm = getFragmentManager();
        Fragment f2 =(FragmentManager) fm.findFragmentById(R.id.frag2);


//        Log.d("frag2", " "+
//        f2.getClass().toString() );

    }

//    @Override
//    public void respond(String [] i) {
//        FragmentManager fm = getFragmentManager();
//        Fragment f2 = fm.findFragmentById(R.id.frag2);
//
//        f2.changeData(String []i);
//
//
//    }


}
