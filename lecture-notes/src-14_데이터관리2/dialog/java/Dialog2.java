package com.example.dialog2demo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("경고")
                .setMessage("시간 초과!!!")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("계속",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Toast.makeText(MainActivity.this,
                                        "계속하세요^^", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                .setNegativeButton("종료",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,	int which) {}
                        }
                )
                .setCancelable(false)
                .show();
    }
}