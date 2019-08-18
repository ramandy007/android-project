package com.blah.project.integr;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_sql,btn_dfrag,btn_sfrag,btn_btooth,btn_cam,btn_sms,btn_browse,btn_call,btn_ADialog,btn_eIntent,btn_img,btn_gridV,btn_spinn,btn_acTextView,btn_listV,btn_custLV,btn_dynRB,btn_etcbrb,btn_sis,btn_actLifeCycle,btn_onClickList,btn_gallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_sql = findViewById(R.id.btn_sql);
        btn_sql.setOnClickListener(this);
        btn_dfrag = findViewById(R.id.btn_dfrag);
        btn_dfrag.setOnClickListener(this);
        btn_sfrag = findViewById(R.id.btn_sfrag);
        btn_sfrag.setOnClickListener(this);
        btn_btooth = findViewById(R.id.btn_btooth);
        btn_btooth.setOnClickListener(this);
        btn_cam = findViewById(R.id.btn_cam);
        btn_cam.setOnClickListener(this);
        btn_sms = findViewById(R.id.btn_sms);
        btn_sms.setOnClickListener(this);
        btn_browse = findViewById(R.id.btn_browse);
        btn_browse.setOnClickListener(this);
        btn_call = findViewById(R.id.btn_call);
        btn_call.setOnClickListener(this);
        btn_ADialog = findViewById(R.id.btn_ADialog);
        btn_ADialog.setOnClickListener(this);
        btn_eIntent = findViewById(R.id.btn_eIntent);
        btn_eIntent.setOnClickListener(this);
        btn_img = findViewById(R.id.btn_img);
        btn_img.setOnClickListener(this);
        btn_gridV = findViewById(R.id.btn_gridV);
        btn_gridV.setOnClickListener(this);
        btn_spinn = findViewById(R.id.btn_spinn);
        btn_spinn.setOnClickListener(this);
        btn_acTextView = findViewById(R.id.btn_acTextView);
        btn_acTextView.setOnClickListener(this);
        btn_listV = findViewById(R.id.btn_listV);
        btn_listV.setOnClickListener(this);
        btn_custLV = findViewById(R.id.btn_custLV);
        btn_custLV.setOnClickListener(this);
        btn_dynRB = findViewById(R.id.btn_dynRB);
        btn_dynRB.setOnClickListener(this);
        btn_etcbrb = findViewById(R.id.btn_etcbrb);
        btn_etcbrb.setOnClickListener(this);
        btn_sis = findViewById(R.id.btn_sis);
        btn_sis.setOnClickListener(this);
        btn_actLifeCycle = findViewById(R.id.btn_actLifeCycle);
        btn_actLifeCycle.setOnClickListener(this);
        btn_onClickList = findViewById(R.id.btn_onClickList);
        btn_onClickList.setOnClickListener(this);
        btn_gallery = findViewById(R.id.btn_gallery);
        btn_gallery.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuuu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help:
                Toast.makeText(getApplicationContext(), "you've been helped",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.more_help:
                Toast.makeText(getApplicationContext(), "you've been helped more",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.even_more_help:
                return true;
            default:
                return false;
        }
    }




                @Override
    public void onClick(View v) {
        if(v == btn_sql){
           // Toast.makeText(this, "sel", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(this, sql.class);
            startActivity(in);
        }
        else if(v == btn_dfrag){
            Intent in = new Intent(this,dyn_frag.class);
            startActivity(in);
        }
        else if(v == btn_sfrag){
            Intent in = new Intent(this,statFrag.class);
            startActivity(in);
        }
        else if(v == btn_btooth){
            Intent in = new Intent(this,Bluetooth.class);
            startActivity(in);
        }
        else if(v == btn_cam){
            Intent in = new Intent(this,Cam.class);
            startActivity(in);
        }
        else if(v == btn_sms){
            Intent in = new Intent(this,SMS.class);
            startActivity(in);
        }
        else if(v == btn_browse){
            Intent in = new Intent(this,Browse.class);
            startActivity(in);
        }
        else if(v == btn_call){
            Intent in = new Intent(this,Call.class);
            startActivity(in);
        }
        else if(v == btn_ADialog){
            Intent in = new Intent(this,AlertD.class);
            startActivity(in);
        }
        else if(v == btn_eIntent){
            Intent in = new Intent(this,eIntent.class);
            startActivity(in);
        }
        else if(v == btn_img){
            Intent in = new Intent(this,imageb.class);
            startActivity(in);
        }
        else if(v == btn_gridV){
            Intent in = new Intent(this,gridV.class);
            startActivity(in);
        }
        else if(v == btn_spinn){
            Intent in = new Intent(this,spinnerr.class);
            startActivity(in);
        }
        else if(v == btn_acTextView){
            Intent in = new Intent(this,acTextView.class);
            startActivity(in);
        }
        else if(v == btn_listV){
            Intent in = new Intent(this,listV.class);
            startActivity(in);
        }
        else if(v == btn_custLV){
            Intent in = new Intent(this,customLV.class);
            startActivity(in);
        }
        else if(v == btn_dynRB){
            Intent in = new Intent(this,dynamicRB.class);
            startActivity(in);
        }
        else if(v == btn_etcbrb){
            Intent in = new Intent(this,etcbrb.class);
            startActivity(in);
        }
        else if(v == btn_sis){
            Intent in = new Intent(this,savInstanceState.class);
            startActivity(in);
        }
        else if(v == btn_actLifeCycle){
            Intent in = new Intent(this,actLifeCycle.class);
            startActivity(in);
        }
        else if(v == btn_onClickList){
            Intent in = new Intent(this,onClickList.class);
            startActivity(in);
        }
        else if(v == btn_gallery){
            Intent in = new Intent(this,gallery.class);
            startActivity(in);
        }

    }
}





