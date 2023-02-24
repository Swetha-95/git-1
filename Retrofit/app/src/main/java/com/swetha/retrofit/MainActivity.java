package com.swetha.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.Callable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button getBtn, postBtn;
    TextView textView;
    ProgressBar progressBar;
    String baseUrl = "https://jsonplaceholder.typicode.com/";
    Retrofit retrofit;
    RetrofitService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getBtn = findViewById(R.id.btn_get_data);
        postBtn = findViewById(R.id.btn_post_data);
        textView = findViewById(R.id.textView2);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(RetrofitService.class);
    }

    public void getData(View view) {
        progressBar.setVisibility(View.VISIBLE);
        textView.setText("");
        service.getPosts().enqueue(new Callback<List<Datum>>() {
            @Override
            public void onResponse(Call<List<Datum>> call, Response<List<Datum>> response) {
                progressBar.setVisibility(View.INVISIBLE);
                List<Datum> source = response.body();
                for (Datum d : source) {
                    textView.append(d.getTitle() + "\n");
                }
            }

            @Override
            public void onFailure(Call<List<Datum>> call, Throwable t) {
            }
        });

    }

    public void postData(View view) {
        progressBar.setVisibility(View.VISIBLE);
        textView.setText("");
        PostReq postReq = new PostReq("Swetha", "Android Retrofit", 1);
        service.postData(postReq).enqueue(new Callback<PostReq>() {
            @Override
            public void onResponse(Call<PostReq> call, Response<PostReq> response) {
                textView.setText(response.body().getBody());
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<PostReq> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
}
