package com.example.mpstudynote;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//public class MainActivity extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] ls;
    ArrayAdapter<String> arradapter;
    int posi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.main_list);
        ls = getResources().getStringArray(R.array.activities);

        arradapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, ls);
        list.setAdapter(arradapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setOnItemClickListener((adview, view, position, id) -> posi = position);
    }

    public void onClick(View v) {
        Intent i;

        if (posi == ListView.INVALID_POSITION) {
            return;
        }

        switch (posi) {
            case 1: i = new Intent(this, BaseAdt.class); break;
            case 2: i = new Intent(this, BaselineAligned.class); break;
            case 3: i = new Intent(this, ButtonEdit.class); break;
            case 4: i = new Intent(this, ClickEvent01.class); break;
            case 5: i = new Intent(this, ClickEvent02.class); break;
            case 6: i = new Intent(this, GravityLayout.class); break;
            case 7: i = new Intent(this, HandleEvent.class); break;
            case 8: i = new Intent(this, HandlerAccess.class); break;
            case 9: i = new Intent(this, HorizontalLayout.class); break;
            case 10: i = new Intent(this, ImageviewTest.class); break;
            case 11: i = new Intent(this, Intent01.class); break;
            case 12: i = new Intent(this, LayoutManage.class); break;
            case 13: i = new Intent(this, LayoutParameter.class); break;
            case 14: i = new Intent(this, LgravityLayout.class); break;
            case 15: i = new Intent(this, ListActAdapter.class); break;
            case 16: i = new Intent(this, ListviewAdapter.class); break;
            case 17: i = new Intent(this, LongClick.class); break;
            case 18: i = new Intent(this, RelativeLayout.class); break;
            case 19: i = new Intent(this, SimpleAdt.class); break;
            case 20: i = new Intent(this, SQLiteMain.class); break;
            case 21: i = new Intent(this, ToastTest.class); break;
            case 22: i = new Intent(this, Week06Quiz.class); break;
            case 23: i = new Intent(this, Week07Quiz.class); break;
            default: i = new Intent();
        }

        try {
            startActivity(i);
        } catch (ActivityNotFoundException e) {
            // Define what your app should do if no activity can handle the intent.
            String errorm = "error - selected position: " + Integer.toString(posi);
            Toast.makeText(this, errorm, Toast.LENGTH_SHORT).show();
            return;
        }
        finally {
            Toast.makeText(this, "selected position : " + Integer.toString(posi), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "intent: " + i.toString(), Toast.LENGTH_SHORT).show();
            posi = ListView.INVALID_POSITION;
        }
    }
}