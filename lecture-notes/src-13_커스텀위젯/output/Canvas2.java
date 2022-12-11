package com.example.hiadnroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyText(this));
    }

    protected class MyText extends View {
        Paint p;

        public MyText(Context context) {
            super(context);
            p = new Paint();
        }

        @Override
        public void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            p.setTextSize(20);
            p.setAntiAlias(true);
            p.setColor(Color.BLACK);
            Typeface tf = Typeface.create(Typeface.SERIF,
                    Typeface.BOLD_ITALIC);
            p.setTypeface(tf);
            canvas.drawText("Serif Bold_Italic", 20, 30, p);

            tf = Typeface.create(Typeface.SANS_SERIF,
                    Typeface.NORMAL);
            p.setTypeface(tf);
            canvas.drawText("Sans_Serif Normal", 20, 55, p);

            p.setTextSize(10);
            p.setColor(Color.RED);
            canvas.drawText("소", 20, 100, p);
            p.setTextSize(20);
            canvas.drawText("중", 50, 100, p);
            p.setTextSize(40);
            canvas.drawText("대", 80, 100, p);
        }
    }
}