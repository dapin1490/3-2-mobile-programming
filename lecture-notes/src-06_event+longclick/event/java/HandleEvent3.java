package andexam.ver6.c08_input;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

/* 3.액티비티가 리스너 구현 */
public class HandleEvent extends Activity implements View.OnTouchListener {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View vw = new View(this);
		vw.setOnTouchListener(this);
		setContentView(vw);
	}

	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			Toast.makeText(this,"Touch Event Received",
					Toast.LENGTH_SHORT).show();
			return true;
		}
		return false;
	}
}
//*/