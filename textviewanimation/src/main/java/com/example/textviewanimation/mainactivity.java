package com.example.textviewanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

/**
 * Created by praveen on 21/8/16.
 */
public class mainactivity extends AppCompatActivity implements View.OnClickListener {
    TextView anim_text =null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anim_text = (TextView) findViewById(R.id.anim_text);
        anim_text.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, 0.80f,
                Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, 0);
        anim_text.setText(anim_text.getText());
        animation.setDuration(1000);
        animation.setFillEnabled(true);
        animation.setFillAfter(true);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                anim_text.setText("over");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        anim_text.startAnimation(animation);

        //Animation translatebu= AnimationUtils.loadAnimation(this, R.anim.animationfile);
        //anim_text.setText(anim_text.getText());
        //anim_text.startAnimation(translatebu);
        //anim_text.setText(anim_text.getText());
        //anim_text.setAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left));
    }
}
