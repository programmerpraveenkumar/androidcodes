package addresspager.com.checkboxlistview;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;


public class MainActivity extends FragmentActivity implements View.OnClickListener {
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst = (ListView)findViewById(R.id.lst);
        adp a = new adp(this);
        lst.setAdapter(a);
        lst.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        a.notifyDataSetChanged();
        lst.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                l(""+ absListView.getFirstVisiblePosition());
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });
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
    public void test(View v){
        try {
            Log.i("test", "test");

            for (int i = 0; i < lst.getChildCount(); i++) {
                View vv = lst.getChildAt(i);
                CheckedTextView val =(CheckedTextView)vv.findViewById(R.id.lsttitle);
                if(val.isChecked()){
                    Log.i("test","get val  "+val.getTag());
                }
            }
        }catch(Exception e){
            Log.i("test",e.getMessage());
        }
    }

    @Override
    public void onClick(View v) {
        Log.i("tets","here camoe");
        switch(v.getId()){
            case R.id.lsttitle:
                ((CheckedTextView)v).toggle();
            break;
        }
    }
    public void l(String M){
        Log.i("praveen",M);
    }
}
