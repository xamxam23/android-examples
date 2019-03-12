package com.m6world.test_robolectric

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(View.OnClickListener {
            textView.text = "Robolectric Rocks!"
        })
    }

    fun getButton(): Button {
        return button;
    }

    fun getMessage(): String {
        return textView.text.toString();
    }
}
