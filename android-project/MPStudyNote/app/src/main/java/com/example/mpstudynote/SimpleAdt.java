package com.example.mpstudynote;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdt extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_adt);

        ListView list = findViewById(R.id.simple_adt_codes);

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

        SimpleAdapter sa = new SimpleAdapter(this, codes, R.layout.simple_adt_row, new String[] { "initial", "code" }, new int[] { R.id.simple_adt_row_initial, R.id.simple_adt_row_code });

        list.setAdapter(sa);
    }
}