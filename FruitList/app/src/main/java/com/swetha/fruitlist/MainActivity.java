
package com.swetha.fruitlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String bowl[];
    int images[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.listView);
        createData();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, bowl[position], Toast.LENGTH_SHORT).show();
            }
        });
        CustomListView customListView = new CustomListView();
        lv.setAdapter(customListView);
    }

    class CustomListView extends BaseAdapter {

        @Override
        public int getCount() {
            return 7;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.one_item_design, parent, false);
            }

            ImageView imageView = convertView.findViewById(R.id.fruits_images);
            TextView textView = convertView.findViewById(R.id.fruittext);

            imageView.setImageResource(images[position]);
            textView.setText(bowl[position]);
            return convertView;
        }
    }

    private void createData() {
        bowl = new String[7];
        bowl[0] = "Apple";
        bowl[1] = "Banana";
        bowl[2] = "CustedApple";
        bowl[3] = "Dragon";
        bowl[4] = "ElderBerry";
        bowl[5] = "Fig";
        bowl[6] = "Grapes";

        images = new int[7];
        images[0] = R.drawable.apple;
        images[1] = R.drawable.banana;
        images[2] = R.drawable.custedapple;
        images[3] = R.drawable.dragon;
        images[4] = R.drawable.elderberry;
        images[5] = R.drawable.fig;
        images[6] = R.drawable.grapes;
    }
}