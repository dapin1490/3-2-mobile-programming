package com.example.week06note221011;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	boolean btnflag01 = true;
	boolean btnflag02 = true;

//	TextView text01 = (TextView)findViewById(R.id.tv01);
//	TextView text02 = (TextView)findViewById(R.id.tv02);
//
//	Listener lisner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		Button btn01 = findViewById(R.id.btn01);
//		Button btn02 = findViewById(R.id.btn02);
//
//		lisner = new Listener(text01, this);
//
//		btn01.setOnClickListener(lisner);
//
//		btn02.setOnClickListener(v -> {
//			TextView text02 = (TextView)findViewById(R.id.tv02);
//			text02.setGravity(btnflag02 ? Gravity.CENTER : Gravity.LEFT);
//			btnflag02 = !btnflag02;
//		});
	}

//	View.OnClickListener listener = new View.OnClickListener() {
//		@Override
//		public void onClick(View v) {
//
//		}
//	};

	public void onClick(View v) {
		TextView text01 = (TextView)findViewById(R.id.tv01);
		TextView text02 = (TextView)findViewById(R.id.tv02);

		switch (v.getId()) {
			case R.id.btn01:
				text01.setBackgroundColor(btnflag01 ? Color.WHITE : Color.GREEN);
				btnflag01 = !btnflag01;
				break;
			case R.id.btn02:
				text02.setGravity(btnflag02 ? Gravity.CENTER : Gravity.START);
				btnflag02 = !btnflag02;
				break;
		}
	}
}

//class Listener implements View.OnClickListener {
//	boolean btnflag01;
//	boolean btnflag02;
//
//	TextView text01;
//	Context c;
//
//	public Listener(TextView text01, Context c) {
//		this.text01 = text01;
//		this.c = c;
//	}
//
//	@Override
//	public void onClick(View v) {
//		switch (v.getId()) {
//		case R.id.btn01:
//			text01.setBackgroundColor(btnflag01 ? Color.WHITE : Color.GREEN);
//			btnflag01 = !btnflag01;
//			Toast.makeText(c, "ok", Toast.LENGTH_SHORT).show();
//			break;
//		case R.id.btn02:
////			text02.setGravity(btnflag02 ? Gravity.CENTER : Gravity.LEFT);
//			btnflag02 = !btnflag02;
//			break;
//		}
//	}
//}