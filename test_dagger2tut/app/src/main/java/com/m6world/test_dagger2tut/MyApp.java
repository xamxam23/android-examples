package com.m6world.test_dagger2tut;

import com.m6world.test_dagger2tut._di.AppComponent;
import com.m6world.test_dagger2tut._di.DaggerAppComponent;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MyApp extends DaggerApplication {
    /**
     * Implementations should return an {@link AndroidInjector} for the concrete {@link
     * DaggerApplication}. Typically, that injector is a {@link Component}.
     */
    @Override protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }
}
