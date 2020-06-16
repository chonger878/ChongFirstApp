package com.example.chongfirstapp;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

        @Rule
        public ActivityTestRule<MainActivity> mainActivityTestRule
                = new ActivityTestRule<>(MainActivity.class);

        @Test
        public void canMoveOnToSecondActivity(){
                onView(withId(R.id.nameEditText)).perform(typeText("Erica Chong"));
                onView(withId(R.id.emailEditText)).perform(typeText("echong06@gmail.com"));
                onView(withId(R.id.usernameEditText)).perform(typeText("chonge888"));
                onView(withId(R.id.getDate)).perform(typeText("1988-05-08"));

                onView(withId(R.id.submitButton)).perform(click());

                onView(withId(R.id.usernameEditText))
                        .check(matches(withText("Thank you for signing up, \n chonge888")));
        }


}