package com.base;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application appplication;

    ApplicationModule(Application application) {
        this.appplication = application;
    }

    @Provides Context provideApplicationContext() {
        return appplication;
    }
}