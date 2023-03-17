package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import android.content.Intent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;

//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

public class IntentTestOne {
    String checkString = "This is home fragment";

    @Rule
//    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);
    public IntentsTestRule IntentsTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void FirstIntentTest() {
        String buttonDescription = "More options";
        String clickText = "Settings";
        String testUrl = "https://google.com";

        ViewInteraction overflowMenuButton = onView(
                allOf(withContentDescription(buttonDescription),
                        isDisplayed()));
        overflowMenuButton.perform(click());

        ViewInteraction materialTextView = onView(
                allOf(withId(androidx.constraintlayout.widget.R.id.title), withText(clickText),
                        isDisplayed()));
        materialTextView.perform(click());
        intended(hasData(testUrl));
        intended(hasAction(Intent.ACTION_VIEW));
    }
}

