package com.example.chongfirstapp;

import android.content.Context;

import androidx.room.Room;

public class AppDatabaseSingleton {

    private static AppDatabase data;

    public static AppDatabase getDatabase(Context context){
        if(data == null){
            data = Room.databaseBuilder(context, AppDatabase.class, "settings-database")
                    .build();

        }
        return data;
    }
}
