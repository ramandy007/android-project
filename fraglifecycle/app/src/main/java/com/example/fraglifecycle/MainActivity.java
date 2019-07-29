package com.example.fraglifecycle;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button firstFrag, secondFrag, thirdFrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// set the user interface layout for this activity
// layout file is defined in the project res/layout/main_activity.xml file
        setContentView(R.layout.activity_main);
        // Toast / log the current method name
        Toast.makeText(this, "onCreate invoked",
                Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "onCreate invoked");
        secondFrag = findViewById(R.id.secondFragment);
        firstFrag = findViewById(R.id.GotoSecond);
        thirdFrag = findViewById(R.id.thirdFragment);


        firstFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), second.class);
                startActivity(i);

            }
        });

        secondFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new frag2());
            }
        });
        thirdFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new frag3());
            }
        });


    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);

        fragmentTransaction.commit();


    }


}
