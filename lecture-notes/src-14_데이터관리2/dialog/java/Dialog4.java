package com.example.dialog4demo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button;
    final CharSequence[] items = {"Red", "Green", "Blue"};
    final int colors[] = { 0xFFFF0000, 0xFF00FF00, 0xFF0000FF };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
    }

    public void onClick(View v) {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Pick a color")
                .setSingleChoiceItems(items, -1,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int item) {
                                button.setBackgroundColor(colors[item]);
                            }
                        })
                .setNegativeButton("종료", null)
                .show();
    }
}