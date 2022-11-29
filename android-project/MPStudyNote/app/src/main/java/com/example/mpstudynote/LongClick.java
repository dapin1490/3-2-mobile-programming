package com.example.mpstudynote;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LongClick extends AppCompatActivity {
    int count = 0;
    TextView textCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.long_click);

        textCount = findViewById(R.id.long_click_count);

        findViewById(R.id.long_click_dec).setOnLongClickListener(listener);
        findViewById(R.id.long_click_inc).setOnLongClickListener(listener);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.long_click_dec:
                count--;
                textCount.setText(count + "");
                break;
            case R.id.long_click_inc:
                count++;
                textCount.setText(count + "");
                break;
        }
    }

    View.OnLongClickListener listener = new View.OnLongClickListener() {
        public boolean onLongClick(View v) {
            switch (v.getId()) {
                case R.id.long_click_dec:
                    count = 0;
                    textCount.setText("" + count);
                    return true;
                case R.id.long_click_inc:
                    count = 100;
                    textCount.setText("" + count);
                    break;
            }
            return false;
        }
    };
}