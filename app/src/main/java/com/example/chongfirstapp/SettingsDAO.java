package com.example.chongfirstapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SettingsDAO {

    @Query("SELECT * FROM Settings")
    List<Settings> getAll();

    @Query("SELECT *  FROM Settings WHERE settingId IN (:settingId)")
    LiveData<List<Settings>> loadAllByIds(String[] settingId);

    @Update
    void updateSettings(Settings... setting);

    @Insert(onConflict= OnConflictStrategy.IGNORE)
    void insertAll(Settings... setting);

    @Delete
    void delete(Settings setting);
}

