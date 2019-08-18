package com.blah.project.integr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class onClickList extends AppCompatActivity implements View.OnClickListener{

    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click_list);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn1.setOnClickListener(this);

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(onClickList.this, "Button3 clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void func(View view){
        Toast.makeText(this, "Button1 clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if(v == btn1){
            Toast.makeText(this, "Button2 clicked!", Toast.LENGTH_SHORT).show();
        }
    }
}
