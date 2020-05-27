package com.example.chongfirstapp;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.util.Consumer;

import java.util.HashMap;

public class FirebaseMatchModel {
    private DatabaseReference getMatchDb;
    private HashMap<DatabaseReference, ValueEventListener> listeners;

    public FirebaseMatchModel(){
        getMatchDb = FirebaseDatabase.getInstance().getReference();
        listeners= new HashMap<>();
    }

    public void getMatch(final Consumer<DataSnapshot> dataChangedCallback, final Consumer<DatabaseError> dataErrorCallback)
    {
        DatabaseReference getMatchRef = getMatchDb.child("Matches");
        ValueEventListener getMatchListener = new ValueEventListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataChangedCallback.accept(dataSnapshot);
            }

            @SuppressLint("RestrictedApi")
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                dataErrorCallback.accept(databaseError);
            }
        };
        getMatchRef.addChildEventListener((ChildEventListener) getMatchListener);
        listeners.put(getMatchRef,getMatchListener);
    }


}
