package com.swetha.googlebooks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText bookName;
    Button bookBtn;
    TextView showBook;
    ProgressBar progressBar;
    String url = "https://www.googleapis.com/books/v1/volumes?q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookName = findViewById(R.id.editText);
        bookBtn = findViewById(R.id.button);
        showBook = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.INVISIBLE);

        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String name =bookName.getText().toString();
                FetchData fetchData = new FetchData(showBook, progressBar,MainActivity.this );
                fetchData.execute(url+name);
            }
        });
    }
}