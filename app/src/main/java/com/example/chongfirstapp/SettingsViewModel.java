package com.example.chongfirstapp;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class SettingsViewModel extends ViewModel {

    private AppDatabase data;

    public LiveData<List<Settings>> loadByAllIds (Context context, String[] settingIds){
        data = AppDatabaseSingleton.getDatabase(context);
        return data.settingsDAO().loadAllByIds(settingIds);
    }

    public void updateSettings(Context context, Settings... settings)
    {
        data = AppDatabaseSingleton.getDatabase(context);
        data.getTransactionExecutor().execute(() -> {
                data.settingsDAO().updateSettings(settings);
        });
    }

    public void insertAll(Context context, Settings... settings){
        data= AppDatabaseSingleton.getDatabase(context);
        data.getTransactionExecutor().execute(() -> {
            data.settingsDAO().insertAll(settings);
        });
    }

    public void deleteSettings(Context context, Settings settings){
        data = AppDatabaseSingleton.getDatabase(context);
        data.getTransactionExecutor().execute(() -> {
            data.settingsDAO().delete(settings);
        });
    }


}
