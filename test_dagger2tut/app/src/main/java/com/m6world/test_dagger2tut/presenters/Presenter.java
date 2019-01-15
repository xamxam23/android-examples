package com.m6world.test_dagger2tut.presenters;

import com.m6world.test_dagger2tut._commons.IPresenter;
import com.m6world.test_dagger2tut._commons.IMainView;
import com.m6world.test_dagger2tut._data.ApiService;

import javax.inject.Inject;

public class Presenter implements IPresenter {
    IMainView mainView;
    ApiService apiService;

    @Inject
    public Presenter(IMainView mainView, ApiService apiService) {
        this.mainView = mainView;
        this.apiService = apiService;
    }

    public void loadMain(){
        apiService.loadData();
        mainView.onMainLoaded();
    }
}