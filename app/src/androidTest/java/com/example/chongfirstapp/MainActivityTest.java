package com.example.chongfirstapp;

import android.provider.ContactsContract;
import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static  androidx.test.espresso.action.ViewActions.typeText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

        @Rule
        public ActivityScenarioRule<MainActivity>activityScenarioRule
                = new ActivityScenarioRule<>(MainActivity.class);








}