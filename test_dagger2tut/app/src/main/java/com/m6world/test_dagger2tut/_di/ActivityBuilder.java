package com.m6world.test_dagger2tut._di;

import com.m6world.test_dagger2tut.views.MainActivity;
import com.m6world.test_dagger2tut.views.SecondActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = ActivityModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {ActivityModule.class})
    abstract SecondActivity bindDetailActivity();
}