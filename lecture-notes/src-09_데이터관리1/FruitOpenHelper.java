import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FruitOpenHelper extends SQLiteOpenHelper {
    public FruitOpenHelper(Context context) {

        super(context, "fruits.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table fruits ("
                + "_id integer primary key autoincrement, "
                + "name text, price integer);");
        db.execSQL("insert into fruits values (null, '사과',  1500);");
        db.execSQL("insert into fruits values (null, '바나나',  1000);");
        db.execSQL("insert into fruits values (null, '오렌지',  2000);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists fruits");
        onCreate(db);
    }
}