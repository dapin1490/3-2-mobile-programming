package com.example.week13note221129;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

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
		Canvas cvs = new Canvas();
		RadioGroup rg = findViewById(R.id.group);
		rg.setOnCheckedChangeListener((group, checkedId) -> {
			switch (checkedId) {
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
			circle.draw(cvs);
			if (ll.getChildCount() > 1) // 이 부분 몰라서 틀림
				ll.removeView(circle);
			ll.addView(circle);
		});
	}

	// Circle 클래스 추가
	class Circle extends View {
		Paint pnt;
		public Circle(Context context) {
			super(context);
			pnt = new Paint();
		}

		@Override
		protected void onDraw(Canvas cvs) {
			super.onDraw(cvs); // 이것도 틀림
			cvs.drawColor(Color.WHITE);
			pnt.setColor(color);
			cvs.drawCircle(100, 100, 80, pnt);
		}
	}
}