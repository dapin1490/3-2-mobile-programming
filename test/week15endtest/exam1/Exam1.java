import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

// 사용할 때 파일 이름을 MainActivity로 수정 필요

public class MainActivity extends AppCompatActivity {
    EditText edit;
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.edit1);
        
		// 적절한 코드 추가
        launcher = registerForActivityResult(
				new ActivityResultContracts.StartActivityForResult(),
				result -> {
					if (result.getResultCode() == RESULT_OK) {
                        Intent intent = getIntent();
                        Toast.makeText(this, intent.getStringExtra("msg2"), Toast.LENGTH_SHORT).show();
					}
				});
    }

    public void onClick(View view) {
        // 적절한 코드 추가
        Intent i = new Intent(this, SubActivity.class);
		i.putExtra("msg1", edit.getText().toString());
        launcher.launch(intent);
    }
}