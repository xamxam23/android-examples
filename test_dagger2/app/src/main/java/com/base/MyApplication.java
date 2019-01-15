package com.base;

import android.app.Application;

import com.di.ActivityInjector;

import javax.inject.Inject;

public class MyApplication extends Application {
    private  ApplicationComponent component;
    @Inject ActivityInjector activityInjector;
    @Override public void onCreate() {
        super.onCreate();
        //component = DaggerA
        component = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        component.inject(this);
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
