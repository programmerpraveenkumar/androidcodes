package addresspager.com.internaldatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pravaeen kumar new on 30-05-15.
 */
public class database extends SQLiteOpenHelper {
    public database(Context context){
        super(context, "test.db",null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void todo(){
        this.getWritableDatabase();

    }
}
