package addresspager.com.internaldatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new lib(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
class lib{
    Context c;
    public lib(Context c){
        this.c=c;
        this.queryExe();
    }
    public void queryExe(){
        //this.getWriteDatabase().execSQL("CREATE TABLE test (id  INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT  )");

        this.getWriteDatabase().execSQL("insert into test(name)values('test2')");
        Cursor c = this.getWriteDatabase().rawQuery("select * from test", null);
        if(c.moveToFirst()){
            do{
                Log.i("praveen",""+c.getInt(c.getColumnIndex("id"))+c.getString(c.getColumnIndex("name")));
            }while(c.moveToNext());

        }

        //this.getDatabase().
    }
    public SQLiteDatabase getWriteDatabase(){
        return new database(c).getWritableDatabase();
    }

}