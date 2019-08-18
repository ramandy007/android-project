package com.blah.project.integr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class dynamicRB extends AppCompatActivity {

    RadioGroup rg;
    RelativeLayout rl;
    RadioButton rb1,rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_rb);

        rg = new RadioGroup(this);
        rl = (RelativeLayout) findViewById(R.id.relativeLayout);
        rb1 = new RadioButton(this);
        rb2 = new RadioButton(this);

        rb1.setText("Male");
        rb2.setText("Female");
        rg.addView(rb1);
        rg.addView(rb2);
        rg.setOrientation(RadioGroup.VERTICAL);

        RelativeLayout.LayoutParams params[] ={
                new RelativeLayout.LayoutParams
                        (RelativeLayout.LayoutParams.MATCH_PARENT,
                                RelativeLayout.LayoutParams.MATCH_PARENT), // Layout params for radio group
                new RelativeLayout.LayoutParams
                        (RelativeLayout.LayoutParams.MATCH_PARENT,
                                RelativeLayout.LayoutParams.WRAP_CONTENT)}; // Layout params for button


        params[0].leftMargin =10;
        params[0].topMargin = 200;
        params[0].height = 200;
        rg.setLayoutParams(params[0]);
        rl.addView(rg);

        params[1].leftMargin =10;
        params[1].topMargin = 380;

        // Inserting  button programmatically
        Button b = new Button (this);
        b.setText("Test");
        b.setLayoutParams(params[1]);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button clicked",Toast.LENGTH_SHORT).show();

            }
        });
        rl.addView(b);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                Toast.makeText(getApplicationContext(),radioButton.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
