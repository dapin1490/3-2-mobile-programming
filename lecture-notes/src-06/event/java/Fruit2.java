package andexam.ver6.c08_input;

import andexam.ver6.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Fruit2 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fruit2);
	}

	public void mOnClick(View v) {
		TextView textFruit=(TextView)findViewById(R.id.fruit);
		switch (v.getId()) {
		case R.id.apple:
			textFruit.setText("Apple");
			break;
		case R.id.orange:
			textFruit.setText("Orange");
			break;
		}
	}
}