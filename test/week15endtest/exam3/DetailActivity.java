package com.example.speciestest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener {
    ListView list;
    ArrayAdapter<String> adapter;
    List<String> species2;
    String[][] animals = { {"호랑이", "사자", "여우"},
            {"독수리", "참새", "제비"},
            {"송어", "붕어", "상어"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        list = findViewById(R.id.detail);

        Intent intent = getIntent();
        int index = intent.getIntExtra("주", 0);
        species2 = new ArrayList<>();
        for (int i = 0; i < animals[index].length; i++)
            species2.add(animals[index][i]);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, species2);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView text = (TextView) view;
        Intent i = getIntent();
        i.putExtra("종", text.getText().toString());
        setResult(RESULT_OK, i);
        finish();
    }
}