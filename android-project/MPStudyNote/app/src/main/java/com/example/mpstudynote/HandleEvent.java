package com.example.mpstudynote;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HandleEvent extends AppCompatActivity {
    // HandleEvent1
    // 1. 핸들러 메소드 재정의 - 상속을 받아야만 재정의 가능하다.
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        View vw = new MyView(this);
//        setContentView(vw);
//    }
//
//    class MyView extends View {
//        public MyView(Context context) {
//            super(context);
//        }
//
//        public boolean onTouchEvent(MotionEvent event) {
//            super.onTouchEvent(event);
//            if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                Toast.makeText(HandleEvent.this,"Touch Event Received",
//                        Toast.LENGTH_SHORT).show();
//                return true;
//            }
//            return false;
//        }
//    }

    // HandleEvent2
    // 2. 인터페이스 구현 객체 생성 - 별도의 클래스가 필요함
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        View vw = new View(this);
//        // (3) 리스너 등록
//        vw.setOnTouchListener(TouchListener);
//        setContentView(vw);
//    }
//    // (1) 리스너 구현 클래스 선언
//    class TouchListenerClass implements View.OnTouchListener {
//        public boolean onTouch(View v, MotionEvent event) {
//            if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                Toast.makeText(HandleEvent.this,"Touch Event Received",
//                        Toast.LENGTH_SHORT).show();
//                return true;
//            }
//            return false;
//        }
//    }
//    // (2) 리스너 객체 생성
//    TouchListenerClass TouchListener = new TouchListenerClass();

    // HandleEvent4
    // 4. 뷰에서 리스너 구현
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        MyView vw = new MyView(this);
//        vw.setOnTouchListener(vw);
//        setContentView(vw);
//    }
//
//    class MyView extends View implements View.OnTouchListener {
//        public MyView(Context context) {
//            super(context);
//        }
//
//        public boolean onTouch(View v, MotionEvent event) {
//            if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                Toast.makeText(HandleEvent.this,"Touch Event Received",
//                        Toast.LENGTH_SHORT).show();
//                return true;
//            }
//            return false;
//        }
//    }

    // HandleEvent5
    // 5. 익명 이너 클래스 사용
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        View vw = new View(this);
//        vw.setOnTouchListener(TouchListener);
//        setContentView(vw);
//    }
//
//    View.OnTouchListener TouchListener = new View.OnTouchListener() {
//        public boolean onTouch(View v, MotionEvent event) {
//            if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                Toast.makeText(HandleEvent.this,"Touch Event Received",
//                        Toast.LENGTH_SHORT).show();
//                return true;
//            }
//            return false;
//        }
//    };

    // HandleEvent6
    // 6. 익명 이너 클래스의 임시 객체 생성
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View vw = new View(this);
        vw.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(HandleEvent.this,"Touch Event Received",
                            Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
        setContentView(vw);
    }

    // HandleEvent6-2
    // 람다식 사용 : 직접 쓴 거라 잘 모르겠음
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        View vw = new View(this);
//        vw.setOnTouchListener((view, event) -> {
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    Toast.makeText(HandleEvent.this,"Touch Event Received",
//                            Toast.LENGTH_SHORT).show();
//                    return true;
//                }
//                return false;
//            });
//        setContentView(vw);
//    }
}

// HandleEvent3
// 3. 액티비티가 리스너 구현(클래스에 implements(인터페이스 상속) 추가)
//public class HandleEvent extends Activity implements View.OnTouchListener {
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        View vw = new View(this);
//        vw.setOnTouchListener(this);
//        setContentView(vw);
//    }
//
//    public boolean onTouch(View v, MotionEvent event) {
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            Toast.makeText(this,"Touch Event Received",
//                    Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        return false;
//    }
//}
