package addresspager.com.frag_multiple_screens;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.list);
        final ArrayList<String> t = getData();
        adapter adp = new adapter(t,this);
        list.setAdapter(adp);
        adp.notifyDataSetChanged();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(findViewById(R.id.list_details) != null){
                    TextView list_details = (TextView)findViewById(R.id.list_details);
                    list_details.setText(""+t.get(i));
                }else{
                    //lo(""+t.get(i));
                    Toast.makeText(MainActivity.this,""+t.get(i),Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    public ArrayList<String> getData(){
        ArrayList<String> t = new ArrayList<>();
        for(int i=0;i<10;i++){
            t.add("test"+i);
        }
        return  t;
    }

    public void lo(String M){
        Log.i("praveen_log",M);

    }
}

class adapter extends BaseAdapter{
    ArrayList<String> data;
    Context c ;
    public adapter(ArrayList<String> tmp,Context c){
        this.data = tmp;
        this.c = c;
    }
    @Override
    public int getCount() {
        return this.data.size();
    }
    @Override
    public Object getItem(int i) {
        return i;
    }
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater lay = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = lay.inflate(R.layout.list_item, viewGroup, false);
        }
        //View v = LayoutInflater.from(this.c).inflate(R.layout.list_item,viewGroup);
           TextView tmp  = (TextView) view.findViewById(R.id.txt);
           ArrayList<String> _t = this.data;
           tmp.setText(""+_t.get(i));
        return view;
    }
}