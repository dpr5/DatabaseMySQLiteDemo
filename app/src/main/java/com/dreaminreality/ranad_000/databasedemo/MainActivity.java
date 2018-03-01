package com.dreaminreality.ranad_000.databasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ranad_000 on 2/27/2018.
 */



public class MainActivity extends AppCompatActivity{


    private static final String TAG = "MAINACTIVITY";

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd, btnViewData;
    private EditText editText;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnViewData = (Button)findViewById(R.id.btnView);

        mDatabaseHelper = new DatabaseHelper(this);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = editText.getText().toString();
                if (editText.length() != 0) {
                    AddData(newEntry);
                    editText.setText("");
                }else{
                    toastMessage("You must enter data into text feild");
                }
            }
        });

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
                startActivity(intent);
            }
        });



    }

    public void AddData(String newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if(insertData){
            toastMessage("Data Successfully Inserted!");
        }else{
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage (String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
