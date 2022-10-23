package com.example.week07note221018;

/* 제출한 답안
public class MainActivity extends AppCompatActivity {
	private ArrayList<String> list;
	private ArrayAdapter<String> adapter;
	private EditText edit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView lv = findViewById(R.id.list_item);
		edit = findViewById(R.id.edittext);
		list = new ArrayList<>();

		adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, list);
		lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener((adapterView, view, i, l) -> {
			switch (view.getId()) {
				case R.id.addbtn:
					String txt = edit.getText().toString();
					if (txt.isEmpty())
						break;
					list.add(txt);
					edit.setText("");
					adapter.notifyDataSetChanged();
					break;
				case R.id.delbtn:
					Object clickItemObj = adapterView.getAdapter().getItem(i);
					list.remove(clickItemObj.toString());
					adapter.notifyDataSetChanged();
					break;
			}
		});
	}
}
*/

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

// 풀이
public class MainActivity extends AppCompatActivity {
	ListView list;
	EditText edt;
	List<String> ls;
	ArrayAdapter<String> arradapter;
	int posi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		list = findViewById(R.id.list_item);
		edt = findViewById(R.id.edittext);
		ls = new ArrayList<>();

		arradapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, ls);
		list.setAdapter(arradapter);
		list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		list.setOnItemClickListener((adview, view, position, id) -> posi = position);
	}

	public void onClick(View v) {
		if (v.getId() == R.id.addbtn) {
			String txt = edt.getText().toString();
			if (txt.length() != 0) {
				ls.add(txt);
			}
		} else if (v.getId() == R.id.delbtn) {
			if (posi != ListView.INVALID_POSITION) {
				ls.remove(posi);
				list.clearChoices();
			}
		}
		edt.setText("");
		posi = ListView.INVALID_POSITION;
		arradapter.notifyDataSetChanged();
	}
}