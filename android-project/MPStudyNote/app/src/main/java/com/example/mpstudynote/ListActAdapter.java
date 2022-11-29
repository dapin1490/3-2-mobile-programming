package com.example.mpstudynote;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActAdapter extends ListActivity { // 상속받는 라이브러리가 다른 것에 주의
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_act_adapter);

        edit = findViewById(R.id.list_act_adt_edit);
        list = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);
        registerForContextMenu(getListView());
    }

    public void onClick(View v) {
        if (v.getId() == R.id.list_act_adt_button1) {
            list.add(edit.getText().toString());
            edit.setText("");
        } else if (v.getId() == R.id.list_act_adt_button2)
            if (list.size() > 0)
                list.remove(list.size() -1);

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String s = "Select Item = " + adapter.getItem(position);
        Toast.makeText(ListActAdapter.this, s, Toast.LENGTH_SHORT).show();
    }
}