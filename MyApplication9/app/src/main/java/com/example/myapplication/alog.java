package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

class Source{
    Integer cost;

    public Source(Integer cost) {
        this.cost = cost;
    }
}
class Destination{
    Integer cost;

    public Destination(Integer cost) {
        this.cost = cost;
    }
}

class locations{
    public Source source;
    public Destination destination;

    public locations(Source source, Destination destination) {
        this.source = source;
        this.destination = destination;
    }

    public locations() {
    }
}

public class alog extends AppCompatActivity {
FirebaseDatabase mdatabase;
    Button pay;

    EditText source,destination,weight;
    TextView bill;

    FirebaseUser user;
    FirebaseAuth mauth ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alog);

        pay=findViewById(R.id.c);
        source= findViewById(R.id.source);
        destination=findViewById(R.id.destination);

        weight= findViewById(R.id.weight);
        bill= findViewById(R.id.Bill);
        mauth=FirebaseAuth.getInstance();
        user=mauth.getCurrentUser();
        mdatabase=FirebaseDatabase.getInstance();
        DatabaseReference locationref= mdatabase.getReference();

        locationref.child("location").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                locations  list = dataSnapshot.getValue(locations.class);
                System.out.println();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });






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

//                                              bill.setText(Integer.toString(num*15));

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.logout:
                Toast.makeText(this,mauth.getCurrentUser().getUid()+" Goodbye!!!",Toast.LENGTH_LONG).show();
                mauth.signOut();
                finish();
                return true;

            case R.id.settings:
                Toast.makeText(this,"settings shown",Toast.LENGTH_LONG).show();


                default:
                    return false;



        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        source.setText("");
        destination.setText("");
        bill.setText("");
    }

}
