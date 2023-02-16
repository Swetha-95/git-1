package com.swetha.googlebooks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();

        bookName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() != 0) {
                    bookBtn.setEnabled(true);
                    name = s.toString();
                } else {
                    if (TextUtils.isEmpty(s)) {
                        bookName.setError("Please Enter the Book name");
                        bookBtn.setEnabled(false);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                FetchData fetchData = new FetchData(showBook, progressBar, MainActivity.this);
                fetchData.execute(url + name);
            }
        });
    }

    public void initializeViews() {
        bookName = findViewById(R.id.editText);
        bookBtn = findViewById(R.id.button);
        showBook = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.INVISIBLE);
        bookBtn.setEnabled(false);
    }
}