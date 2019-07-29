package com.example.alertdiaglog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private EditText editText;
    private ArrayAdapter<String> adapter ;

    private String products[] = {"Apple", "Banana", "Pinapple", "Orange", "Papaya", "Melon",
            "Grapes", "Water Melon", "Lychee", "Guava", "Mango", "Kivi"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= findViewById(R.id.listView);
        editText=findViewById(R.id.editText);
        adapter= new ArrayAdapter<>(this,R.layout.list_view,R.id.product_name,products);
        lv.setAdapter(adapter);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Toast.makeText(getApplicationContext(), "before text change", Toast.LENGTH_LONG).show();
                Log.d("test","before text changed");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("Test","on text changed");
            }

            @Override
            public void afterTextChanged(Editable s) {
                Toast.makeText(getApplicationContext(), "after text change", Toast.LENGTH_LONG).show();
                Log.d("Test","after text changed");
                adapter.getFilter().filter(s);



            }
        };
        editText.addTextChangedListener(textWatcher);

        AdapterView.OnItemClickListener clickMe = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value=adapter.getItem(position);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
                editText.setText(value);

            }
        };

        lv.setOnItemClickListener(clickMe);
    }

    public void ClickMe (View v)
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Confirm Delete ...");
        alertDialog.setMessage("Are you sure you want delete this ?");
        alertDialog.setIcon(R.drawable.ic_launcher_background);
        alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"yes you clicked on YES: "+which,Toast.LENGTH_SHORT).show();


            }
        });

        alertDialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext()," You click on Cancel: "+which,Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"You clicked on Cancel "+ which,Toast.LENGTH_LONG).show();
            }
        });
        alertDialog.show();
    }
}
