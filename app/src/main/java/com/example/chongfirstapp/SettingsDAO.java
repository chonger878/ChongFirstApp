package com.example.chongfirstapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface SettingsDAO {

    @Insert(onConflict= OnConflictStrategy.IGNORE)
    void insert(Settings aSetting);

    @Query("DELETE FROM Settings")
    void deleteAll();
}
