package com.example.week15endtest221213;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    MyView mv;
    EditText edit;
    LinearLayout ll;

    // onCreate() 내부 코드 수정 불가
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mv = new MyView(this);
        edit = findViewById(R.id.edit);
        ll = findViewById(R.id.ll);
        ll.addView(mv);
    }

    public void onClick(View v) {
        // 필요한 코드 추가
        Log.d("Exam2", "called onClick");
        mv.invalidate();
        Log.d("Exam2", "mv invalidated");
    }

    class MyView extends View {
        public MyView(Context context) {
            super(context);
            // 필요한 코드 추가
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            // 필요한 코드 추가
            Log.d("Exam2", "called onDraw");
            float radi;
            String str = edit.getText().toString();
            Log.d("Exam2", "radi is " + str);
            radi = 1;
            if (str.length() != 0)
                radi = Float.parseFloat(str);
            Paint p = new Paint();
            p.setColor(Color.BLACK);
            canvas.drawCircle(120, 70, radi, p);
            edit.setText("");
        }
    }
}