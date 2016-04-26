package com.example.kumar.get_data_from_list_view;

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

    //ArrayList<loadtmp> con = this.getContent();
    ArrayList<loadtmp> con = null;
    Context c;
    public adp(Context c,ArrayList<loadtmp> con){
        this.c=c;
        this.con= con;
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
            convertView = lay.inflate(R.layout.list_items, parent, false);
        }
        loadtmp l = this.con.get(position);
        TextView tmp = (TextView)convertView.findViewById(R.id.item_name);
        tmp.setText(l.getName());
        return convertView;
    }

}

class loadtmp{
    String name;
    int id;
    public loadtmp(String name,int tag){
        this.name=name;
        this.id = tag;
    }
    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }

};