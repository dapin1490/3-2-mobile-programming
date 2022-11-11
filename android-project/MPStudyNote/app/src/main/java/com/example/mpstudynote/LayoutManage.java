package com.example.mpstudynote;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LayoutManage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_manage);

        /*
        // 레이아웃 속성 변경
        * 코드에서 위젯을 참조하려면 id가 지정되어 있어야 한다.
        * 객체를 찾은 후 모든 메서드를 호출할 수 있다.
        * 코드의 색상 알파값은 투명(0x00), XML의 색상 알파값은 불투명(0xff)
        */
        LinearLayout MyLinear=(LinearLayout)findViewById(R.id.layout_manage_mylinear);
        MyLinear.setOrientation(LinearLayout.HORIZONTAL);

        Button MyBtn = (Button)findViewById(R.id.layout_manage_mybutton);
        MyBtn.setTextSize(40);

        EditText MyEdit = (EditText)findViewById(R.id.layout_manage_myedit);
        MyEdit.setBackgroundColor(0xff00ff00);

        /*
        // inflation2
        * ViewGroup의 addView() 메서드는 뷰를 부모 레이아웃과 연결
        * 뷰를 액티비티에 등록(뷰 내용을 액티비티에 채우기)
        */
        LinearLayout linear = new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);
        linear.setBackgroundColor(Color.LTGRAY);

        TextView text = new TextView(this);
        text.setText("TextView");
        text.setGravity(Gravity.CENTER);
        text.setTextColor(Color.RED);
        text.setTextSize(20);

        linear.addView(text);
        setContentView(linear);
        //* 파라미터 전달
        LinearLayout.LayoutParams paramlinear = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        setContentView(linear,paramlinear);
        //*/

        /*
        // inflation3
        * 리소스 ID로부터 전개하는 부분만 따로 수행 가능
        * inflate() 메서드 이용하여 리소스를 뷰 객체로 전개
        * 레이아웃 전개자 획득 -> 코드를 외워야 하는 건 아니지만 이런 게 있다는 사실은 알아둬야 함
        */
        /* XML 전개를 직접 하기
		LayoutInflater inflater = (LayoutInflater)getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);

		LinearLayout linear = (LinearLayout)inflater.inflate(R.layout.inflation, null);
		setContentView(linear);
		//*/

		/* 컨텍스트로부터 전개자 구하기
		LayoutInflater inflater = LayoutInflater.from(this);
		LinearLayout linear = (LinearLayout)inflater.inflate(R.layout.inflation, null);
		setContentView(linear);
		//*/

		/* View의 정적 메소드 사용하여 전개하기
		LinearLayout linear = (LinearLayout)View.inflate(this, R.layout.inflation, null);
		setContentView(linear);
		//*/

        //* 가장 짧은 전개 코드
        setContentView(View.inflate(this, R.layout.layout_manage, null));
        //*/

        /*
        // inflation4
        */
        LinearLayout linear2 = new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);
        linear.setBackgroundColor(Color.LTGRAY);

        TextView text2 = (TextView)View.inflate(this, R.layout.mytext, null);

        linear.addView(text2);
        setContentView(linear2);
    }
}