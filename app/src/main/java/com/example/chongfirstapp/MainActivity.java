package com.example.chongfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText getName;
    private EditText getAge;
    private EditText getDescription;
    private EditText getOccupation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buildprofilea3_main);
        Button submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(this);

        getName = findViewById(R.id.nameEditText);
        getAge = findViewById(R.id.age);
        getDescription= findViewById(R.id.description);
        getOccupation= findViewById(R.id.occupation);

    }


    public void getSecondActivity(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle dataBundle = new Bundle();
        dataBundle.putString(Constants.KEY_NAME, getName.getText().toString());
        dataBundle.putString(Constants.KEY_AGE, getAge.getText().toString());
        dataBundle.putString(Constants.KEY_DESC, getDescription.getText().toString());
        dataBundle.putString(Constants.KEY_OCCUPATION, getOccupation.getText().toString());
        intent.putExtras(dataBundle);
        startActivity(intent);

    }


    @Override
    public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);

    }
}

