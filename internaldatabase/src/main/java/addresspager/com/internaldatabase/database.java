package addresspager.com.internaldatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by pravaeen kumar new on 30-05-15.
 */
public class database extends SQLiteOpenHelper {
    Context c;
    public static String DB_NAME = "mytrendz.db";
    public database(Context context){
        super(context, DB_NAME,null, 1);
        this.c=context;
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
    public Boolean checkAndCreateDatabase(){
        Boolean s = false;
        try {

            this.l("started checking database");
            SQLiteDatabase checkDb = null;
            String DB_PATH = "/data/data/"+this.c.getPackageName()+"/databases/"+DB_NAME;
            checkDb = SQLiteDatabase.openDatabase(DB_PATH,null,SQLiteDatabase.OPEN_READONLY);			
            if(checkDb != null){
               // s = true;
                this.l("already existing database");
                checkDb.close();
            }
            return s;
        }catch(SQLiteException e){
            this.l(e.getMessage());
        }
        return s;
    }
    public void l(String M){
        Log.i("praveen",M);
    }
    public void createDatabase()  {
        try{
            this.l("creating database");
            InputStream myInput = this.c.getAssets().open(DB_NAME);
            String DB_PATH = "/data/data/"+this.c.getPackageName()+"/databases/"+DB_NAME;
            OutputStream output = new FileOutputStream(DB_PATH);
            byte[] buf = new byte[1024];
            int length;
            while ((length = myInput.read(buf)) > 0) {
                output.write(buf, 0, length);
            }
            output.flush();
            output.close();
            myInput.close();
        }catch (Exception e){
            this.l(e.getMessage());
        }

    }
}
