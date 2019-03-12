package com.m6world.test_robolectric;

import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertThat;

import org.junit.*;
import org.robolectric.android.controller.ActivityController;

@RunWith(RobolectricTestRunner.class)
public class TestSecond {
    @Test
    public void clickingButton_shouldChangeMessage() {
        ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class);
        MainActivity mainActivity = controller.get();
        mainActivity.getButton().performClick();
        Assert.assertEquals("Robolectric Rocks!", mainActivity.getMessage());
    }
}