package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
Button sign;
EditText emailEdittext,passwordEdittext;
ProgressDialog progressDialog;
private FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sign=findViewById(R.id.button);
        emailEdittext=findViewById(R.id.editText);
        progressDialog=new ProgressDialog(this);
        mauth = FirebaseAuth.getInstance();

        if (mauth.getCurrentUser()!= null){

            finish();
            Intent i=new Intent(login.this,alog.class);
            startActivity(i);

        }

        passwordEdittext=findViewById(R.id.editText2);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i=new Intent(login.this,alog.class);
//                startActivity(i);
                userLogin();
            }
        });
    }

    private  void userLogin(){
        String email = emailEdittext.getText().toString().trim();
        String password = passwordEdittext.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"please enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"please enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Logging in please wait");
        progressDialog.show();

        mauth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
               if (task.isSuccessful()) {
                   finish();
                    Intent i=new Intent(login.this,alog.class);
                startActivity(i);
                }
               else  {
                   Toast.makeText(login.this,"Could NOT Signin ,try again",Toast.LENGTH_LONG).show();



               }
            }
        }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(login.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });





    }
}
