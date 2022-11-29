package com.example.mpstudynote;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListviewAdapter extends AppCompatActivity {
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_adapter);

        ListView lv = findViewById(R.id.listview_adt_list_item);
        edit = findViewById(R.id.listview_adt_edit);
        list = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener((adapterView, view, i, l) -> {
            String s = "Select Item = " + list.get(i);
            // String s = "Select Item = " + adapter.getItem(i);
            Toast.makeText(ListviewAdapter.this, s, Toast.LENGTH_SHORT).show();
        });
    }

    public void onClick(View v) {
        list.add(edit.getText().toString());
        edit.setText("");
        adapter.notifyDataSetChanged();
    }
}