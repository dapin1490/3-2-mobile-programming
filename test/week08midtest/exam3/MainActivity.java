package com.example.mid2;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<MyItem> array = new ArrayList<>();
        MyItem mi = new MyItem("홍길동", "010-1111-1111", "hong@one.com");
        array.add(mi);
        mi = new MyItem("김삿갓", "010-2222-2222", "kim@two.com");
        array.add(mi);
        mi = new MyItem("황진이", "010-3333-3333", "hwang@three.com");
        array.add(mi);
        MyAdapter adapter = new MyAdapter(this, array);
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);
    }
}