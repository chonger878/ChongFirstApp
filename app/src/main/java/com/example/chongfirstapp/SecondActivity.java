package com.example.chongfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity{

        public TextView getName;
        public TextView getAge;
        public TextView getOccupation;
        public TextView getDescription;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activitya3);

        Intent intent = getIntent();
        Bundle db = intent.getExtras();

        getName = findViewById(R.id.name);
        getAge = findViewById(R.id.age);
        getOccupation = findViewById(R.id.occupation);
        getDescription = findViewById(R.id.description);

        assert db != null;
        getName.setText(db.getString(Constants.KEY_NAME));
        getAge.setText(db.getString(Constants.KEY_AGE));
        getOccupation.setText(db.getString(Constants.KEY_OCCUPATION));
        getDescription.setText(db.getString(Constants.KEY_DESC));

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





