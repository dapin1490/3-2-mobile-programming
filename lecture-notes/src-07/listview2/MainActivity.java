package com.example.listview2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.list_item);
        lv.setAdapter(ArrayAdapter.createFromResource(this, R.array.codes, android.R.layout.simple_list_item_1));
        lv.setOnItemClickListener(listener);
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String[] codes = getResources().getStringArray(R.array.codes);
            String s = "Select Item = " + codes[i];
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    };
}
