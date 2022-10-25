import android.content.Context;


public class MainActivity extends AppCompatActivity {
    // 필요하다면 적절한 코드 추가

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        Button btn = new Button(this);
        btn.setText("Greeting");
        
		// 적절한 코드 추가
    }
}

// 필요하다면 MyListener 클래스 수정
class MyListener {
	// 적절한 코드 추가

    public void onClick(View view) {
        // 적절한 코드 추가
    }
}