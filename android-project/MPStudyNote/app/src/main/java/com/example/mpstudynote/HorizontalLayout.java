package com.example.mpstudynote;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HorizontalLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizontal_layout);

        Button editbtn = (Button)findViewById(R.id.horizonbtn);
        editbtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                EditText edit = (EditText)findViewById(R.id.horizonedit);
                String str = edit.getText().toString();
                Toast.makeText(HorizontalLayout.this, str,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}