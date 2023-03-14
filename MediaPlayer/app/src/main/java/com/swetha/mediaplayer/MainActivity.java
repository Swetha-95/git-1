package com.swetha.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPlayer(View view) {
        Intent i = new Intent(this, MediaPlayerService.class);
        startService(i);

    }

    public void stopPlayer(View view) {
        Intent i = new Intent(this, MediaPlayerService.class);
        stopService(i);
    }
}