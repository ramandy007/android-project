package com.example.browserintent;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button BrowserButton ,CallButton,DialButton;

    EditText ed1,phonenum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] items = {" PHP", " JAVA", " JSON", " C#", " Objective-C"};
        final ArrayList itemsSelected = new ArrayList();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        BrowserButton = findViewById(R.id.button12);
      ed1 = findViewById(R.id.url1);
      CallButton=findViewById(R.id.callbtn);
      DialButton=findViewById(R.id.Dialbtn);
      phonenum= findViewById(R.id.phonenum);


      BrowserButton.setOnClickListener(this);
      CallButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String phonenumber;
              phonenum= findViewById(R.id.phonenum);
              phonenumber=phonenum.getText().toString();
              Intent i = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+phonenumber));

              if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                  ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},007);
                  return;
              }
              startActivity(i);




          }
      });

      DialButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String phonenumber;
              phonenum= findViewById(R.id.phonenum);
              phonenumber=phonenum.getText().toString();
              Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+phonenumber));
              startActivity(i);
          }
      });

        builder.setTitle("Select Languages you know : ");

        builder.setMultiChoiceItems(items, null,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedItemId,
                                        boolean isSelected) {
                        if (isSelected) {
                            Toast.makeText(getApplicationContext(),"Adding - "+items[selectedItemId],Toast.LENGTH_SHORT).show();
                            itemsSelected.add(items[selectedItemId]);
                        } else if (itemsSelected.contains(items[selectedItemId])) {
                            Toast.makeText(getApplicationContext(),"Removing - "+items[selectedItemId],Toast.LENGTH_SHORT).show();
                            itemsSelected.remove(items[selectedItemId]);
                        }
                    }
                });

        builder.setPositiveButton("Done!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                for(int i=0;i<itemsSelected.size();i++){
                    Log.d("Alert",itemsSelected.get(i).toString());
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // User pressed Cancel button. Write Logic Here
                Toast.makeText(getApplicationContext(), "You clicked on Cancel :   "+which,
                        Toast.LENGTH_SHORT).show();
            }

        });
        builder.show();









}

    @Override
    public void onClick(View v) {
        String url;
        ed1 = findViewById(R.id.url1);
        url = ed1.getText().toString();

        Intent i;
        if(v.getId() == BrowserButton.getId())
        {
        if(url.startsWith("http://"))
        i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        else
            i= new Intent(Intent.ACTION_VIEW,Uri.parse("https://"+url));
        startActivity(i);
        }
    }
}

