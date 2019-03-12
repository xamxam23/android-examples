package com.m6world.test_robolectric;

import android.content.Context;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import org.junit.Assert;
import org.junit.Test;

public class MainActivityTest {
    private Context context = ApplicationProvider.getApplicationContext();

    @Test
    public void clickingButton_shouldChangeMessage() {
        ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class);
        scenario.onActivity(new ActivityScenario.ActivityAction<MainActivity>() {
            @Override
            public void perform(MainActivity activity) {
                System.out.println("perform");
                activity.getButton().performClick();
                Assert.assertEquals("Robolectric Rocks!", activity.getMessage());
            }
        });
    }
}