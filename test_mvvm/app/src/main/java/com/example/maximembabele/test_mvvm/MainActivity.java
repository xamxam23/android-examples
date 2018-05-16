package com.example.maximembabele.test_mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.maximembabele.test_mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //private ActivityMainBinding binding;
    ActivityMainBinding binding;
    MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMyViewModel(viewModel = ViewModelProviders.of(this).get(MyViewModel.class));
        binding.getMyViewModel().getLiveName().observe(this, new Observer<String>() {
            @Override public void onChanged(@Nullable String s) {
                binding.setMyViewModel(viewModel);
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.leftFrame, new MyFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.rightFrame, new MyFragment()).commit();
    }

    private void toast(String name) {
        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
    }

    int t = 0;

    public void click(View view) {
        viewModel.setName(t+"-click:XYZ");
        toast(++t + " SET " + viewModel.getName());
    }
}
