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

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = SecondActivity.class.getSimpleName();
    private TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        StringBuilder thankyou = new StringBuilder("Thanks for signing up \n ");
        Intent intent = getIntent();
        Bundle db = intent.getExtras();

        String name = "Unknown";
        String username = "Unknown";
        String email = "null";
        String date = "2020-04-28";

        if(db != null)
        {
            if(db.containsKey(Constants.KEY_USERNAME))
            {
                username = db.getString(Constants.KEY_USERNAME);
            }
        }

        thankyou.append(username);
        Log.i(TAG, new StringBuilder("Username: ").append(username).toString());

        textview.setText(thankyou);
        Button goBackBtn=  findViewById(R.id.go_back_button);
        goBackBtn.setOnClickListener(this);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState.containsKey(Constants.KEY_TEXT_VIEW)){
            textview.setText(savedInstanceState.getString(Constants.KEY_TEXT_VIEW));
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(Constants.KEY_TEXT_VIEW, textview.toString());
    }



    @Override
    public void onClick(View v) {
        
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
