package com.example.mplectureproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		EditText edit = findViewById(R.id.edit); // 그냥 edit은 텍스트도 아니고 char시퀀스도 아님
//		String s = edit.getText().toString(); // 토스트에 edit 그대로 쓰면 안 됨

		Button btn = findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText edit = findViewById(R.id.edit);
				String s = edit.getText().toString();

				Toast.makeText(MainActivity.this, "button pressed", Toast.LENGTH_LONG).show();
				Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
			}
		});

		Toast.makeText(this, "this is a toast", Toast.LENGTH_LONG).show(); // 꼭 뒤에 show를 달아줘야 나타남
	}
}

//class Test {
//	public void foo() {
//		EditText edit = findViewById(R.id.edit);
//		String s = edit.getText().toString();
//	}
//}