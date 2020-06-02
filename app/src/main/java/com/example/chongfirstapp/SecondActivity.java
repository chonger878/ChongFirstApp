package com.example.chongfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    TextView thankYou;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        thankYou = findViewById(R.id.thanks_msg);

        StringBuilder thanks = new StringBuilder("Thank you for signing up, \n");
        Intent intent = getIntent();
        Bundle db = intent.getExtras();


        if(db.containsKey(Constants.KEY_USERNAME)){
            String username = db.getString(Constants.KEY_USERNAME);
            thanks.append(username).append('\n');
        }else{
            thanks.append("Guest").append('\n');
        }

        thankYou.setText(thanks);

        Button goback =findViewById(R.id.go_back_button);
        goback.setOnClickListener(this);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState.containsKey(Constants.KEY_USERNAME)){
            thankYou.setText((String)savedInstanceState.get(Constants.KEY_USERNAME));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Constants.KEY_USERNAME, thankYou.getText().toString());
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}





