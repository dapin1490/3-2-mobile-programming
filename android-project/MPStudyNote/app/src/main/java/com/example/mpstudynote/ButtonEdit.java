package com.example.mpstudynote;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ButtonEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_edit);

        Button btn = (Button)findViewById(R.id.btn_edit_btn);
        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                EditText edit = (EditText)findViewById(R.id.btn_edit_edit);
                String str = edit.getText().toString();
                Toast.makeText(ButtonEdit.this, str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}