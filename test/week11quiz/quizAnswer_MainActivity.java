package com.example.week11note221115;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// 제출 답안
public class MainActivity extends AppCompatActivity {
	ListView listview;
	EditText edit;
	SQLiteDatabase db;
	MemoOpenHelper helper;
	SimpleCursorAdapter ca;
	Cursor cursor;
	TextView textview;
	int posi;
	Context maincon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textview = findViewById(R.id.textview);
		textview.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
		edit = findViewById(R.id.edit);
		listview = findViewById(R.id.listview);
		maincon = this;

		helper = new MemoOpenHelper(this);
		db = helper.getReadableDatabase();
		cursor = db.query("memos", new String[]{"_id", "memo"},
				null, null, null, null, null);
		ca = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor,
				new String[]{"memo"}, new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		listview.setAdapter(ca);
		listview.setOnItemClickListener((adview, view, position, id) -> {
			Log.d("myMain", "setOnItemClickListener");
			posi = position;
//			String str;
//			if (posi != ListView.INVALID_POSITION) {
//				Log.d("myMain", "if in setOnItemClickListener");
//				str = (String) listview.getItemAtPosition(posi);
//				textview.setText(str);
//				textview.setTextColor(Color.RED);
//			}
		});
	}

	public void onClick(View view) {
		String str;
		ContentValues values;
		db = helper.getWritableDatabase();
		switch (view.getId()) {
			case R.id.add:
				str = edit.getText().toString();
				textview.setText(str);
				textview.setTextColor(Color.RED);
				if (str.length() != 0) {
					values = new ContentValues();
					values.put("memo", str);
					long id = db.insert("memos", null, values);
				}
				break;
			case R.id.del:
				Cursor c;
				if (posi != ListView.INVALID_POSITION) {
					c = (Cursor)ca.getItem(posi);
					db.delete("memos", "_id=" + c.getLong(0), null);
					c.close();
				}
				else {
					Toast.makeText(maincon, "삭제할 항목을 선택하지 않았습니다", Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.upd:
				ContentValues upstr = new ContentValues();
				str = edit.getText().toString();
				upstr.put("newText", str);
				textview.setText(str);
				textview.setTextColor(Color.RED);
				if (str.length() != 0 && posi != ListView.INVALID_POSITION) {
					c = (Cursor)ca.getItem(posi);
					// db.update("memos", null, "_id=" + c.getLong(0));
				}
				if (str.length() <= 0) {
					Toast.makeText(maincon, "선택된 항목에 변화가 없습니다.", Toast.LENGTH_SHORT).show();
				}
				if (posi == ListView.INVALID_POSITION) {
					Toast.makeText(maincon, "수정할 항목을 선택하지 않았습니다", Toast.LENGTH_SHORT).show();
				}
				break;
		}

		cursor = db.query("memos", new String[]{"_id", "memo"}, null, null, null, null, null);
		ca.changeCursor(cursor);
		edit.setText("");
		posi = ListView.INVALID_POSITION;
		listview.clearChoices();
	}
}

// 풀이
public class MainActivity extends AppCompatActivity {
	ListView listview;
	EditText edit;
	SQLiteDatabase db;
	MemoOpenHelper helper;
	SimpleCursorAdapter ca;
	Cursor cursor;
	int posi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView textview = findViewById(R.id.textview);
		textview.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
		edit = findViewById(R.id.edit);
		listview = findViewById(R.id.listview);

		helper = new MemoOpenHelper(this);
		db = helper.getReadableDatabase();
		cursor = db.query("memos", new String[]{"_id", "memo"},
				null, null, null, null, null);
		ca = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor,
				new String[]{"memo"}, new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		listview.setAdapter(ca);
		setEnabled(false);
		listview.setOnItemClickListener((parent, view, position, id) -> {
			posi = position;
			setEnabled(true);
			if (posi != ListView.INVALID_POSITION) {
				Cursor cs = (Cursor)ca.getItem(posi);
				textview.setText(cs.getString(1));
				textview.setTextColor(Color.RED);
			}
		});
	}

	public void onClick(View view) {
		String str;
		ContentValues values;
		Cursor c;
		db = helper.getWritableDatabase();
		switch (view.getId()) {
			case R.id.add:
				str = edit.getText().toString();
				if (str.length() != 0) {
					values = new ContentValues();
					values.put("memo", str);
					long id = db.insert("memos", null, values);
				}
				break;
			case R.id.del:
				c = (Cursor)ca.getItem(posi);
				db.delete("memos", "_id=" + c.getLong(0), null);
				c.close();
				break;
			case R.id.upd:
				c = (Cursor)ca.getItem(posi);
				str = edit.getText().toString();
				if (str.length() != 0) {
					values = new ContentValues();
					values.put("memo", str);
					db.update("memos", values, "_id=" + c.getLong(0), null);
					c.close();
				}
				break;
		}

		cursor = db.query("memos", new String[]{"_id", "memo"}, null, null, null, null, null);
		ca.changeCursor(cursor);
		edit.setText("");
		setEnabled(false);
	}

	public void setEnabled(boolean enabled) {
		((Button)findViewById(R.id.del)).setEnabled(enabled);
		((Button)findViewById(R.id.upd)).setEnabled(enabled);
	}
}

