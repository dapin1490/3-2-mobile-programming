package com.example.listactivity1demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    static final String[] codes = {
            "Apple", "Banana", "Cupcake", "Donut", "Eclair", "Froyo"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, codes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String s = "Select Item = " + codes[position];
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }
}
