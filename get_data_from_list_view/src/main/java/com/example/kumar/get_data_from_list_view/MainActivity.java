package com.example.kumar.get_data_from_list_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    ArrayList<loadtmp> _tmp,_tmp2;
    Button show_next_screen,close_screen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _tmp = new ArrayList<loadtmp>();
        _tmp2 = new ArrayList<loadtmp>();
        _tmp = this.getContent(1);
        _tmp2 = this.getContent(22);
        ListView list1 = (ListView)findViewById(R.id.list_1);
        ListView list2 = (ListView)findViewById(R.id.list_2);
        adp adapter = new adp(this,_tmp);
        adp ada = new adp(this,_tmp2);
        list1.setAdapter(adapter);
        list2.setAdapter(ada);
        adapter.notifyDataSetChanged();
        list1.setOnItemClickListener(this);
        list2.setOnItemClickListener(this);
        show_next_screen = (Button)findViewById(R.id.show_next_screen);
        show_next_screen.setOnClickListener(this);
        close_screen = (Button)findViewById(R.id.close_screen);
        close_screen.setOnClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            switch(adapterView.getId()){
                case R.id.list_1:
                    loadtmp ll = _tmp.get(i);
                    printText(ll.getName()+" id "+ll.getId());
                break;
                case R.id.list_2:
                    loadtmp l2 = _tmp2.get(i);
                    printText(l2.getName()+" id "+l2.getId());
                break;
            }

        }

    public ArrayList<loadtmp> getContent(int _start_val){
        //int _start_val = 10;
        ArrayList<loadtmp> tmp = new ArrayList<loadtmp>();

        for(int start_val = _start_val;start_val<(_start_val +10);start_val++){
            tmp.add(new loadtmp("test"+start_val,start_val));
        }
        return tmp;
    }
    public void printText(String text){
        Log.i("praveen ", text);
    }

    @Override
    public void onClick(View view) {
        //printText("calling");
        LinearLayout lay_next = (LinearLayout) findViewById(R.id.lay_next);
        RelativeLayout parent_lay = (RelativeLayout) findViewById(R.id.parent_lay);

        switch (view.getId() ){
            case R.id.show_next_screen:
                printText("show next screen");
                view.setVisibility(View.INVISIBLE);
                TranslateAnimation slide = new TranslateAnimation(0,0, parent_lay.getBottom(),parent_lay.getTop());
                slide.setDuration(1000);
                slide.setFillAfter(true);
                slide.setRepeatCount(0);
                lay_next.startAnimation(slide);
               // lay_next.setVisibility(View.VISIBLE);
            break;
            case R.id.close_screen:
                printText("Close screen");
                TranslateAnimation slide2 = new TranslateAnimation(-parent_lay.getLeft(),-parent_lay.getLeft(), parent_lay.getTop(),parent_lay.getBottom());
                slide2.setDuration(1000);
                //slide2.setFillAfter(true);
                lay_next.startAnimation(slide2);
                slide2.setRepeatCount(0);
                lay_next.setVisibility(View.GONE);
                show_next_screen.setVisibility(View.VISIBLE);
            break;
        }


    }
}
