package com.example.databasedb;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editRollno, editName, editMarks;
    Button btnAdd, btnDelete, btnModify, btnViewAll, btnShowInfo, btnView;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editRollno = (EditText) findViewById(R.id.editRollno);
        editName = (EditText) findViewById(R.id.editName);
        editMarks = (EditText) findViewById(R.id.editMarks);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnModify = (Button) findViewById(R.id.btnModify);
        btnView = (Button) findViewById(R.id.btnView);
        btnViewAll = (Button) findViewById(R.id.btnViewAll);
        btnShowInfo = (Button) findViewById(R.id.btnShowInfo);
        //Registering Event Handlers
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnModify.setOnClickListener(this);
        btnView.setOnClickListener(this);
        btnViewAll.setOnClickListener(this);
        btnShowInfo.setOnClickListener(this);
        // Creating database and table  
        db = openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR,name VARCHAR,marks VARCHAR);");
    }

    @Override
    public void onClick(View view) {
        // Adding a record
        if (view == btnAdd) {
            // Checking empty fields
            if (editRollno.getText().toString().trim().length() == 0 || editName.getText().toString().trim().length() == 0 ||
                    editMarks.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter all values");
                return;
            }
            // Inserting record 
            db.execSQL("INSERT INTO student VALUES('" + editRollno.getText() + "','" + editName.getText() +
                    "','" + editMarks.getText() + "');");
            showMessage("Success", "Record added");
            clearText();
        }
        // Deleting a record 
        if (view == btnDelete) {
            // Checking empty roll number 
            if (editRollno.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter Rollno");
                return;
            }
            // Searching roll number 
            Cursor c = db.rawQuery("SELECT * FROM student WHERE rollno='" + editRollno.getText() + "'", null);
            if (c.moveToFirst()) {
                // Deleting record if found 
                showMessage("Success", "Record Deleted");
                db.execSQL("DELETE FROM student WHERE rollno='" + editRollno.getText() + "'");
            } else {
                showMessage("Error", "Invalid Rollno");
            }
            clearText();
        }
        // Modifying a record 
        if (view == btnModify) {
            // Checking empty roll number 
            if (editRollno.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter Rollno");
                return;
            }
            // Searching roll number 
            Cursor c = db.rawQuery("SELECT * FROM student WHERE rollno='" + editRollno.getText() + "'", null);
            if (c.moveToFirst()) {
                // Modifying record if found 
                db.execSQL("UPDATE student SET name='" + editName.getText() + "',marks='" + editMarks.getText() +
                        "' WHERE rollno='" + editRollno.getText() + "'");
                showMessage("Success", "Record Modified");
            }
            else {
                showMessage("Error", "Invalid Rollno");
            }
            clearText();
        }
        // Viewing a record 
        if (view == btnView) {
            // Checking empty roll number 
            if (editRollno.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter Rollno");
                return;
            }
            // Searching roll number 
            Cursor c = db.rawQuery("SELECT * FROM student WHERE rollno='" + editRollno.getText() + "'", null);
            if (c.moveToFirst()) {
                // Displaying record if found 
                editName.setText(c.getString(1));
                editMarks.setText(c.getString(2));
            } else {
                showMessage("Error", "Invalid Rollno");
                clearText();
            }
        }
        // Viewing all records 
        if (view == btnViewAll) {
            // Retrieving all records 
            Cursor c = db.rawQuery("SELECT * FROM student", null);
            // Checking if no records found 
            if (c.getCount() == 0) {
                showMessage("Error", "No records found");
                return;
            }
            // Appending records to a string buffer 
            StringBuffer buffer = new StringBuffer();
            while (c.moveToNext())
            {
                buffer.append("Rollno: " + c.getString(0) + "\n");
                buffer.append("Name: " + c.getString(1) + "\n");
                buffer.append("Marks: " + c.getString(2) + "\n\n");
            }
            // Displaying all records 
            showMessage("Student Details", buffer.toString());
        }
        // Displaying info 
        if (view == btnShowInfo){
            showMessage("SQLite demo", "SQLite Connectivity");
        }
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText(){

        editRollno.setText("");
        editName.setText("");
        editMarks.setText("");
        editRollno.requestFocus();
    }
}



