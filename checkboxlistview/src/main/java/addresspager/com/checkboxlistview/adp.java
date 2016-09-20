package addresspager.com.checkboxlistview;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by pravaeen kumar new on 24-05-2015.
 */
public class adp extends BaseAdapter {

    ArrayList<loadtmp> con = this.getContent();
    Context c;
    public adp(Context c){
        this.c=c;
    }

    @Override
    public int getCount() {
        return con.size();

    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater lay = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = lay.inflate(R.layout.listviewcontent, parent, false);
        }
        loadtmp l = this.con.get(position);
        //String tList = this.con.get(position);

        CheckedTextView t= (CheckedTextView)convertView.findViewById(R.id.lsttitle);
            if(l.getName().equals("test4")){
                ((ListView)parent).setItemChecked(position,true);
            }

        t.setText(l.getName());
        t.setTag(l.getTag());
        return convertView;
    }
    public ArrayList<loadtmp> getContent(){
        ArrayList<loadtmp> tmp = new ArrayList<loadtmp>();
        for(int i=0;i<25;i++){
           tmp.add(new loadtmp("test"+i,"tag"+i));
        }
        return tmp;
    }
}

class loadtmp{
    String name,tag;
    public loadtmp(String name,String tag){
        this.name=name;
        this.tag = tag;
    }
    public String getName(){
        return this.name;
    }
    public String getTag(){
            return this.tag;
    }

}