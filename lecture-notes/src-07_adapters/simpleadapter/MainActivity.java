package com.example.simpleadapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.codes);

        ArrayList<HashMap<String, String>> codes = new ArrayList<>();

        HashMap<String, String> map = new HashMap<>();
        map.put("initial", "a");
        map.put("code", "Apple");
        codes.add(map);

        map = new HashMap<>();
        map.put("initial", "b");
        map.put("code", "Banana");
        codes.add(map);

        map = new HashMap<>();
        map.put("initial", "c");
        map.put("code", "Cupcake");
        codes.add(map);

        SimpleAdapter sa = new SimpleAdapter(this, codes, R.layout.row, new String[] { "initial", "code" },
                new int[] { R.id.initial, R.id.code });

        list.setAdapter(sa);
    }
}