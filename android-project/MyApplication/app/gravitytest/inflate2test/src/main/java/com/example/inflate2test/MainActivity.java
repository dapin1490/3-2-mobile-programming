package com.example.inflate2test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClick(View v){
		LinearLayout layout = findViewById(R.id.layout);
		TextView tv = (TextView)View.inflate(this,R.layout.textview,null);

		if(layout.getChildCount()%2 == 0){
			tv.setBackgroundColor(Color.BLUE);
			tv.setText(R.string.hi);
		} else{
			tv.setBackgroundColor(Color.RED);
		}
		layout.addView(tv);
	}
}