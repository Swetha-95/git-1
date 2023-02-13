package com.swetha.wishesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText friendName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        friendName = findViewById(R.id.name_list);
    }

    public void wishBirthday(View view) {
        // step 1: Get the friend name
        String name = friendName.getText().toString();
        // step 2: To create the Explicit intent
        Intent i = new Intent(this, GreetingActivity.class);
        //step 3 = Sent the intent request
        i.putExtra("KEY", name);
        startActivity(i);
    }
}