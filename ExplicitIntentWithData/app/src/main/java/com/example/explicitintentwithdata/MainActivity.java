package com.example.explicitintentwithdata;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText uname,pword;
    TextView msg;
    Button b;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=(EditText)findViewById(R.id.name);
        pword=(EditText)findViewById(R.id.pass);
        msg=(TextView)findViewById(R.id.mes);
    }

    @Override
    protected void onStart() {
        super.onStart();
        uname.setText("");
        pword.setText("");
        msg.setText("");
    }

    public void Click(View V){
        String name1=uname.getText().toString().trim();
        String pwd1=pword.getText().toString().trim();
        if(name1.equals("admin")&&pwd1.equals("admin123"))
        {
            Intent i=new Intent(this,Success.class);
            i.putExtra("name",name1);
            i.putExtra("pwd",pwd1);
            startActivity(i);
        }
        else{
            msg.setTextColor(Color.RED);
            msg.setText("ERROR");
        }



    }
}
