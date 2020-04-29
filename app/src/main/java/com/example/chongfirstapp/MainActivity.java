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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText getName;
    private EditText getEmail;
    private EditText getUserName;
    private TextView birthdate;
    private String birthDatestring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submit= findViewById(R.id.submitButton);
        submit.setOnClickListener(this);
        Button getbirthdate = findViewById(R.id.getBirthDate);
        getbirthdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        getName= findViewById(R.id.nameEditText);
        getEmail= findViewById(R.id.emailEditText);
        getUserName= findViewById(R.id.usernameEditText);
        birthdate = findViewById(R.id.dateview);
    }


    public void getSecondActivity(View view)
    {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            Bundle dataBundle = new Bundle();
            dataBundle.putString(Constants.KEY_NAME, getName.getText().toString());
            dataBundle.putString(Constants.KEY_EMAIL, getEmail.getText().toString());
            dataBundle.putString(Constants.KEY_USERNAME, getUserName.getText().toString());
            dataBundle.putString(Constants.KEY_BIRTH_DATE, birthDatestring);
            intent.putExtras(dataBundle);
            startActivity(intent);
            onRestart();
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.submitButton &&  birthDatestring.compareTo(Constants.PROHIBIT_BEFORE_DATE) <= 0)
        {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
