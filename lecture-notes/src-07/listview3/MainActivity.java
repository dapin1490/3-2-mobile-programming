package com.example.listview3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv =  findViewById(R.id.list_item);
        edit =  findViewById(R.id.edit);
        list = new ArrayList<>();

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener((adapterView, view, i, l) -> {
            String s = "Select Item = " + list.get(i);
            // String s = "Select Item = " + adapter.getItem(i);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        });
    }

    public void onClick(View v) {
        list.add(edit.getText().toString());
        edit.setText("");
        adapter.notifyDataSetChanged();
    }
}