package com.example.maximembabele.test_viewmodel;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.lifecycle.ViewModelStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    MyViewModel viewModel;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("x-x", "onCreate " + hashCode());
        // viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        (editText = findViewById(R.id.nameEditText)).addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override public void afterTextChanged(Editable s) {
                Log.d("x-x", "Editable " + s + ". hashCode " + MainActivity.this.hashCode());
                if (viewModel != null) {
                    viewModel.setName(s.toString());
                }
            }
        });
    }

    @Override protected void onResume() {
        super.onResume();
        Log.d("x-x", "onResukme");
        if (viewModel != null) {
            Log.d("x-x", "onResume " + viewModel.getName());
            //oooo editText.setText(viewModel.getName());
        }
    }

    @Override protected void onPause() {
        Log.d("x-x", "onPause");
        if (viewModel != null) {
            Log.d("x-x", "onPause " + editText.getText().toString());
            // viewModel.setName(editText.getText().toString());
        }
        super.onPause();
    }

    @Override protected void onDestroy() {
        Log.d("x-x", "onDestroy");
        super.onDestroy();
    }
}
