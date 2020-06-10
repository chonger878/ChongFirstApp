package com.example.chongfirstapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText setAge;
    private EditText setOccupation;
    private TextView setDescription;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buildprofilea3_main);

        Name = findViewById(R.id.nameEditText);
        setAge = findViewById(R.id.ageInput);
        setOccupation= findViewById(R.id.occupationInput);
        setDescription = findViewById(R.id.descriptionInput);

    }

    public void getSecondActivity(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle dataBundle = new Bundle();
        Fragment ProfileFragment = new ProfileFragment();
        dataBundle.putString(Constants.KEY_NAME, Name.getText().toString());
        dataBundle.putString(Constants.KEY_AGE, setAge.getText().toString());
        dataBundle.putString(Constants.KEY_OCCUPATION, setOccupation.getText().toString());
        dataBundle.putString(Constants.KEY_DESC, setDescription.getText().toString());
        startActivity(intent);

    }


}



