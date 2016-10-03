package com.praveen.grid_view_touch_listener;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        final float[] startx = new float[1];
        int endx;
        gridview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float currentXPosition = motionEvent.getX();
                float currentYPosition = motionEvent.getY();
                TextView tv;
                int position;
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        //float currentXPosition = motionEvent.getX();
                        //float currentYPosition = motionEvent.getY();
                        position = gridview.pointToPosition((int) currentXPosition, (int) currentYPosition);
                        // Access text in the cell, or the object itself
//                        String s = (String) gridview.getItemAtPosition(position);
                        tv = (TextView) gridview.getChildAt(position);
                        if(tv != null)
                        tv.setTextColor(Color.RED);
                    break;
                    case MotionEvent.ACTION_MOVE:
                        position = gridview.pointToPosition((int) currentXPosition, (int) currentYPosition);
                        // Access text in the cell, or the object itself
//                        String s = (String) gridview.getItemAtPosition(position);
                         tv = (TextView) gridview.getChildAt(position);
                        if( tv != null)
                            tv.setTextColor(Color.RED);
                        break;
                    case MotionEvent.ACTION_UP:
//                        startx[1] = motionEvent.getY();
                    break;
                }
                return false;
            }
        });
    }
}
class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return 10;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        final TextView tView;

        if (convertView == null) {
            tView = new TextView(mContext);
            tView.setPadding(0, 0, 0, 0);
        }
        else
        {
            tView = (TextView) convertView;
        }
        tView.setText("test "+position);
//        tView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (MotionEvent.ACTION_DOWN == motionEvent.getAction()) {
//                    tView.setTextColor(Color.RED);
//                    // Here you can put animation for your image view
//                    // this.buttonImage is the target image view.
//                }
//                return false;
//            }
//        });
        return tView;
    }


}