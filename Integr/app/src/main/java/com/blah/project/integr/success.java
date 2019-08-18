package com.blah.project.integr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class success extends AppCompatActivity {
    EditText t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        t1=(EditText)findViewById(R.id.msg);
        Bundle b=getIntent().getExtras();
        String name=b.getString("name");
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
    }
    public void passmsg(View v)
    {
        String str=t1.getText().toString();
        Intent i=new Intent();
        i.putExtra("msg",str);
        // result code should be  RESULT_OK or RESULT_CANCELLED depending on the usecase
        // generally any integer will work
        setResult(RESULT_OK,i);

// comment out the above line and try uncommenting the code below.
//  if(Integer.valueOf(str) < 0)
//            setResult(RESULT_OK,i);
//        else if (Integer.valueOf(str) > 1)
//            setResult(RESULT_CANCELED,i);

        finish();
    }
}


