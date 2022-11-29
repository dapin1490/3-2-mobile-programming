package com.example.mpstudynote;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Week06Quiz extends AppCompatActivity {
    boolean btnflag01 = true;
    boolean btnflag02 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week06_quiz);
    }

    public void onClick(View v) {
        TextView text01 = (TextView)findViewById(R.id.w06q_tv01);
        TextView text02 = (TextView)findViewById(R.id.w06q_tv02);

        switch (v.getId()) {
            case R.id.w06q_btn01:
                text01.setBackgroundColor(btnflag01 ? Color.WHITE : Color.GREEN);
                btnflag01 = !btnflag01;
                break;
            case R.id.w06q_btn02:
                text02.setGravity(btnflag02 ? Gravity.CENTER : Gravity.START);
                btnflag02 = !btnflag02;
                break;
        }
    }
}