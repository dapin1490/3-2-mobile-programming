package com.example.week08midtest221025;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	// 필요하다면 적절한 코드 추가

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);

		Button btn = new Button(this);
		btn.setText("Greeting");

		// 적절한 코드 추가
		layout.addView(btn);
		setContentView(layout);
		btn.setOnClickListener(new MyListener(this));
	}
}

// 필요하다면 MyListener 클래스 수정
class MyListener implements View.OnClickListener {
	// 적절한 코드 추가
	Context maincon;
	boolean flag;

	public MyListener(Context context) {
		maincon = context;
		flag = true;
	}

	public void onClick(View view) {
		// 적절한 코드 추가
		if (flag) {
			Toast.makeText(maincon,"Hi!", Toast.LENGTH_SHORT).show();
			flag = !flag;
		}
		else {
			Toast.makeText(maincon,"Bye!", Toast.LENGTH_SHORT).show();
			flag = !flag;
		}
	}
}