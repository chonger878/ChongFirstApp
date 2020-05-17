package com.example.chongfirstapp;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText Name;
    private EditText UserName;
    private EditText Email;
    private EditText txtDate;
    private int byear,bmonth, bday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDate = findViewById(R.id.getDate);
        final Button getDate = findViewById(R.id.pickbirthdate);
        getDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar dob = Calendar.getInstance();
                byear = dob.get(Calendar.YEAR);
                bmonth =  dob.get(Calendar.MONTH);
                bday = dob.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog getDateDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            txtDate.setText(year + "-" + month+1 + "-" +dayOfMonth);
                    }
                }, byear, bmonth,bday);
                getDateDialog.show();
            }
        });
        Button submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(this);



         Name = findViewById(R.id.nameEditText);
        UserName = findViewById(R.id.usernameEditText);
         Email= findViewById(R.id.emailEditText);




    }
    



    public void getSecondActivity(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle dataBundle = new Bundle();
        dataBundle.putString(Constants.KEY_NAME, Name.getText().toString());
        dataBundle.putString(Constants.KEY_USERNAME, UserName.getText().toString());
        dataBundle.putString(Constants.KEY_EMAIL, Email.getText().toString());
        intent.putExtras(dataBundle);
        startActivity(intent);

    }

    public void onClick(View v) {
        String getDate = txtDate.getText().toString();
        if(getDate.compareTo(Constants.PROHIBIT_BEFORE_DATE) < 0) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    }

}

