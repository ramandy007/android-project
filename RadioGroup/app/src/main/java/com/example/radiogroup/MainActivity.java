package com.example.radiogroup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.text.Editable;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends  AppCompatActivity implements AdapterView.OnItemClickListener, TextWatcher, View.OnClickListener,RadioGroup.OnClickListener {

    EditText ed1,ed2;
    RadioGroup radioGroup;
    RadioButton rb1,rb2,rb3;
    Button submit;

  ListView lv;
  String Choice[]={"Android","Cloud","DIP"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.editText1);
        ed2= findViewById(R.id.editText2);
        ed1.addTextChangedListener(this);



        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);

        lv=findViewById(R.id.listv);
        ArrayAdapter<String> ada=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                Choice);
        lv.setAdapter(ada);
        lv.setOnItemClickListener(this);


    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        TextView txt = (TextView) view;
        Toast.makeText(getApplicationContext(), "You have selected : " + txt.getText(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Toast.makeText(getApplicationContext(), "before Textchanged : " + s.toString(), Toast.LENGTH_SHORT).show();
        Log.d("BeforeChange", s.toString());

    }
}
