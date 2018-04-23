package com.example.maximembabele.test_graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.Random;

public class MyGraphLayout extends FrameLayout {


    public MyGraphLayout(Context context) {
        super(context);
        setup(context);
    }

    public MyGraphLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup(context);
    }

    public MyGraphLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context);
    }

    void setup(Context context) {
        LayoutInflater.from(context).inflate(R.layout.linear_layout, this);
    }
}