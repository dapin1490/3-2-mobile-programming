package com.example.mpstudynote;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ClickEvent01 extends AppCompatActivity {
    // 임시 객체로 핸들러 만들기
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.click_event01);
//
//        Button btnApple=(Button)findViewById(R.id.apple);
//        btnApple.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                TextView textFruit=(TextView)findViewById(R.id.fruit);
//                textFruit.setText("Apple");
//            }
//        });
//
//        Button btnOrange=(Button)findViewById(R.id.orange);
//        btnOrange.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                TextView textFruit=(TextView)findViewById(R.id.fruit);
//                textFruit.setText("Orange");
//            }
//        });
//    }

    // 핸들러 통합하기 - 인터페이스 구현 멤버 객체
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_event01);

        findViewById(R.id.apple).setOnClickListener(mClickListener);
        findViewById(R.id.orange).setOnClickListener(mClickListener);
    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            TextView textFruit=(TextView)findViewById(R.id.fruit);
            switch (v.getId()) {
                case R.id.apple:
                    textFruit.setText("Apple");
                    break;
                case R.id.orange:
                    textFruit.setText("Orange");
                    break;
            }
        }
    };
}

// 핸들러 통합하기 - 인터페이스 구현
//public class ClickEvent01 extends Activity implements View.OnClickListener {
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.click_event01);
//
//        Button btnApple=(Button)findViewById(R.id.apple);
//        btnApple.setOnClickListener(this);
//        Button btnOrange=(Button)findViewById(R.id.orange);
//        btnOrange.setOnClickListener(this);
//    }
//
//    public void onClick(View v) {
//        TextView textFruit=(TextView)findViewById(R.id.fruit);
//        switch (v.getId()) {
//            case R.id.apple:
//                textFruit.setText("Apple");
//                break;
//            case R.id.orange:
//                textFruit.setText("Orange");
//                break;
//        }
//    }
//}