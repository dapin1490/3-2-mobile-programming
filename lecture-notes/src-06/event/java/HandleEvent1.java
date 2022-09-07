package andexam.ver6.c08_input;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

//* 1.핸들러 메소드 재정의 - 상속을 받아야만 재정의 가능하다.
public class HandleEvent1 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View vw = new MyView(this);
		setContentView(vw);
	}

	class MyView extends View {
		public MyView(Context context) {
			super(context);
		}

		public boolean onTouchEvent(MotionEvent event) {
			super.onTouchEvent(event);
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