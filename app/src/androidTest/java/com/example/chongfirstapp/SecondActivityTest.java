package com.example.chongfirstapp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)

public class SecondActivityTest {

    @Rule
    public ActivityScenarioRule<SecondActivity>activityScenarioRule
            = new ActivityScenarioRule<>(SecondActivity.class);
}
