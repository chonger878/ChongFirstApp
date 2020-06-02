package com.example.chongfirstapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class SettingsRepository {
    private SettingsDAO aSettingDAO;
    private LiveData<List<Settings>> allSettings;

    SettingsRepository(Application app){
        SettingsRoomDatabase sdb = SettingsRoomDatabase.getSettingsDatabase(app);
        aSettingDAO = sdb.settingsDAO();
    }

    LiveData<List<Settings>> getAllSettings(){
        return allSettings;
    }

    void insert(Settings addSetting){
        SettingsRoomDatabase.databaseSettingsExecutor.execute(() -> {
            aSettingDAO.insert(addSetting);
        });
    }
}
