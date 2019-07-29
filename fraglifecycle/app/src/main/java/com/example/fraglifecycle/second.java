package com.example.fraglifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class second extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public void respond(String i) {

        android.app.FragmentManager fm =
                getFragmentManager();
        fragcom2 f2 = (fragcom2) fm.
                findFragmentById(R.id.fragment2);
        f2.changedata(i);
    }


}
