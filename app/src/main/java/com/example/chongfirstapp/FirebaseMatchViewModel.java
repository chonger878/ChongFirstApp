package com.example.chongfirstapp;


import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.function.Consumer;

public class FirebaseMatchViewModel {
    private FirebaseMatchModel matchModel;

    public FirebaseMatchViewModel() {
        matchModel = new FirebaseMatchModel();
    }


    public void addMatch(MatchItem match) {
        matchModel.addMatch(match);
    }

    public void getMatches(Consumer<ArrayList<MatchItem>> responseCallback){
        matchModel.getMatches((QuerySnapshot querySnapshot) -> {
            if (querySnapshot != null) {
                ArrayList<MatchItem> matchItems = new ArrayList<>();
                for (DocumentSnapshot matchSnapshot : querySnapshot.getDocuments()) {
                    MatchItem match = matchSnapshot.toObject(MatchItem.class);
                    assert match != null;
                    match.uid = matchSnapshot.getId();
                    match.name = matchSnapshot.get("name").toString();
                    match.liked = matchSnapshot.getBoolean("liked");
                    match.imageUrl = matchSnapshot.get("imageUrl").toString();
                    match.lat = matchSnapshot.get("lat").toString();
                    match.longitude = matchSnapshot.get("longitude").toString();
                    matchItems.add(match);
                }
                responseCallback.accept(matchItems);
            }
        },
            (databaseError -> System.out.println("Error reading Match Items: " + databaseError))
        );

    }

    public void updateMatches(MatchItem match){
        matchModel.updateMatchesById(match);

    }

    public void clear(){
        matchModel.clear();
    }
}

