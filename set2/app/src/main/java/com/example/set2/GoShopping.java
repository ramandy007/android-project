package com.example.set2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class GoShopping extends AppCompatActivity {

    RadioGroup rg1,rg2,rg3;
    Button checkout ;
    RadioButton rb;
    int totalobj,bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_shopping);

        rg1=findViewById(R.id.radioGroup1);
        rg2=findViewById(R.id.radioGroup2);
        rg3=findViewById(R.id.radioGroup3);

        checkout=findViewById(R.id.checkout);
        Bundle b=getIntent().getExtras();
        final String name=b.getString("name");
        final String phone=b.getString("phone");
        String city = b.getString("city");

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb=findViewById(checkedId);
                totalobj = totalobj +Integer.parseInt(rb.getText().toString());
                Toast.makeText(GoShopping.this,rb.getText()+" is selected "+totalobj, Toast.LENGTH_SHORT).show();


            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb=findViewById(checkedId);
                totalobj = totalobj +Integer.parseInt(rb.getText().toString());
                Toast.makeText(GoShopping.this,rb.getText()+" is selected "+totalobj, Toast.LENGTH_SHORT).show();


            }
        });
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb=findViewById(checkedId);
                totalobj = totalobj +Integer.parseInt(rb.getText().toString());
                Toast.makeText(GoShopping.this,rb.getText()+" is selected "+totalobj, Toast.LENGTH_SHORT).show();


            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bill=100*totalobj;


                Intent j = new Intent(GoShopping.this,ViewScore.class);

                j.putExtra("score",Integer.toString(bill));
                j.putExtra("name",name);
                Log.d("hua",""+bill);
                j.putExtra("phone",phone);
                startActivity(j);
            }
        });
    }
}
