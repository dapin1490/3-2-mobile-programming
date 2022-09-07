package com.example.listview1demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String[] codes = new String[]{
            "Apple", "Banana", "Cupcake", "Donut", "Eclair", "Froyo"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.list_item);
        lv.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, codes));
        lv.setOnItemClickListener((list, view, position, id) -> {
            String s = "Select Item = " + codes[position];
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT)
                    .show();
        });
    }
}
