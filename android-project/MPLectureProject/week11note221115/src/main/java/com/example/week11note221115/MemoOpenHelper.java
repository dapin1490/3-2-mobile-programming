package com.example.week11note221115;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MemoOpenHelper extends SQLiteOpenHelper {
    // DB = memos.db
    // table = memos
    // col = _id, memo
    public MemoOpenHelper(Context context) {
        super(context, "memos.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("create table memos( _id"
                + " integer primary key autoincrement, memo"
                + " text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists memos");
        onCreate(db);
    }
}