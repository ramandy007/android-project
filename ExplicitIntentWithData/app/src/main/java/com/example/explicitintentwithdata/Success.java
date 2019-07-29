package com.example.explicitintentwithdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Success extends AppCompatActivity {
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        Bundle b=getIntent().getExtras();
        String name = b.getString("name");
        String pwd = b.getString("pwd");
        t1=(TextView)findViewById(R.id.msg);
        String test = "Welcome Username:  "+ name +
                " \n Password:   "+ pwd;
        t1.setText(test);


    }
}
