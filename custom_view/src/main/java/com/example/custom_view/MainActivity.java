package com.example.custom_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        custom_v praveen_lay = (custom_v) findViewById(R.id.cus);
        praveen_lay.loadTitleText("Title of the page")
                .loadText("you got this values");
        //Log.i("praveen",""+R.id.cus+" "+praveen_lay._v_id());
//        Log.i("praveen",""+R.id.cus+" "+praveen_lay._v_id());
    }
}
