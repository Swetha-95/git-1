package com.swetha.googlebooks;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.swetha.googlebooks.data.Item;
import com.swetha.googlebooks.data.Source;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

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
        tv.setText("");

        //JSON Format
        /* try {
            JSONObject root = new JSONObject(s);
            JSONArray items = root.getJSONArray("items");
            for(int i=0; i<items.length();i++){
                JSONObject it = items.getJSONObject(i);
                JSONObject volumeInfo = it.getJSONObject("volumeInfo");
                String title = volumeInfo.getString("title");
                tv.append(title+" by ");
                tv.append("\n");
                JSONArray authorArray = volumeInfo.getJSONArray("authors");
                for(int j =0; j<authorArray.length();j++){
                    String authors = authorArray.getString(j);
                    tv.append(authors+" ");
                }
                tv.append("\n\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        Gson gson = new Gson();
        Source source = gson.fromJson(s, Source.class);
        for (Item i : source.getItems()) {
            String title = i.getVolumeInfo().getTitle();
            tv.append(title);
            List<String> authors = i.getVolumeInfo().getAuthors();
            if (authors != null) {
                tv.append(" by ");
                for (String auth : authors) {
                    tv.append(auth + " ");
                }
            }
            tv.append("\n\n");
        }
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
