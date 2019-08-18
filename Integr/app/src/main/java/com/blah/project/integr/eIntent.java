package com.blah.project.integr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class eIntent extends AppCompatActivity {
    TextView t1;
    final int MYREQUEST = 11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_intent);
        t1=(TextView) findViewById(R.id.msg1);
    }
    public void pass(View v)
    {
        Intent i=new Intent(this,success.class);
        i.putExtra("name","hellooooo welcome to the second screen");
        startActivityForResult(i,MYREQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==MYREQUEST)
        {
            if(resultCode == RESULT_OK) {
                String str = data.getStringExtra("msg");
                t1.setText("Received Ok : " + str);
            }

//          Try out uncommenting the code below.
//  else if(resultCode == RESULT_CANCELED){
//                String str = data.getStringExtra("msg");
//                t1.setText("Received Cancelled : "+str);
//            }
//            else {
//                String str = data.getStringExtra("msg");
//                str = str.concat(" " + String.valueOf(resultCode));
//                t1.setText("Received : " + str);
//            }


        }
    }
}

