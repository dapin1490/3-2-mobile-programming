package com.example.week09lecture;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
	int color;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);

		Intent intent = getIntent();
		Toast.makeText(this, intent.getCharSequenceExtra("msg"), Toast.LENGTH_SHORT).show();

		((RadioGroup)findViewById(R.id.group)).setOnCheckedChangeListener((rg, idx) -> color = (idx == R.id.red ? Color.RED : Color.BLUE));
		// 원래 색깔 세 가지 해야 하는데 간단하게 두 가지만 했음
	}

	public void onClick(View v) {
		Intent intent = new Intent();
		intent.putExtra("color", color); // key, value
		setResult(RESULT_OK, intent);
		finish();
	}
}