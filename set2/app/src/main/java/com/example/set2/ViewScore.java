package com.example.set2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewScore extends AppCompatActivity {

    TextView bill;

    Button go;
    String url,bill1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_score);
        bill=findViewById(R.id.Bill);
        go=findViewById(R.id.button2);
        Bundle c=getIntent().getExtras();
         String name=c.getString("name");
         String phone=c.getString("phone");
         bill1 = c.getString("score");
        bill.setText(bill1);
        Toast.makeText(ViewScore.this," is selected "+bill1, Toast.LENGTH_SHORT).show();

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                url="https://www.xyzpaymentprocessor.com/amount="+bill1;
                Intent   i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);

            }
        });


    }
}
