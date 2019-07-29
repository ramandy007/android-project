package com.example.trial;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView t1,t2;
    EditText ed1,ed2;

    Button b1,b2;
    RadioGroup rbg1;
    RadioButton rb1,rb2,rb3,rb4;
    ListView lv1;

    String array[]= {"Apple","Android","Palm","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.textView1);
        t2=findViewById(R.id.textView2);
        b1=findViewById(R.id.button2);
        b2=findViewById(R.id.button1);
        rbg1=findViewById(R.id.rgb1);
        rb1=findViewById(R.id.radioButton1);
        rb2=findViewById(R.id.radioButton2);
        rb3=findViewById(R.id.radioButton3);
        rb4=findViewById(R.id.radioButton4);
        ed1=findViewById(R.id.editText1);
        ed2=findViewById(R.id.editText2);
        lv1=findViewById(R.id.listview1);


        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.listview,array);
//

        lv1.setAdapter(adapter);





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity", "onClick: clicked");
                Toast.makeText(getApplicationContext(),ed2.getText()+" "+getApplicationContext()+" "+getBaseContext()+" "+getLocalClassName(),Toast.LENGTH_SHORT).show();
                Log.i("this"," function called from on create " +getApplication()+" "+getApplicationContext()+" "+this+" "+getBaseContext()+" "+getLocalClassName());

            }
        });



        t1.setOnClickListener(btnListener);
        rb3.setOnClickListener(radioListener);
        rb4.setOnClickListener(radioListener);






    }
    private   View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"anonymous function called "+getApplication()+" "+getApplicationContext()+" "+this,Toast.LENGTH_LONG).show();
            Log.i("this","anonymous function called "+getApplication()+" "+getApplicationContext()+" "+this+" "+getBaseContext()+" "+getLocalClassName());
        }
    };

    public void btnListener(View view){
        Toast.makeText(getApplicationContext(), "called via xml "+view.getId(),Toast.LENGTH_SHORT).show();
        Log.i("this","from xml function called "+getApplication()+" "+getApplicationContext()+" "+this+" "+getBaseContext()+" "+getLocalClassName());
         Intent i=new Intent(getApplicationContext(),Main2Activity.class);


         startActivity(i);


    }

    public void radioListener(View view) {
        Toast.makeText(getApplicationContext(), getResources().getResourceEntryName(view.getId()), Toast.LENGTH_SHORT).show();
        boolean checked = ((RadioButton) view).isChecked();

        if (checked) {
            Toast.makeText(getApplicationContext(), ((RadioButton) view).getText(), Toast.LENGTH_SHORT).show();
            Log.i("this","from xml function called "+((RadioButton) view).getText()+""+view.toString()+" "+getApplicationContext()+" "+this+" "+getBaseContext()+" "+getLocalClassName());


        }
    }

    private View.OnClickListener radioListener;

    {
        radioListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), getResources().getResourceEntryName(v.getId()), Toast.LENGTH_SHORT).show();
                boolean checked = ((RadioButton) v).isChecked();

                if (checked) {
                    Toast.makeText(getApplicationContext(), ((RadioButton) v).getText(), Toast.LENGTH_SHORT).show();
                    Log.i("this", "from named listener function called " + ((RadioButton) v).getText() + "" + v.toString() + " " + getApplicationContext() + " " + this + " " + getBaseContext() + " " + getLocalClassName());


                }
//                Intent contact = new Intent();
//                contact.setAction(Intent.ACTION_VIEW);
//                contact.setData(ContactsContract.Contacts.CONTENT_URI);
            }
        };
    }


}

