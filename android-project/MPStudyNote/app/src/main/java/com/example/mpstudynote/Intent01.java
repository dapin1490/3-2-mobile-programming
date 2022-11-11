package com.example.mpstudynote;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class Intent01 extends AppCompatActivity {
    LinearLayout ll;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent01);

        ll = findViewById(R.id.intent01_ll);
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        ll.setBackgroundColor(result.getData().getIntExtra("color", Color.WHITE));
                    }
                });
    }

    public void onClick(View v) { // 버튼 레이아웃 onClick 속성에 지정된 이름과 똑같이 써야 함
        Intent i = new Intent(this, Intent01Sub.class);
        i.putExtra("msg", "Hi!");
//		startActivityForResult(i, 1); // requestCode는 인텐트를 여러 개 쓸 때 각 호출을 구분하기 위해 사용
        // startActivityForResult가 deprecate 예정이기 때문에 다른 방법을 사용할 줄 알아야 함
        launcher.launch(i); // 이게 그 다른 방법
    }

//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//		super.onActivityResult(requestCode, resultCode, data);
//
//		if (requestCode == 1 && resultCode == RESULT_OK) {
//			ll.setBackgroundColor(data.getIntExtra("color", Color.WHITE));
//		}
//	}
}