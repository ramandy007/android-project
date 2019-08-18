package com.blah.project.integr;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class acTextView extends AppCompatActivity {

    String[] language ={"C","C++","Java","Python","PHP","Kotlin","LISP","Prolog"};
    AutoCompleteTextView atv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_text_view);
        //Try out android.R.layout.select_dialog_item,android.R.layout.simple_dropdown_item_1line,etc
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_selectable_list_item,language);
        atv= (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        atv.setThreshold(1);
        atv.setAdapter(adapter);
        atv.setTextColor(Color.BLUE);


        atv.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                atv.showDropDown();
                return false;
            }
        });
    }

}
