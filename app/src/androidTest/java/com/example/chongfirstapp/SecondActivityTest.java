package com.example.chongfirstapp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)

public class SecondActivityTest {

    @Rule
    public ActivityScenarioRule<SecondActivity>activityScenarioRule
            = new ActivityScenarioRule<>(SecondActivity.class);



}
