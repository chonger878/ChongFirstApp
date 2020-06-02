package com.example.chongfirstapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities={Settings.class}, version=1, exportSchema = false)
public abstract class SettingsRoomDatabase extends RoomDatabase {

    public abstract SettingsDAO settingsDAO();

    private static volatile SettingsRoomDatabase INSTANCE;
    static final ExecutorService databaseSettingsExecutor =
            Executors.newFixedThreadPool(Constants.NUMBER_OF_THREADS);

    static SettingsRoomDatabase getSettingsDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (SettingsRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SettingsRoomDatabase.class,"Settings")
                            .addCallback(settingsRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback settingsRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase sDb){
            super.onOpen(sDb);

            databaseSettingsExecutor.execute(() -> {
                SettingsDAO dao = INSTANCE.settingsDAO();
                dao.deleteAll();

                Settings setting = new Settings("Set Daily Reminder to View Matches");
                dao.insert(setting);
                setting = new Settings("Maximum distance(in miles)");
                dao.insert(setting);
                setting = new Settings("Gender");
                dao.insert(setting);
                setting = new Settings("Set to Private");
                dao.insert(setting);
                setting = new Settings("Age Range");
                dao.insert(setting);
            });
        }
    };


}
