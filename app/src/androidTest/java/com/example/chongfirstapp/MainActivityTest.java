package com.example.chongfirstapp;

import android.content.Intent;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import androidx.test.espresso.intent.Intents;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

//@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

        @Rule
        public ActivityTestRule<MainActivity> mainActivityTestRule
                = new ActivityTestRule<>(MainActivity.class);
        @Before
        public void init(){
                Intent intent = new Intent();
                mainActivityTestRule.launchActivity(intent);
        }

        @Test
        public void canMoveOnToSecondActivity(){
                onView(withId(R.id.nameEditText)).perform(typeText("Erica Chong"));
                onView(withId(R.id.ageInput)).perform(typeText("28"));
                onView(withId(R.id.descriptionInput)).perform(typeText("A curious person"));
                onView(withId(R.id.occupationInput)).perform(typeText("Student"));



                try{
                        Intents.init();
                        onView(withId(R.id.submitButton)).perform(click());
                        intended(hasComponent(SecondActivity.class.getName()));
                        intended(hasExtra(Constants.KEY_NAME, "Erica Chong"));
                        intended(hasExtra(Constants.KEY_AGE, "28"));
                        intended(hasExtra(Constants.KEY_DESC, "A curious person"));
                        intended(hasExtra(Constants.KEY_OCCUPATION, "Student"));
                }finally{
                        Intents.release();
                }

        }


}