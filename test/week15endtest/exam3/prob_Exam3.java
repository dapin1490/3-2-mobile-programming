import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

// 사용할 때 파일 이름을 MainActivity로 수정 필요

public class MainActivity extends AppCompatActivity _________________________________ {
    ListView list;
    ArrayAdapter<String> adapter;
    List<String> species1;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);

        species1 = new ArrayList<>();
        species1.add("포유류");
        species1.add("조류");
        species1.add("어류");

        list.setOnItemClickListener(this);
        adapter = ___________________________________________________________ ;
        list.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        
				// 적절한 코드 추가
				
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
				// 적절한 코드 추가
				
    }
}