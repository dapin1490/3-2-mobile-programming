import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {
    EditText edit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent intent = getIntent();
        Toast.makeText(this, intent.getStringExtra("msg1"), Toast.LENGTH_SHORT).show();
        edit2 = findViewById(R.id.edit2);
    }

    public void onClick(View view) {
        Intent data = new Intent();
        data.putExtra("msg2", edit2.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }
}