// 수정한 답안(테스트 안함)
public class MainActivity extends AppCompatActivity {
	ListView listview;
	EditText edit;
	SQLiteDatabase db;
	MemoOpenHelper helper;
	SimpleCursorAdapter ca;
	Cursor cursor;
	TextView textview;
	int posi;
	Context maincon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textview = findViewById(R.id.textview);
		textview.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
		edit = findViewById(R.id.edit);
		listview = findViewById(R.id.listview);
		maincon = this;

		helper = new MemoOpenHelper(this);
		db = helper.getReadableDatabase();
		cursor = db.query("memos", new String[]{"_id", "memo"},
				null, null, null, null, null);
		ca = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor,
				new String[]{"memo"}, new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		listview.setAdapter(ca);
		listview.setOnItemClickListener((adview, view, position, id) -> {
			Log.d("Main Act", "listview.setOnItemClickListener in");
			posi = position;
			if (posi != ListView.INVALID_POSITION) {
				Log.d("Main Act", "리스트 항목 중 하나를 선택하면 선택된 내용이 ‘선택 혹은 추가된 항목‘(EditText)에 나타남. (5점)");
				Cursor cs = (Cursor)ca.getItem(posi);
				textview.setText(cs.getString(1));
				Log.d("Main Act", "나타난 항목의 문자색을 빨간색으로 나타냄(5점)");
				textview.setTextColor(Color.RED);
			}
			Log.d("Main Act", "listview.setOnItemClickListener out");
		});
	}

	public void onClick(View view) {
		Log.d("Main Act", "onClick in");

		String str;
		ContentValues values;
		Cursor c;
		db = helper.getWritableDatabase();

		switch (view.getId()) {
			case R.id.add:
				Log.d("Main Act", "selected case R.id.add");

				str = edit.getText().toString();
				if (str.length() != 0) {
					textview.setText(str);
					Log.d("Main Act", "리스트 항목 중 하나를 선택하면 선택된 내용이 ‘선택 혹은 추가된 항목‘(EditText)에 나타남. (5점)");
					textview.setTextColor(Color.RED);
					Log.d("Main Act", "나타난 항목의 문자색을 빨간색으로 나타냄(5점)");
					values = new ContentValues();
					values.put("memo", str);
					long id = db.insert("memos", null, values);
					Log.d("Main Act", "new memo added");
				}
				break;
			case R.id.del:
				Log.d("Main Act", "selected case R.id.del");

				if (posi != ListView.INVALID_POSITION) {
					c = (Cursor)ca.getItem(posi);
					Log.d("Main Act", "Cursor set");
					db.delete("memos", "_id=" + c.getLong(0), null);
					Log.d("Main Act", "memo id=" + c.getLong(0) + " deleted");
					Log.d("Main Act", "리스트 항목 중 하나를 선택한 후 선택한 항목을 삭제(15점)");
					c.close();
					Log.d("Main Act", "Cursor close");
				}
				else {
					Log.d("Main Act", "no item to delete");
					Log.d("Main Act", "리스트에 있는 항목을 선택하지 않고 삭제를 시도하면 '삭제할 항목을 선택하지 않았습니다'와 같은 Toast 메시지 출력(5점)");
					Toast.makeText(maincon, "삭제할 항목을 선택하지 않았습니다", Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.upd:
				Log.d("Main Act", "selected case R.id.del");

				values = new ContentValues();
				str = edit.getText().toString();
				values.put("memo", str);

				if (str.length() != 0 && posi != ListView.INVALID_POSITION) {
					c = (Cursor)ca.getItem(posi);
					db.update("memos", values, "_id=" + c.getLong(0), null);
					Log.d("Main Act", "에디트텍스트의 내용을 수정한 후 [수정] 버튼을 클릭하면 리스트 항목의 내용이 변경됨. (10점)");
				}
				if (str.length() <= 0) {
					Toast.makeText(maincon, "선택된 항목에 변화가 없습니다.", Toast.LENGTH_SHORT).show();
					Log.d("Main Act", "에디트텍스트 내용이 변경되지 않은 채 [수정] 버튼을 클릭하면 '선택된 항목에 변화가 없습니다.'와 같은 Toast 메시지 출력. (5점)");
				}
				if (posi == ListView.INVALID_POSITION) {
					Toast.makeText(maincon, "수정할 항목을 선택하지 않았습니다", Toast.LENGTH_SHORT).show();
					Log.d("Main Act", "리스트에 있는 항목을 선택하지 않고 수정을 시도하면 '수정할 항목을 선택하지 않았습니다'와 같은 Toast 메시지 출력 (5점)");
				}
				break;
		}

		cursor = db.query("memos", new String[]{"_id", "memo"}, null, null, null, null, null);
		ca.changeCursor(cursor);
		edit.setText("");
		posi = ListView.INVALID_POSITION;
		listview.clearChoices();

		Log.d("Main Act", "onClick out");
	}
}