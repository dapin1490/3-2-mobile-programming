package com.example.intent2test;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent intent = getIntent();
        Toast.makeText(this, intent.getCharSequenceExtra("msg"), Toast.LENGTH_SHORT).show();

        ((RadioGroup) findViewById(R.id.group)).setOnCheckedChangeListener(
                (rg, i) -> color =
                        i == R.id.red ? Color.RED : (i == R.id.green ? Color.GREEN : Color.BLUE));
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("color", color);
        setResult(RESULT_OK, intent);
        finish();
    }
}
