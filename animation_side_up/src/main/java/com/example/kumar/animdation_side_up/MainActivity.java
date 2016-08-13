package com.example.kumar.animdation_side_up;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button show_animation;
    Button hide_animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show_animation = (Button) findViewById(R.id.show_animation);
        hide_animation = (Button) findViewById(R.id.hide_animation);
        show_animation.setOnClickListener(this);
        hide_animation.setOnClickListener(this);
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

//    @Override
//    public void onClick(View v) {
//        //v.setClickable(false);
//
//        LinearLayout layout = (LinearLayout) findViewById(R.id.anim_layout);
//        Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
//        Animation slideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
//        if (v.getId() == R.id.make_animation) {
//            Toast.makeText(this, "visible", Toast.LENGTH_SHORT).show();
//
//            layout.startAnimation(slideUp);
//            layout.setVisibility(View.VISIBLE);
//            make_animation.setVisibility(View.INVISIBLE);
//        } else if (v.getId() == R.id.close) {
//            {
//                Toast.makeText(this, "In visible", Toast.LENGTH_SHORT).show();
//                layout.startAnimation(slideDown);
//                layout.setVisibility(View.INVISIBLE);
//                make_animation.setVisibility(View.VISIBLE);
//            }
//            //v.setClickable(true);
//        }
    @Override
    public void onClick(View view) {
        try{

            LinearLayout ani_layout = (LinearLayout)findViewById(R.id.ani_layout);
            if(view.getId()== R.id.show_animation){
                ani_layout.setVisibility(LinearLayout.VISIBLE);
                ani_layout.bringToFront();
                //TranslateAnimation slide = new TranslateAnimation(0,0,1.0f,10.0f);
                TranslateAnimation slide = new TranslateAnimation(  0, 0,0, 0f, Animation.RELATIVE_TO_PARENT, 1.0f, Animation.RELATIVE_TO_PARENT, 0f);
                slide.setDuration(1000);
                slide.setFillAfter(true);
                ani_layout.startAnimation(slide);
                show_animation.setVisibility(View.INVISIBLE);
            }else if(view.getId()== R.id.hide_animation){
                Toast.makeText(this,"Error hide calling ",Toast.LENGTH_SHORT).show();
                TranslateAnimation slide = new TranslateAnimation(  0, 0,0, 0f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 1.0f);
                slide.setDuration(1000);
                slide.setFillAfter(true);
                ani_layout.startAnimation(slide);
                ani_layout.setVisibility(View.INVISIBLE);
                show_animation.setVisibility(View.VISIBLE);
            }
        }catch (Exception e){
            Toast.makeText(this,"Error "+e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }
}
