package com.example.chongfirstapp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

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
    public ActivityScenarioRule<SecondActivity>activityScenarioRule
            = new ActivityScenarioRule<>(SecondActivity.class);

    @Test
    public void hasTextOnScreen() {
        onView(withId(R.id.placeholdertext))
                .check((matches(withText(R.string.placeholder_text))));
    }

}
