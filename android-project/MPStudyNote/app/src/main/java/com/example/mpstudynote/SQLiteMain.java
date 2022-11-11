package com.example.mpstudynote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SQLiteMain extends AppCompatActivity {
    ListView listview;
    EditText edit;
    SQLiteDatabase db;
    MemoHelper helper;
    Cursor cursor;
    SimpleCursorAdapter ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_main);

        listview = findViewById(R.id.sql_listview);
        edit = findViewById(R.id.sql_edit);
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

        if (v.getId() == R.id.sql_add) {
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

class Memo {
    private long id;
    private String str;

    public Memo(long id, String str) {
        this.id = id;
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}

class MemoHelper extends SQLiteOpenHelper {
    public MemoHelper(@Nullable Context context) {
        super(context, "memos.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table memos(_id integer primary key autoincrement, memo text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists memos");
        onCreate(db);
    }
}
