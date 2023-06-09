package com.example.q3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            final ArrayList<String> list = new ArrayList<>();
            list.add("Donut");
            list.add("Eclairs");
            list.add("Froyo");
            list.add("Gingerbread");
            list.add("Honeycomb");

            ListAdapter adapter = new ListAdapter(this, 0, list);
            ListView listView = findViewById(R.id.list);
            listView.setAdapter(adapter);
        }
    }
