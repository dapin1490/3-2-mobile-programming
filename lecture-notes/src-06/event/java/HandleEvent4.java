package andexam.ver6.c08_input;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

/* 4.뷰에서 리스너 구현 */
public class HandleEvent extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyView vw = new MyView(this);
		vw.setOnTouchListener(vw);
		setContentView(vw);
	}

	class MyView extends View implements View.OnTouchListener {
		public MyView(Context context) {
			super(context);
		}

		public boolean onTouch(View v, MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				Toast.makeText(HandleEvent.this,"Touch Event Received",
						Toast.LENGTH_SHORT).show();
				return true;
			}
			return false;
		}
	}
}
//*/