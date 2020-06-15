package com.example.chongfirstapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "Settings")
public class Settings {

    @PrimaryKey
    @NonNull
    private String settingId;

    @ColumnInfo(name = "matches_reminder_time")
    private String dailyMatchesReminderTime;

    @ColumnInfo(name = "max_distance_search")
    private String maximumDistanceResearch;

    @ColumnInfo(name= "gender")
    private String gender;

    @ColumnInfo(name = "account_type")
    private String accountType;

    @ColumnInfo(name = "interested_age_range")
    private String interestedAgeRange;

    public String getSettingId(){
        return settingId;
    }

    public void setSettingId(@NonNull String settingId){
        this.settingId = settingId;
    }

    public String getDailyMatchesReminderTime(){
        return dailyMatchesReminderTime;
    }

    public void setDailyMatchesReminderTime(@NonNull String dailyMatchesReminderTime){
        this.dailyMatchesReminderTime = dailyMatchesReminderTime;
    }

    public String getMaximumDistanceResearch(){
        return maximumDistanceResearch;
    }

    public void setMaximumDistanceResearch(@NonNull String maximumDistanceResearch){
        this.maximumDistanceResearch = maximumDistanceResearch;

    }

    public String getGender(){
        return gender;
    }

    public void setGender(@NonNull String gender){
        this.gender = gender;
    }

    public String getAccountType(){
        return accountType;
    }

    public void setAccountType(@NonNull String accountType){
        this.accountType = accountType;
    }

    public String getInterestedAgeRange(){
        return interestedAgeRange;
    }

    public void setInterestedAgeRange(@NonNull String interestedAgeRange){
        this.interestedAgeRange = interestedAgeRange;
    }
}

