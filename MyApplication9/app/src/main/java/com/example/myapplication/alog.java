package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class alog extends AppCompatActivity {

    Button pay;

    EditText source,destination,weight;
    TextView bill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alog);

        pay=findViewById(R.id.c);
        source= findViewById(R.id.source);
        destination=findViewById(R.id.destination);

        weight= findViewById(R.id.weight);
        bill= findViewById(R.id.Bill);



        weight.addTextChangedListener(new TextWatcher() {
                                          @Override
                                          public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                          }

                                          @Override
                                          public void onTextChanged(CharSequence s, int start, int before, int count) {

                                          }

                                          @Override
                                          public void afterTextChanged(Editable s) {

                                              int num=Integer.parseInt(weight.getText().toString());

                                              bill.setText(Integer.toString(num*15));

                                              Log.d("MainActivity",source.getText().toString()+" "+destination.getText().toString()+" "+ bill.getText().toString());


                                          }
                                      }


        );

  pay.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          Intent i;
          i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://retail.onlinesbi.com/retail/login.htm"));

          startActivity(i);

      }
  });
    }

    @Override
    protected void onStart() {
        super.onStart();
        source.setText("");
        destination.setText("");
        bill.setText("");
    }

}
