package com.blah.project.integr;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Call extends AppCompatActivity implements View.OnClickListener {
    EditText e;
    Button dialButton, callButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        dialButton = (Button) findViewById(R.id.dialbutton);
        callButton = (Button) findViewById(R.id.callbutton);
        e = (EditText) findViewById(R.id.e1);
        dialButton.setOnClickListener(this);
        callButton.setOnClickListener(this);
    }

    public void onClick(View view) {
        String phonenumber;
        e = (EditText) findViewById(R.id.e1);
        phonenumber = e.getText().toString();

        if (view.getId() == dialButton.getId()) {
            //Dialer
            Intent i = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + phonenumber));
            startActivity(i);

        }
        if (view.getId() == callButton.getId()) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            //Another way to pass phone no
            intent.setData(Uri.parse("tel:" + phonenumber));

            // The below if condition will be auto suggessted if not given.
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED) {

                // add the following line for runtime permission request
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        123);
                return;
            }
            startActivity(intent);

        }

    }
}
