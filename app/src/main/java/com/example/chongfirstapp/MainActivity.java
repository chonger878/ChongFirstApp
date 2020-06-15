package com.example.chongfirstapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText setAge;
    private EditText setOccupation;
    private EditText setDescription;
    private EditText setEmail;
    private FragmentManager fManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buildprofilea3_main);
        fManager = getSupportFragmentManager();

        Name = findViewById(R.id.nameEditText);
        setAge = findViewById(R.id.ageInput);
        setOccupation= findViewById(R.id.occupationInput);
        setDescription = findViewById(R.id.descriptionInput);
        setEmail = findViewById(R.id.emailEditText);

    }

    public void getSecondActivity(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle dataBundle = new Bundle();
        dataBundle.putString(Constants.KEY_NAME, Name.getText().toString());
        dataBundle.putString(Constants.KEY_AGE, setAge.getText().toString());
        dataBundle.putString(Constants.KEY_OCCUPATION, setOccupation.getText().toString());
        dataBundle.putString(Constants.KEY_DESC, setDescription.getText().toString());
        dataBundle.putString(Constants.KEY_EMAIL, setEmail.getText().toString());

        Bundle args = new Bundle();
        String getName = Name.getText().toString();
        String getAge = setAge.getText().toString();
        String getOccupation = setOccupation.getText().toString();
        String getDescription = setDescription.getText().toString();
        String getEmail = setEmail.getText().toString();

        args.putString(Constants.KEY_NAME, getName);
        args.putString(Constants.KEY_AGE, getAge);
        args.putString(Constants.KEY_OCCUPATION, getOccupation);
        args.putString(Constants.KEY_DESC, getDescription);
        args.putString(Constants.KEY_EMAIL, getEmail);

        ProfileFragment showProfile = new ProfileFragment(args);
        showProfile.setArguments(args);

        FragmentTransaction fTransaction = fManager.beginTransaction();
        fTransaction.replace(R.id.frame_layout, showProfile).commit();
        startActivity(intent);

    }


}



