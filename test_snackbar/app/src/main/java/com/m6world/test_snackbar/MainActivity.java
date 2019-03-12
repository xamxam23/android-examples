package com.m6world.test_snackbar;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    Animation shake, bounce, bounce_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bounce_v = AnimationUtils.loadAnimation(this, R.anim.bounce_v);
    }

    public void snackRed(View view) {
        snack("Hello snack", getResources().getColor(R.color.red));
    }

    public void snackGreen(View view) {
        snack("Hello snack", getResources().getColor(R.color.colorPrimary));
    }


    static int t = 0;

    void snack(String string, int color) {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator), string + t++, 2000);
        snackbar.show();
        snackbar.getView().startAnimation(t % 2 == 0 ? bounce : shake);
        snackbar.getView().setBackgroundColor(color);
    }
}