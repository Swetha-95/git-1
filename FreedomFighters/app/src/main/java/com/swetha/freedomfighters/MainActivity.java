package com.swetha.freedomfighters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int[] images;
    String[] names;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        prepareData();
        FighterAdapter fighterAdapter = new FighterAdapter(this, images,names);
        recyclerView.setAdapter(fighterAdapter);
        // recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void prepareData() {
        images = new int[]{
                R.drawable.balgangadharthilak, R.drawable.bhagatsingh,
                R.drawable.chhatrapathisivaji, R.drawable.gandhiji, R.drawable.lakshimibai,
                R.drawable.lalalajapatrai, R.drawable.lalbahadursastri, R.drawable.mangalpandey,
                R.drawable.nanasahip, R.drawable.nehru, R.drawable.rajendraprasad,
                R.drawable.sardarvallabaipatel, R.drawable.sivaram, R.drawable.sivaramhari,
                R.drawable.subahashchandrabose};

        names = new String[]{ "Balgangadharthilak", "Bhagatsingh",
                "Chhatrapathisivaji", "Gandhiji", "Lakshimibai", "Lalalajapatrai",
                "Lalbahadursastri", "Mangalpandey", "Nanasahip", "Nehru", "Rajendraprasad",
                "Sardarvallabaipatel", "Sivaram", "Sivaramhari", "Subahashchandrabose"};
    }
}