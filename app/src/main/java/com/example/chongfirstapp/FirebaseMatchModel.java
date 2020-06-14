package com.example.chongfirstapp;

import android.annotation.SuppressLint;


import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.function.Consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseMatchModel {
    private FirebaseFirestore getMatchDb;
    private List<ListenerRegistration> listeners;

    public FirebaseMatchModel(){
        getMatchDb = FirebaseFirestore.getInstance();
        listeners= new ArrayList<>();
    }

    public void addMatch(MatchItem match){
        CollectionReference matchItemRef = getMatchDb.collection("matches");
    }

    public void getMatches(final Consumer<QuerySnapshot> dataChangedCallback, final Consumer<FirebaseFirestoreException> dataErrorCallback) {
        ListenerRegistration getMatchRef = getMatchDb.collection("matches")
                .addSnapshotListener((queryDocumentSnapshots, e) -> {
                    if (e != null) {
                        dataErrorCallback.accept(e);
                    }
                    dataChangedCallback.accept(queryDocumentSnapshots);
                });
        listeners.add(getMatchRef);
    }

    public void updateMatchesById(MatchItem match){
        DocumentReference matchesRef = getMatchDb.collection("matches").document(match.getUid());
        Map<String, Object> mData = new HashMap<>();
        mData.put("uid", match.getUid());
        mData.put("imageUrl", match.getImageUrl());
        mData.put("name", match.getMatchesName());
        mData.put("liked", match.getLiked());
        mData.put("latitude", match.getLat());
        mData.put("longitude", match.getLongitude());
        matchesRef.update(mData);
    }

    public void clear(){
        listeners.forEach(ListenerRegistration::remove);
    }
    }




