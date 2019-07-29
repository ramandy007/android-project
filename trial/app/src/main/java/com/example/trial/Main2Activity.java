package com.example.trial;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    String recipients="hello@hello.com";
    String subject="1234";
    String body="hello world";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent email = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ssriam99@gmail.com"));
        email.putExtra(Intent.EXTRA_EMAIL,recipients);
        email.putExtra(Intent.EXTRA_SUBJECT,subject);
        email.putExtra(Intent.EXTRA_TEXT, body);
        startActivity(Intent.createChooser(email,"hello"));



    }

}
