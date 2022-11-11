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
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Intent01Sub extends AppCompatActivity {
    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent01_sub);

        Intent intent = getIntent();
        Toast.makeText(this, intent.getCharSequenceExtra("msg"), Toast.LENGTH_SHORT).show();

        ((RadioGroup)findViewById(R.id.intent01_sub_group)).setOnCheckedChangeListener((rg, idx) -> color = (idx == R.id.intent01_sub_red ? Color.RED : Color.BLUE));
        // 원래 색깔 세 가지 해야 하는데 간단하게 두 가지만 했음
    }

    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("color", color); // key, value
        setResult(RESULT_OK, intent);
        finish();
    }
}