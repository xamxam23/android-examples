package com.example.maximembabele.test_mvvm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

public class MyViewModel extends ViewModel {
    public MutableLiveData<String> liveName = new MutableLiveData<String>();
    public int scoreTeamB = 0;


    public MutableLiveData<String> getLiveName() {
        return liveName;
    }

    public String getName() {
        return liveName.getValue();
    }

    public void setName(String name) {
        liveName.setValue(name);
    }
}
