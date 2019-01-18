package com.m6world.test_dagger2tut.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.m6world.test_dagger2tut.R;
import com.m6world.test_dagger2tut._commons.BaseActivity;

public class ThirdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}