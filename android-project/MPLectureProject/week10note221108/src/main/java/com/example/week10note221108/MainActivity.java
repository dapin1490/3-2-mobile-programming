package com.example.week10note221108;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	ListView listview;
	EditText edit;
	SQLiteDatabase db;
	MemoHelper helper;
	Cursor cursor;
	SimpleCursorAdapter ca;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listview = findViewById(R.id.listview);
		edit = findViewById(R.id.edit);
		helper = new MemoHelper(this);
		db = helper.getReadableDatabase();
		cursor = db.rawQuery("select * from memos", null);
		ca = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor,
				new String[] {}, new int[] {android.R.id.text1},
				CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER); // 이 마지막 줄이 있어야 deprecate가 안됨

		listview.setAdapter(ca);
	}

	public void onClick(View v) {
		String str;
		ContentValues values;
		db = helper.getWritableDatabase();

		if (v.getId() == R.id.add) {
			str = edit.getText().toString();

			if (str.length() != 0) {
				values = new ContentValues();
				values.put("memo", str);
				long id = db.insert("memos", null, values);
			}

			cursor = db.rawQuery("select * from memos", null);
			ca.changeCursor(cursor);
			ca.notifyDataSetChanged();
		}
	}
}