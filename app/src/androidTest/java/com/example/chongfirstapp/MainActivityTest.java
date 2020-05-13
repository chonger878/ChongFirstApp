package com.example.chongfirstapp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

        @Rule
        public ActivityScenarioRule<MainActivity>activityScenarioRule
                = new ActivityScenarioRule<>(MainActivity.class);

        public void hasTextOnScreen(){
                onView(withId(R.id.welcome))
                        .check((matches(withText(R.string.welcome_msg))));
        }






}