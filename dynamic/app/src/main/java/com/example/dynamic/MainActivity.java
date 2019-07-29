package com.example.dynamic;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RelativeLayout rl;
    RadioButton rb1, rb2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = new RadioGroup(getApplicationContext());
        rl = findViewById(R.id.relativeLayout);
        rb1 = new RadioButton(getApplicationContext());
        rb2 = new RadioButton(getApplicationContext());
        String str=new String();
        str="helloworld";

        rb1.setText("Male");
        rb2.setText("female");
        rg.addView(rb2);
        rg.addView(rb1);
        rg.setOrientation(RadioGroup.HORIZONTAL);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params.leftMargin = 100;
        params.rightMargin = 100;

        rg.setLayoutParams(params);
        rl.addView(rg);






        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                Toast.makeText(getApplicationContext(), radioButton.getText(), Toast.LENGTH_LONG).show();
            }
        });

    }
}





