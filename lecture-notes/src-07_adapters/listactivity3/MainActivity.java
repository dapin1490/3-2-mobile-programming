package com.example.listactivity3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.edit);
        list = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);
        registerForContextMenu(getListView());
    }

    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            list.add(edit.getText().toString());
            edit.setText("");
        } else if (v.getId() == R.id.button2)
            if (list.size() > 0)
                list.remove(list.size() -1);

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String s = "Select Item = " + adapter.getItem(position);
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }
}
