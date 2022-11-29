package com.example.week13note221129;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CustomView extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyView mv = new MyView(this);
		setContentView(mv);
	}

	class MyView extends View {
		public MyView(Context context) {
			super(context);
		}

		public void onDraw(Canvas cvs) {
			cvs.drawColor(Color.LTGRAY);
			Paint pnt = new Paint();
			pnt.setColor(Color.BLUE);
			cvs.drawCircle(100, 100, 80, pnt);
		}
	}
}
