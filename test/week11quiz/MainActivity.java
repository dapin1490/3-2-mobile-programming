public class MainActivity extends AppCompatActivity {
    ListView listview;
    EditText edit;
    SQLiteDatabase db;
    MemoOpenHelper helper;
    SimpleCursorAdapter ca;
    Cursor cursor;

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
    }

    public void onClick(View view) {
        String str;
        ContentValues values;
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
                Cursor c = (Cursor)ca.getItem(0);
                db.delete("memos", "_id=" + c.getLong(0), null);
                c.close();
                break;
        }

        cursor = db.query("memos", new String[]{"_id", "memo"},
                null, null, null, null, null);
        ca.changeCursor(cursor);
        edit.setText("");
    }
}