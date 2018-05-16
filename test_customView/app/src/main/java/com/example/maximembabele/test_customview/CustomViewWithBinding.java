package com.example.maximembabele.test_customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class CustomViewWithBinding extends LinearLayout {

    public CustomViewWithBinding(Context context) {
        super(context);
        setup(context);
    }


    public CustomViewWithBinding(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup(context);
    }

    public CustomViewWithBinding(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context);
    }

    private void setup(Context context) {
        LayoutInflater.from(context).inflate(R.layout.custom_view, this);
    }
}