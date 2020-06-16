package com.example.chongfirstapp;

import android.content.Intent;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)

public class SecondActivityTest {

    @Rule
    public ActivityTestRule<SecondActivity> activityTestRule
            = new ActivityTestRule<SecondActivity>(SecondActivity.class){
        @Override
        protected Intent getActivityIntent(){
            Intent tIntent = new Intent();
            tIntent.putExtra(Constants.KEY_NAME, "Erica Chong");
            tIntent.putExtra(Constants.KEY_AGE, "28");
            tIntent.putExtra(Constants.KEY_DESC, "Just a curious person");
            tIntent.putExtra(Constants.KEY_OCCUPATION, "student");
            return tIntent;

        }

    };


    @Test
    public void secondActivityDisplaysInfoFromMain(){
        onView(withId(R.id.name))
                .check(matches(withText("Erica Chong")));
        onView(withId(R.id.age))
                .check(matches(withText("28")));
        onView(withId(R.id.description))
                .check(matches(withText("Just a curious person")));
        onView(withId(R.id.occupation))
                .check(matches(withText("student")));
    }

}
