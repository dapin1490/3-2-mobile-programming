package com.example.hiadnroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyPath(this));
    }

    protected class MyPath extends View {
        Path path; Paint p;

        public MyPath(Context context) {
            super(context);
            path = new Path();
            p = new Paint();
        }

        public void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            p.setStrokeWidth(5);
            p.setColor(Color.RED);
            p.setStyle(Paint.Style.STROKE);
            path.addRect(50,50,150,150,Path.Direction.CW);
            canvas.drawPath(path, p);

            path.reset();
            p.setColor(Color.BLUE);
            path.addCircle(100, 100, 40, Path.Direction.CW);
            canvas.drawPath(path, p);

            path.reset();
            path.moveTo(10, 100);
            path.lineTo(50, 150);
            path.moveTo(150, 150);
            path.rLineTo(50, -50);
            p.setStrokeWidth(3);
            p.setAntiAlias(true);
            canvas.drawPath(path, p);
        }
    }
}