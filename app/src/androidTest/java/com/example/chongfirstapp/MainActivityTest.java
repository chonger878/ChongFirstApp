package com.example.chongfirstapp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

        @Rule
        public ActivityScenarioRule<MainActivity>activityScenarioRule
                = new ActivityScenarioRule<>(MainActivity.class);

        @Test
        public void canMoveToSecondActivity(){
            onView(withId(R.id.nameEditText))
                    .perform(typeText(Constants.KEY_TEST_NAME),closeSoftKeyboard());
            onView(withId(R.id.ageInput))
                    .perform(typeText(Constants.KEY_TEST_AGE), closeSoftKeyboard());
            onView(withId(R.id.occupationInput))
                    .perform(typeText(Constants.KEY_TEST_OCCUPATION),closeSoftKeyboard());
            onView(withId(R.id.descriptionInput))
                    .perform(typeText(Constants.KEY_TEST_DESCRIPTION), closeSoftKeyboard());
            onView(withId(R.id.submitButton))
                    .perform(click());
        }






}