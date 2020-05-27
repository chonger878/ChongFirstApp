package com.example.chongfirstapp;

import android.annotation.SuppressLint;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.firestore.util.Consumer;

public class FirebaseMatchViewModel {
    private FirebaseMatchModel matchModel;

    public FirebaseMatchViewModel() {
        matchModel = new FirebaseMatchModel();
    }

    @SuppressLint("RestrictedApi")
    public void getMatch(final Consumer<String> resultCallback) {
        matchModel.getMatch(
                new Consumer<DataSnapshot>() {
                    @Override
                    public void accept(DataSnapshot dataSnapshot) {
                        String val = dataSnapshot.getValue(String.class);
                        resultCallback.accept(val);
                    }
                },
                (new Consumer<DatabaseError>() {
                    @Override
                    public void accept(DatabaseError databaseError) {
                        System.out.println(databaseError + " is not valid");
                    }
                })
        );
    }

}
