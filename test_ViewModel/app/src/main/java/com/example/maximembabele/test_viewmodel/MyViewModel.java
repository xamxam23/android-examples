package com.example.maximembabele.test_viewmodel;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

/**
 * The ViewModel class allows data to survive configuration changes such as screen rotations.
 */
public class MyViewModel extends ViewModel {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override protected void onCleared() {
        Log.d("x-x", "onCleared");
        super.onCleared();
    }
}


