package com.example.hiadnroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyShape(this));
    }

    private class MyShape extends View {
        Paint p;

        public MyShape(Context context) {
            super(context);
            p = new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            p.setColor(Color.BLACK);
            canvas.drawPoint(10,50, p);
            canvas.drawPoint(15,50, p);
            canvas.drawPoint(20,50, p);
            canvas.drawPoint(25,50, p);
            canvas.drawPoint(30,50, p);
            p.setColor(Color.RED);
            canvas.drawLine(10,20, 200, 20, p);
            p.setColor(Color.GREEN);
            p.setAlpha(0x80);
            canvas.drawCircle(canvas.getWidth()/2,
                    canvas.getHeight()/4, canvas.getWidth()/4, p);
            p.setColor(Color.BLUE);
            p.setAlpha(0x80);
            canvas.drawRect(30,100, 200, 200, p);
        }
    }
}