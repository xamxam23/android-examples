package com.m6world.test_dagger2tut.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.m6world.test_dagger2tut.R;
import com.m6world.test_dagger2tut._commons.BaseActivity;
import com.m6world.test_dagger2tut._commons.IMainView;
import com.m6world.test_dagger2tut._commons.IPresenter;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements IMainView {
    @Inject IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.loadMain();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    @Override public void onMainLoaded() {
        Log.d("x-", "View.onMainLoaded");
    }
}