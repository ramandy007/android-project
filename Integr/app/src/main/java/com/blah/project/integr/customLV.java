package com.blah.project.integr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class customLV extends AppCompatActivity {

    private ListView lv;
    private EditText editText;
    private ArrayAdapter<String> adapter;

    private String products[] = {"Apple", "Banana", "Pinapple", "Orange", "Papaya", "Melon",
            "Grapes", "Water Melon", "Lychee", "Guava", "Mango", "Kivi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_lv);

        lv = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editText);
        adapter = new ArrayAdapter<String>(this,R.layout.list_item, R.id.product_name,products);
        lv.setAdapter(adapter);

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                Log.d("Test","on text changed");
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                Toast.makeText(getApplicationContext(), "before text change", Toast.LENGTH_LONG).show();
                Log.d("test","before text changed");
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                Toast.makeText(getApplicationContext(), "after text change", Toast.LENGTH_LONG).show();
                Log.d("Test","after text changed");
                adapter.getFilter().filter(arg0);
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value=adapter.getItem(position);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
                editText.setText(value);

            }
        });
    }
}

