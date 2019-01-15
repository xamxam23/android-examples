package com.m6world.test_dagger2tut._di;

import com.m6world.test_dagger2tut._data.ApiService;
import com.m6world.test_dagger2tut.views.SecondActivity;
import com.m6world.test_dagger2tut._commons.IMainView;
import com.m6world.test_dagger2tut._commons.IPresenter;
import com.m6world.test_dagger2tut.views.MainActivity;
import com.m6world.test_dagger2tut.presenters.Presenter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ActivityModule {

    @Provides
    static IPresenter provideMainPresenter(IMainView mainView, ApiService apiService) {
        return new Presenter(mainView, apiService);
    }

    @Binds
    abstract IMainView provideIView(MainActivity main2Activity);

    @Binds
    abstract SecondActivity provideSecondActivity(SecondActivity detailActivity);
}