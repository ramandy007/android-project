package com.example.assignment;


import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class frag1 extends Fragment implements View.OnClickListener {

EditText name,movie,color;
Button add,show;
Communicactor comm;

SQLiteDatabase db;
public  ArrayList<String> i = new ArrayList<>();

    public frag1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view=inflater.inflate(R.layout.fragment_frag1, container, false);
        name= view.findViewById(R.id.editText);
        color = view.findViewById(R.id.editText2);
        movie = view.findViewById(R.id.editText3);
        add = view.findViewById(R.id.add);
        show = view.findViewById(R.id.show);
        add.setOnClickListener(frag1.this);
        show.setOnClickListener(frag1.this);
        Context context = getContext();
//        cursor =SQLiteDatabase.CursorFactory()
        db = context.openOrCreateDatabase("datadb",Context
                .MODE_PRIVATE,null);

        db.execSQL("create table if not exists data(name varchar,fav_color varchar,fav_movie varchar);");

        return view;
    }

    @Override
    public void onClick(View v) {

        if(comm==null){
            comm=(Communicactor)getActivity();

        }
    if (v==add){
        if(name.getText().toString().trim().length()==0 || color.getText().toString().trim().length()==0|| movie.getText().toString().trim().length()==0){
            showMessage("Error", "Please enter all values");
            return;
        }
        db.execSQL("insert into data values('" + name.getText() + "','" + color.getText() +
                "','" + movie.getText() + "');");
        showMessage("Success", "Record added");
        clearText();


    }
    else if(v==show){
        if(name.getText().toString().trim().length()==0)
        {
            showMessage("failure", "name is empty");
            clearText();

        }
        Cursor c =  db.rawQuery("Select * from data where name='"+name.getText().toString()+"';",null);
        if (c.moveToFirst()) {
            // Displaying record if found 
            Log.d("frag1",c.getString(0)+c.getString(1));
            name.setText(c.getString(0));
            movie.setText(c.getString(2));
            color.setText(c.getString(1));
            i.add(c.getString(0));
            i.add(c.getString(2));
            i.add(c.getString(1));
            Log.i("frag1 arraylist",i.toString());
            comm.respond(i);

        } else {
            showMessage("Error", "Invalid name");
            clearText();
        }

    }


    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText(){

        name.setText("");
        color.setText("");
        movie.setText("");
//        editRollno.requestFocus();
    }


}
