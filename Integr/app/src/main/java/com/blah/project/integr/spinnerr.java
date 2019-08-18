package com.blah.project.integr;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class spinnerr extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    Spinner s1,s2;
    ToggleButton t;
    LinearLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinnerr);

        s1=(Spinner)findViewById(R.id.spinner1);                                                //simple_list_item_checked
        ArrayAdapter adap1=ArrayAdapter.createFromResource(this,R.array.color,android.R.layout.simple_list_item_activated_1);
        s1.setAdapter(adap1);
        s1.setOnItemSelectedListener(this);


        String days[]={"Sunday","Monday","Tuesday"};
        s2=(Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> adap2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,days);
        s2.setAdapter(adap2);
        s2.setOnItemSelectedListener(this);

        //Use Toggle button with setOnCheckedChangeListener
        t=(ToggleButton)findViewById(R.id.toggleButton);
        l=(LinearLayout)findViewById(R.id.layout1);
        t.setOnCheckedChangeListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if(adapterView.getId()==R.id.spinner1) {
            Log.d("MainActivity", "item selected");
            TextView txt = (TextView) view;
            //Checked Text view
            Log.d("spinner1",txt.getText().toString());
            Toast.makeText(getApplicationContext(), "You have selected " + txt.getText(), Toast.LENGTH_SHORT).show();
        }
        else if(adapterView.getId()==R.id.spinner2)
        {
            CheckedTextView txt1 = (CheckedTextView) view;
            Toast.makeText(getApplicationContext(), "You have selected " + txt1.getText(), Toast.LENGTH_SHORT).show();
            Log.d("spinner2",txt1.getText().toString());
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(getApplicationContext(), "No selection yet", Toast.LENGTH_SHORT).show();

    }
    // Implementing listener For Toggle Button
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

        // Change background color of layout if toggle button is clicked
        if(isChecked)
        {
            l.setBackgroundColor(Color.GRAY);
        }
        else
        {
            l.setBackgroundColor(Color.WHITE);
        }
    }

}

