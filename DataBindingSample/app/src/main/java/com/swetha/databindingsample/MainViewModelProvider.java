package com.swetha.databindingsample;

import android.nfc.Tag;
import android.util.Log;

import androidx.lifecycle.ViewModel;

public class MainViewModelProvider extends ViewModel {

    int count;

    public MainViewModelProvider() {
        count = 0;
        Log.i("TAG", "View Model created");
    }

    public void increaseValue() {
        count++;
    }

    public void decreaseValue() {
        count--;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("TAG", "View model destroyed");
    }
}
