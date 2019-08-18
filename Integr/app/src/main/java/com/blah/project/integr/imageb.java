package com.blah.project.integr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class imageb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageb);
    }

    public void iv(View View){
        Toast.makeText(this, "Image View clicked!", Toast.LENGTH_SHORT).show();
    }

    public void ib(View view){
        Toast.makeText(this, "Image Button clicked!", Toast.LENGTH_SHORT).show();
    }
}
