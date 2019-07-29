package com.example.context_menu2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.text_view);
        registerForContextMenu(tv);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help:
                Toast.makeText(getApplicationContext(), "you've been helped",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.more_help:
                Toast.makeText(getApplicationContext(), "you've been helped more",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.even_more_help:
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);

     /*menu.setHeaderTitle("Context Menu");
     menu.add(0, v.getId(), 0, "Upload");
     menu.add(0, v.getId(), 0, "Search");
     menu.add(0, v.getId(), 0, "Share");
     menu.add(0, v.getId(), 0, "Bookmark");*/
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        //Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.help_guide:
                Toast.makeText(getApplicationContext(), "ContextMenu Shown",
                        Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }

        //return true;
    }
}

