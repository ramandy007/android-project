package com.blah.project.integr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class savInstanceState extends AppCompatActivity implements View.OnClickListener{

    Button b;
    int i=0;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sav_instance_state);

        tv = findViewById(R.id.textView);

        b = findViewById(R.id.button);
        b.setOnClickListener(this);

        //Retrieve i value from savedInstanceState if available
        // and update the textview and toast.
        //1st run - execute the code as such
        //2nd run - comment out the entire if-else block below
        // and check the log.d messages
        //write your observations in lab notebook for both cases

        if (savedInstanceState != null) {

            i = savedInstanceState.getInt("count");
            //updating textview with the i value
            tv.setText(String.valueOf(i));
            Log.d("MainActivity", "OnCreate : i="+i);
            Toast.makeText(this, " onCreate i= "+i,
                    Toast.LENGTH_SHORT).show();

        }
        else
        {
            Log.d("MainActivity", "OnCreate - no data");
            Toast.makeText(this, " onCreate  - no data",
                    Toast.LENGTH_SHORT).show();
        }




    }

    @Override
    public void onClick(View view) {
        // if button is clicked, increment counter,
        // update textview and toast
        if(view.getId()==b.getId()) {
            i++;
            tv.setText(String.valueOf(i));
        }
        Toast.makeText(this, "Hello Android :) clicked "+i,
                Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","Button Clicked... ");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //saving i value in bundle parameter(outState) obtained.
        outState.putInt("count",i);
        Log.d("MainActivity", "OnSaveInstanceState : i="+i);
        Toast.makeText(this, "onSaveInstanceState i= "+i,
                Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            //retrieving i value from bundle parameter(savedInstanceState) obtained.
            i = savedInstanceState.getInt("count");
            //updating textview with the i value
            tv.setText(String.valueOf(i));

            Log.d("MainActivity", "OnRestoreInstanceState : i="+i);
            Toast.makeText(this, "onRestoreInstanceState i= "+i, Toast.LENGTH_SHORT).show();

        }
        else
        {
            Log.d("MainActivity", "OnRestoreInstanceState - no data");
            Toast.makeText(this, " onRestoreInstanceState  - no data", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "OnStart : i="+i);
        Toast.makeText(this, " OnStart  i= "+i, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "OnPause : i="+i);
        Toast.makeText(this, "OnPause i= "+i, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "OnResume : i="+i);
        Toast.makeText(this, "OnResume i= "+i, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "OnStop : i="+i);
        Toast.makeText(this, "OnStop i= "+i, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "OnReStart : i="+i);
        Toast.makeText(this, "OnRestart i= "+i, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "OnDestroy : i="+i);
        Toast.makeText(this, "OnDestroy i="+i, Toast.LENGTH_LONG).show();

    }
}
