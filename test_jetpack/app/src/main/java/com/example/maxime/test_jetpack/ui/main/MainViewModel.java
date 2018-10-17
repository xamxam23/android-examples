package com.example.maxime.test_jetpack.ui.main;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("x-x", "onCleared");
    }
}