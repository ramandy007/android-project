package com.example.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText eu,ep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eu=findViewById(R.id.uname);
        ep=findViewById(R.id.pass);


    }

    public void saveData(View v){

        SharedPreferences sp= getSharedPreferences("mycred", Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = sp.edit();

        edit.putString("name1",eu.getText().toString());
        edit.putString("pass1",ep.getText().toString());
        edit.commit();
        Toast.makeText(this,"Data is saved in shared preference",Toast.LENGTH_LONG).show();


    }


}
