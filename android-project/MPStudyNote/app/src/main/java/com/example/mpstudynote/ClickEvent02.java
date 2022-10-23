package com.example.mpstudynote;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ClickEvent02 extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_event02);
    }

    public void mOnClick(View v) {
        TextView textFruit=(TextView)findViewById(R.id.fruit2);
        switch (v.getId()) {
            case R.id.apple2:
                textFruit.setText("Apple");
                break;
            case R.id.orange2:
                textFruit.setText("Orange");
                break;
        }
    }
}