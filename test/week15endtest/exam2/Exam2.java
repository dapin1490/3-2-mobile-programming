package com.example.week15endtest221213;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
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
        mv.invalidate();
        edit.setText("");
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
            double radi = Double.parseDouble(edit.getText().toString());
            if (edit.getText().toString().length() < 1)
                radi = 1;
            Paint p = new Paint();
            p.setColor(Color.BLACK);
            canvas.drawCircle(120, 70, (float)radi, p);
        }
    }
}