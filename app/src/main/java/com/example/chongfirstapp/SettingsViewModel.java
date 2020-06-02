package com.example.chongfirstapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class SettingsViewModel extends AndroidViewModel {
    private SettingsRepository sRepository;
    private LiveData<List<Settings>> sAllSettings;

    public SettingsViewModel(Application application) {
        super(application);
        sRepository = new SettingsRepository(application);
        sAllSettings = sRepository.getAllSettings();
    }

    LiveData<List<Settings>> getAllSettings(){
        return sAllSettings;
    }

    public void insert(Settings aSetting){
        sRepository.insert(aSetting);
    }
}
