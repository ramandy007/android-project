package com.blah.project.integr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class etcbrb extends AppCompatActivity implements TextWatcher, View.OnClickListener ,RadioGroup.OnCheckedChangeListener {

    EditText ed;
    CheckBox c1,c2;
    Button button;
    RadioButton subRadioButton;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_etcbrb);

        // Make editText use TextWatcher interface to watch change made over EditText.
        // For doing this, EditText calls the addTextChangedListener() method.
        ed = (EditText) findViewById(R.id.editText);
        ed.addTextChangedListener(this);


        // checkbox uses setOnClickListener for notifying selection
        c1 = (CheckBox) findViewById(R.id.checkBox1);
        c2 = (CheckBox) findViewById(R.id.checkBox2);
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Toast.makeText(getApplicationContext(), "before Textchanged : " + s.toString(), Toast.LENGTH_SHORT).show();
        Log.d("BeforeChange", s.toString());
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Toast.makeText(getApplicationContext(), "on Text changed :" + s.toString(), Toast.LENGTH_SHORT).show();
        Log.d("OnChange", s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {
        Toast.makeText(getApplicationContext(), "After TextChanged : " + s.toString(), Toast.LENGTH_SHORT).show();
        Log.d("AfterChange", s.toString());
        try {
            int no = Integer.parseInt(s.toString());
            if (no > 99) {
                s.replace(0, s.length(), "10");
                Toast.makeText(getApplicationContext(), " Enter a number < 99 ", Toast.LENGTH_SHORT).show();
                Log.d(" Enter a number < 99 ", s.toString());
            }
        } catch (NumberFormatException e) {
        }
    }



    @Override
    public void onClick(View v) {
        CheckBox t = (CheckBox) v;
        if (t.isChecked()) {
            Toast.makeText(getApplicationContext(), t.getText()+" is selected", Toast.LENGTH_SHORT).show();
            if(t.getId()==c1.getId()){
                c2.setChecked(false);
            }
            else
                c1.setChecked(false);
        }
    }


    public void onclickbuttonMethod(View view) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        subRadioButton = (RadioButton) findViewById(selectedId);
        if(selectedId == -1){
            Toast.makeText(this,"Nothing selected", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,subRadioButton.getText()+" is selected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup1, int i) {
        //radioGroup1.getCheckedRadioButtonId();
        RadioButton rb = findViewById(i);
        Toast.makeText(this,rb.getText()+" is selected", Toast.LENGTH_SHORT).show();
    }
}
