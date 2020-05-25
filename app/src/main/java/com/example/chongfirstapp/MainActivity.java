package com.example.chongfirstapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText UserName;
    private EditText Email;
    private TextView birthDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Name = findViewById(R.id.nameEditText);
        UserName = findViewById(R.id.usernameEditText);
        Email = findViewById(R.id.emailEditText);
        birthDate = findViewById(R.id.getDate);
        Button submit = findViewById(R.id.submitButton);
        submit.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState.containsKey(Constants.KEY_BIRTH_DATE)){
            birthDate.setText((String)savedInstanceState.get(Constants.KEY_BIRTH_DATE));
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Constants.KEY_BIRTH_DATE, birthDate.getText().toString());
    }


    public void showBirthDateDialog(View v){
        DialogFragment newFragment = new DateDialog(birthDate);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }


    public void getSecondActivity(View view) throws ParseException {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle dataBundle = new Bundle();
        dataBundle.putString(Constants.KEY_NAME, Name.getText().toString());
        dataBundle.putString(Constants.KEY_USERNAME, UserName.getText().toString());
        dataBundle.putString(Constants.KEY_EMAIL, Email.getText().toString());
        dataBundle.putString(Constants.KEY_BIRTH_DATE, birthDate.getText().toString());
        intent.putExtras(dataBundle);
        SimpleDateFormat Formatter;
        Formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date getBirthDate = Formatter.parse(birthDate.toString());
        Date compareDate = Formatter.parse(Constants.PROHIBIT_BEFORE_DATE);

        if ( (getBirthDate != null) && (getBirthDate.before(compareDate))) {
            startActivity(intent);
        }
    }
}



