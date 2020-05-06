package com.example.chongfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {


    private String name;
    private String age;
    private String occupation;
    private String description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activitya3);
        final TextView textviewName = findViewById(R.id.getName);
        final TextView tvAge = findViewById(R.id.getAge);
        final TextView tvOccupation = findViewById(R.id.getOccupation);
        final TextView tvDesc = findViewById(R.id.getDescription);
        Intent intent = getIntent();
        Bundle db = intent.getExtras();


        if (db != null) {
                name = db.getString(Constants.KEY_NAME);
                age = db.getString(Constants.KEY_AGE);
                occupation= db.getString(Constants.KEY_OCCUPATION);
                description= db.getString(Constants.KEY_DESC);

        }


        textviewName.setText(name);
        tvAge.setText(age);
        tvOccupation.setText(occupation);
        tvDesc.setText(description);




    }





}





