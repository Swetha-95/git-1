package com.swetha.googlebooks;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ContentHandler;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchData extends AsyncTask<String, Void, String> {

    TextView tv;
    EditText ed;
    ProgressBar progressBar;
    Context context;

    public FetchData(TextView tv, ProgressBar progressBar, Context context) {
        this.tv = tv;
        this.progressBar = progressBar;
        this.context = context;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressBar.setVisibility(View.INVISIBLE);
        tv.setText(s);
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            //Establish the connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //Read the inputStream
            InputStream inputStream = connection.getInputStream();
            //Read data from inputStream
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);

            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
