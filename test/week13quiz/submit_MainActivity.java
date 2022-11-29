package com.example.week13note221129;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	Circle circle;
	LinearLayout ll;
	int color = Color.RED;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		circle = new Circle(this);
		ll = findViewById(R.id.ll);

		// 필요한 코드 추가
		ll.setOnClickListener(v -> {
			switch (v.getId()) {
				case R.id.red:
					color = Color.RED;
					break;
				case R.id.green:
					color = Color.GREEN;
					break;
				case R.id.blue:
					color = Color.BLUE;
					break;
			}
			circle.draw(new Canvas());
			setContentView(circle);
		});
	}

	// Circle 클래스 추가
	class Circle extends View {
		public Circle(Context context) {
			super(context);
		}

		public void OnDraw(Canvas cvs) {
			cvs.drawColor(Color.WHITE);
			Paint pnt = new Paint();
			pnt.setColor(color);
			cvs.drawCircle(100, 100, 80, pnt);
		}
//		Context mc;
//		public Circle(Context context) {
//			mc = context;
//		}
//
//		@Override
//		public void onClick(View v) {
//			switch (v.getId()) {
//				case R.id.red:
//					color = Color.RED;
//					break;
//				case R.id.green:
//					color = Color.GREEN;
//					break;
//				case R.id.blue:
//					color = Color.BLUE;
//					break;
//			}
//			Canvas cvs = new Canvas();
//			cvs.drawColor(Color.WHITE);
//			Paint pnt = new Paint();
//			pnt.setColor(color);
//			cvs.drawCircle(100, 100, 80, pnt);
//		}
	}
}