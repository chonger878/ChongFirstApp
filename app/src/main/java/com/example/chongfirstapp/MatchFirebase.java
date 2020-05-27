package com.example.chongfirstapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MatchFirebase extends AppCompatActivity {
    private FirebaseMatchViewModel matchViewModel;
    private TextView matchTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        matchViewModel = new FirebaseMatchViewModel();

        matchTextView = findViewById(R.id.matchFirebase);

        matchViewModel.getMatch((response) ->matchTextView.setText(response));

    }
}
