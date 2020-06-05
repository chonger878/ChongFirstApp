package com.example.chongfirstapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    private EditText setName;
    private EditText setAge;
    private EditText setOccupation;
    private EditText setDescription;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buildprofilea3_main);


        setName = findViewById(R.id.nameEditText);
        setAge = findViewById(R.id.ageInput);
        setOccupation = findViewById(R.id.occupationInput);
        setDescription = findViewById(R.id.descriptionInput);

    }



    public void getSecondActivity(View view){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle dataBundle = new Bundle();
        dataBundle.putString(Constants.KEY_NAME, setName.getText().toString());
        dataBundle.putString(Constants.KEY_AGE, setAge.getText().toString());
        dataBundle.putString(Constants.KEY_OCCUPATION, setOccupation.getText().toString());
        dataBundle.putString(Constants.KEY_DESC, setDescription.getText().toString());
        intent.putExtras(dataBundle);
        startActivity(intent);

    }


}



