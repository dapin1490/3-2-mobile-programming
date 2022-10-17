package com.example.baseadapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MyItem> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<>();
        MyItem mi;
        mi = new MyItem(R.mipmap.ic_launcher, "삼성 노트북");
        arrayList.add(mi);
        mi = new MyItem(R.mipmap.ic_launcher, "LG 세탁기");
        arrayList.add(mi);
        mi = new MyItem(R.mipmap.ic_launcher, "대우 마티즈");
        arrayList.add(mi);

        MyListAdapter myListAdapter = new MyListAdapter(this, R.layout.icontext, arrayList);

        ListView listView;
        listView = findViewById(R.id.list);
        listView.setAdapter(myListAdapter);
    }
}
