package com.example.chongfirstapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "Settings")
public class Settings {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="Settings")
    private String word;

    public Settings(String word){
        this.word = word;

    }

    public String getWord(){
        return this.word;
    }
}
