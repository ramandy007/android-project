package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

class User{
    public   String name;
    public   String email;
    public   String password;
    public   String DOB;
    public   String mobile;
    public  String address;
    public    String institution;

    public User(){


    }

    public User(String name , String email,
                String password,
                String DOB,
                String mobile,
                String address,
                String institution){
        this.name=name;
        this.password=password;
        this.DOB=DOB;
        this.email=email;
        this.mobile=mobile;
        this.address=address;
        this.institution=institution;
    }


}

public class signup extends AppCompatActivity implements View.OnClickListener {
ImageView sign;
EditText nameEditText,emailEditText,passwordEditText,dobEditText,mobileEditText,addressEdittext,institutionEdittext;
private FirebaseAuth mauth;
ProgressDialog progressDialog ;
FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabase;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        nameEditText=findViewById(R.id.name);
        emailEditText=findViewById(R.id.email);
        passwordEditText=findViewById(R.id.password);
        dobEditText=findViewById(R.id.date);
        mobileEditText=findViewById(R.id.phonenumber);
        addressEdittext=findViewById(R.id.address);
        institutionEdittext=findViewById(R.id.institution);
        sign=findViewById(R.id.imageView);
        mauth=FirebaseAuth.getInstance();
        mDatabase = database.getReference("users");
        progressDialog=new ProgressDialog(this);


        sign.setOnClickListener( this);

    }



    private void registerUser(){
        String email =emailEditText.getText().toString().trim();
         String password = passwordEditText.getText().toString().trim();
        String name =nameEditText.getText().toString().trim();

        String DOB=dobEditText.getText().toString().trim();


        String mobile=mobileEditText.getText().toString().trim();
        String address=addressEdittext.getText().toString().trim();
        String institution=institutionEdittext.getText().toString().trim();
        String userId;
        final User user = new User(name , email,password,DOB,mobile,address,institution);


        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"please enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"please enter password",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(DOB)){
            Toast.makeText(this,"please enter dob",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(mobile)){
            Toast.makeText(this,"please enter mobile",Toast.LENGTH_SHORT).show();
            return;
        }  if (TextUtils.isEmpty(address)){
            Toast.makeText(this,"please enter address",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(institution)){
            Toast.makeText(this,"please enter institution",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(name)){
            Toast.makeText(this,"please enter name",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User");
        progressDialog.show();


        mauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

//

                 String userId= task.getResult().getUser().getUid();

                    Log.d("user_id",userId);


//                    String userId=mauth.getCurrentUser().getUid();
                    mDatabase.child(userId).setValue(user);

                    Toast.makeText(signup.this,"Registered Successsfully",Toast.LENGTH_LONG).show();
                    finish();
                    progressDialog.dismiss();
                }
                else  {
                    Toast.makeText(signup.this,"Could NOT register ,try again",Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();


                }


            }




        }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(signup.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mauth.getCurrentUser();

    }

    @Override
    public void onClick(View view) {
if(view == sign){
registerUser();



}


    }
}
