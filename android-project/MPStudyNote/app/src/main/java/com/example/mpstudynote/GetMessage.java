package com.example.mpstudynote;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class GetMessage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_message);

//        Button btn = (Button)findViewById(R.id.btnnewmessage);
//        btn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                RelativeLayout rel = (RelativeLayout)View.inflate(
//                        GetMessage.this, R.layout.newmessage, null);
//
//                LinearLayout linear = (LinearLayout)findViewById(R.id.linear);
//                if (linear.getChildCount() % 2 == 0) {
//                    rel.setBackgroundColor(Color.GRAY);
//                } else {
//                    rel.setBackgroundColor(Color.RED);
//                }
//                linear.addView(rel);
//            }
//        });
    }
}