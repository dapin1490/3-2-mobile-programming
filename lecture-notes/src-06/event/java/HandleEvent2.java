package andexam.ver6.c08_input;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

/* 2.인터페이스 구현 객체 생성 - 별도의 클래스가 필요함 */
public class HandleEvent extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View vw = new View(this);
		// 3.리스너 등록
		vw.setOnTouchListener(TouchListener);
		setContentView(vw);
	}

	// 1.리스너 구현 클래스 선언
	class TouchListenerClass implements View.OnTouchListener {
		public boolean onTouch(View v, MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				Toast.makeText(HandleEvent.this,"Touch Event Received",
						Toast.LENGTH_SHORT).show();
				return true;
			}
			return false;
		}
	}

	// 2.리스너 객체 생성
	TouchListenerClass TouchListener = new TouchListenerClass();
}
//*/