package com.example.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by praveenkumar on 4/28/2016.
 */
public class custom_v extends LinearLayout {
    TextView text,title;
    String val;
    public custom_v(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.cus_lay, this);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        text = (TextView) findViewById(R.id.text);
        title = (TextView) findViewById(R.id.title);
        //text.setText("Praveen");
    }
    public custom_v loadTitleText(String t){
        title.setText(t);
        return this;
    }
    public void loadText(String t){
        text.setText(t);
    }
}
