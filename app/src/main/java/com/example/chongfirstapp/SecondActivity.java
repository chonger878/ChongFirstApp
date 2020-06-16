package com.example.chongfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity{

    private TextView getName;
    private TextView getAge;
    private TextView getOccupation;
    private TextView getDescription;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activitya3);

        getName = findViewById(R.id.name);
        getAge = findViewById(R.id.age);
        getOccupation = findViewById(R.id.occupation);
        getDescription = findViewById(R.id.description);

        Intent intent = getIntent();
        Bundle db = intent.getExtras();

        String name = "";
        String age = "";
        String occupation = "";
        String description ="";

        if(db != null) {
            if(db.containsKey(Constants.KEY_NAME)){
                name = db.getString(Constants.KEY_NAME);
            }

            if(db.containsKey(Constants.KEY_AGE)){
                age = db.getString(Constants.KEY_AGE);
            }

            if(db.containsKey(Constants.KEY_OCCUPATION)){
                occupation = db.getString(Constants.KEY_OCCUPATION);
            }

            if(db.containsKey(Constants.KEY_DESC)){
                description = db.getString(Constants.KEY_DESC);
            }

        }
        getName.setText(name);
        getAge.setText(age);
        getOccupation.setText(occupation);
        getDescription.setText(description);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState.containsKey(Constants.KEY_NAME)){
            getName.setText((String)savedInstanceState.get(Constants.KEY_NAME));
            getAge.setText((String)savedInstanceState.get(Constants.KEY_AGE));
            getOccupation.setText((String)savedInstanceState.get(Constants.KEY_OCCUPATION));
            getDescription.setText((String)savedInstanceState.get(Constants.KEY_DESC));
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Constants.KEY_NAME, getName.getText().toString());
        outState.putString(Constants.KEY_AGE, getAge.getText().toString());
        outState.putString(Constants.KEY_OCCUPATION, getOccupation.getText().toString());
        outState.putString(Constants.KEY_DESC, getDescription.getText().toString());

    }


}





