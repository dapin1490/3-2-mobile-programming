package com.example.mpstudynote;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LayoutParameter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linear = new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);
        linear.setGravity(Gravity.CENTER);
        linear.setBackgroundColor(Color.LTGRAY);

        TextView text = new TextView(this);
        text.setText("TextView");
        text.setTextColor(Color.RED);
        text.setTextSize(20);
        text.setBackgroundColor(Color.GREEN);

        linear.addView(text);

        setContentView(linear);

        LinearLayout linear2 = new LinearLayout(this);
        linear2.setOrientation(LinearLayout.VERTICAL);
        linear2.setGravity(Gravity.CENTER);
        linear2.setBackgroundColor(Color.LTGRAY);

        TextView text2 = new TextView(this);
        text2.setText("TextView");
        text2.setTextColor(Color.RED);
        text2.setTextSize(20);
        text2.setBackgroundColor(Color.GREEN);

        LinearLayout.LayoutParams paramtext = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        linear2.addView(text2, paramtext);

        setContentView(linear2);
    }
}