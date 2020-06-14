package com.example.chongfirstapp;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class MatchItem implements Parcelable {
    public String uid;
    public String imageUrl;
    public boolean liked;
    public String name;
    public String lat;
    public String longitude;


    public MatchItem(){
        //STUB
    }

    public String getUid(){
        return uid;
    }

    public void setUid(String uid){
        this.uid = uid;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public boolean getLiked(){
        return liked;
    }

    public void setLiked(Boolean liked){
        this.liked = liked;
    }

    public String getMatchesName(){
        return name;
    }

    public void setMatchesName(String name){
        this.name = name;
    }

    public String getLat(){
        return lat;
    }

    public void setLatitude(String lat){
        this.lat = lat;
    }

    public String getLongitude(){
        return longitude;
    }

    public void setLongitude(String longitude){
        this.longitude = longitude;
    }

    protected MatchItem(Parcel in) {
        uid = in.readString();
        imageUrl = in.readString();
        liked = in.readByte() != 0;
        name = in.readString();
        lat = in.readString();
        longitude = in.readString();
    }

    public static final Creator<MatchItem> CREATOR = new Creator<MatchItem>() {
        @Override
        public MatchItem createFromParcel(Parcel in) {
            return new MatchItem(in);
        }

        @Override
        public MatchItem[] newArray(int size) {
            return new MatchItem[size];
        }
    };

    @Exclude
    public Map<String,Object> toMap(){
        HashMap<String,Object> dataBundle = new HashMap<>();
            dataBundle.put("uid", uid);
            dataBundle.put("imageUrl", imageUrl);
            dataBundle.put("liked", liked);
            dataBundle.put("name", name);
            dataBundle.put("lat", lat);
            dataBundle.put("longitude", longitude);

            return dataBundle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(uid);
        dest.writeString(imageUrl);
        dest.writeByte((byte) (liked ? 1 : 0));
        dest.writeString(name);
        dest.writeString(lat);
        dest.writeString(longitude);
    }
}
