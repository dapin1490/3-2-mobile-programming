package andexam.ver6.c08_input;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

/* 5.익명 이너 클래스 사용 */
public class HandleEvent extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View vw = new View(this);
		vw.setOnTouchListener(TouchListener);
		setContentView(vw);
	}

	View.OnTouchListener TouchListener = new View.OnTouchListener() {
		public boolean onTouch(View v, MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				Toast.makeText(HandleEvent.this,"Touch Event Received",
						Toast.LENGTH_SHORT).show();
				return true;
			}
			return false;
		}
	};
}
//*/