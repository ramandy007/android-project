package com.example.set2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText name,phoneno;
    AutoCompleteTextView city;

    String[] City_name={"delhi","chennai","coimbatore","kolkata","mumbai","pune"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.button);

        name=findViewById(R.id.name);

        phoneno=findViewById(R.id.phone);
        city=findViewById(R.id.city);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,City_name);

        city.setThreshold(1);
        city.setAdapter(adapter);
        city.setTextColor(Color.BLUE);

        city.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                city.showDropDown();
                return false;
            }
        });


        Log.d("hai",name.getText().toString()+" "+phoneno.getText().toString()+" ");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((!name.getText().toString().isEmpty() && !phoneno.getText().toString().isEmpty() && !city.getText().toString().isEmpty() )){

//                    if(!phoneno.getText().toString().isEmpty()){
//
//                        if(!city.getText().toString().isEmpty()){

                            Intent i = new Intent(MainActivity.this,GoShopping.class);

                            i.putExtra("name",name.getText().toString());
                            i.putExtra("phone",phoneno.getText().toString());
                            i.putExtra("city",city.getText().toString());

                            startActivity(i);
                        }
                else{
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    // Setting Dialog Title
                    alertDialog.setTitle("Error!!");
                    // Setting Dialog Message
                    alertDialog.setMessage("\n\nEnter all fields!!");
                    // Setting Icon to Dialog
                    alertDialog.setIcon(R.drawable.ic_launcher_background);
                    // Setting Positive "Yes" Button
                    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "You clicked on OK :   "+which, Toast.LENGTH_SHORT).show();
                        }
                    });
                    // Showing Alert Message
                    alertDialog.show();

                }
                    }




            }
        );


    }

    @Override
    protected void onStart() {
        super.onStart();

        name.setText("");
        phoneno.setText("");
        city.setText("");
    }
}
