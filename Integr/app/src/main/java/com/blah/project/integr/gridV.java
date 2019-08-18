package com.blah.project.integr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class gridV extends AppCompatActivity implements AdapterView.OnItemClickListener {
    GridView gridView;

    static final String[] alphabets = new String[]{


            "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z",
            "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_v);
        gridView = (GridView) findViewById(R.id.gridview1);
        // Create adapter to set value for grid view
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, alphabets);

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);

  /*    Another coding style to set the listener

gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


          @Override
          public void onItemClick(AdapterView<?> parent, View v,
                                  int position, long id) {


              Toast.makeText(getApplicationContext(),
                      ((TextView) v).getText()  , Toast.LENGTH_SHORT).show();


          }
      });*/


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),
                ((TextView) view).getText()+" Pos: "+position, Toast.LENGTH_SHORT).show();

    }
}

