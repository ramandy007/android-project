package com.example.activity_lifecycle;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Toast.makeText(this, "onCreate invoked", Toast.LENGTH_LONG).show();
        Log.d("MainActivity", "onCreate invoked");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart invoked", Toast.LENGTH_LONG).show();
        Log.d("MainActivity", "onStart invoked");


    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume invoked", Toast.LENGTH_LONG).show();

        Log.d("MainActivity", "OnResume invoked");

    }


    @Override
    protected void onPause(){
        super.onPause();

        Toast.makeText(this, "onPause invoked", Toast.LENGTH_LONG).show();

        Log.d("MainActivity", "OnPause invoked");


    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, " onStop invoked ", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", " onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, " onRestart invoked ", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "  onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy invoked ", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", " onDestroy invoked");
    }
}


