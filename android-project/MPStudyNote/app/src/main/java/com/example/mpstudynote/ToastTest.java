package com.example.mpstudynote;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ToastTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toast_test);
    }

    public void onClick(View view) {
        Toast.makeText(this, "Hi Event!", Toast.LENGTH_SHORT).show();
    }
}