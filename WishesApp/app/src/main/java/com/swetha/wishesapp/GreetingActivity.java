package com.swetha.wishesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {

    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        name =findViewById(R.id.wishes_text);
        Intent i = getIntent();
        String friendName = i.getStringExtra("KEY");
        name.append(friendName);
    }
}