package com.blah.project.integr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class listV extends AppCompatActivity implements
        AdapterView.OnItemClickListener {

    ListView lv;
    String[] countries = {"India", "America", "China", "Japan"};
    String[] currencies = {"INR", "USD", "CNY", "JPY"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_v);
        lv=findViewById(R.id.listv);
        List<Map<String, String>> messages = new ArrayList<>();
        HashMap<String,String> content ;
        for(int i = 0 ; i < countries.length; i++) {
            content = new HashMap<String, String>();
            content.put("country", countries[i]);
            content.put("currency", currencies[i]);
            messages.add(content);
        }
        String[] entry = new String[] {"country", "currency"};
        SimpleAdapter adapter = new SimpleAdapter(this, messages,
                android.R.layout.simple_list_item_2,
                entry,
                new int[] {android.R.id.text1,
                        android.R.id.text2,
                });
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        StringBuilder sb = new StringBuilder("");
        //By position in array
        sb.append(countries[position]+" : ");
        sb.append(currencies[position]+"\n");
        Toast.makeText(getApplicationContext(), sb.toString(),
                Toast.LENGTH_SHORT).show();
    }
}
