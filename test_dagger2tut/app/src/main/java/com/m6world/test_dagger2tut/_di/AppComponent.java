package com.m6world.test_dagger2tut._di;

import android.app.Application;

import com.m6world.test_dagger2tut.MyApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by mertsimsek on 25/05/2017.
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilder.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    void inject(MyApp app);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}