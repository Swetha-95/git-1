package com.swetha.databindingsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.swetha.databindingsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;
    MainViewModelProvider viewModelProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModelProvider = new ViewModelProvider(this).get(MainViewModelProvider.class);

        if (viewModelProvider != null) {
            binding.textView.setText(String.valueOf(viewModelProvider.count));
        }
        binding.increaseValue.setOnClickListener(this);
        binding.decreaseValue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.increaseValue) {
            viewModelProvider.increaseValue();
        } else {
            viewModelProvider.decreaseValue();

        }
        binding.textView.setText(String.valueOf(viewModelProvider.count));
    }
}