package com.example.maximembabele.test_mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created on 2018/05/16.
 */
public class MyFragment extends Fragment {
    private MyViewModel viewModel;
    TextView textView;

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
    }

    @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        textView = view.findViewById(R.id.textView);
        viewModel.getLiveName().observe(this, new Observer<String>() {
            @Override public void onChanged(@Nullable String s) {
                textView.setText(viewModel.getName());
            }
        });
        return view;
    }
}
