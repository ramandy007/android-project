package com.blah.project.integr;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Browse extends AppCompatActivity implements View.OnClickListener {
    EditText e;
    Button browseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        browseButton = (Button) findViewById(R.id.browsebutton);
        e = (EditText) findViewById(R.id.e1);
        browseButton.setOnClickListener(this);
    }

    public void onClick(View view) {
        String url;
        e = (EditText) findViewById(R.id.e1);
        url = e.getText().toString();
        Intent i;
        if (view.getId() == browseButton.getId()) {        if(url.startsWith("http://"))
            i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        else
            i = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+url));

            startActivity(i);
        }

    }
}
