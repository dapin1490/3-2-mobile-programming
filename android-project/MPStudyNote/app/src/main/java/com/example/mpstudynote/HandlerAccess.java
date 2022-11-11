package com.example.mpstudynote;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HandlerAccess extends AppCompatActivity {
    // 1. 이벤트에서 참조할 뷰를 핸들러 내의 지역변수로 선언
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.handler_access);
//
//        LinearLayout linear = (LinearLayout)findViewById(R.id.handacc_linear);
//        linear.setOnTouchListener(new View.OnTouchListener() {
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    TextView text = (TextView)findViewById(R.id.text);
//                    text.setText("Touched");
//                    return true;
//                }
//                return false;
//            }
//        });
//    }

    // 이벤트에서 참조할 뷰를 메인 클래스의 멤버로 선언
    // 핸들러로 전달할 값을 멤버로 선언하는 것은 구조적으로 바람직하지 않다.
//    TextView mText;
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.handler_access);
//
//        mText = (TextView)findViewById(R.id.text);
//
//        LinearLayout linear = (LinearLayout)findViewById(R.id.handacc_linear);
//        linear.setOnTouchListener(new View.OnTouchListener() {
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    mText.setText("Touched");
//                    return true;
//                }
//                return false;
//            }
//        });
//    }

    // 핸들러를 포함한 메소드의 지역 변수 사용
    // 지역 변수를 핸들러로 전달할 때는 사실상 final
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_access);

        final TextView outText = (TextView)findViewById(R.id.handacc_text);

        LinearLayout linear = (LinearLayout)findViewById(R.id.handacc_linear);
        linear.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    outText.setText("Touched");
                    return true;
                }
                return false;
            }
        });
    }
}