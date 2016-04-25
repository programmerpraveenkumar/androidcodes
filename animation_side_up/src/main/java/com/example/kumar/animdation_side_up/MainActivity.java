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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button make_animation;
    Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        make_animation = (Button) findViewById(R.id.make_animation);
        make_animation.setOnClickListener(this);
        close = (Button) findViewById(R.id.close);
        close.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        //v.setClickable(false);

        LinearLayout layout = (LinearLayout) findViewById(R.id.anim_layout);
        Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        Animation slideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        if (v.getId() == R.id.make_animation) {
            Toast.makeText(this, "visible", Toast.LENGTH_SHORT).show();

            layout.startAnimation(slideUp);
            layout.setVisibility(View.VISIBLE);
            make_animation.setVisibility(View.INVISIBLE);
        } else if (v.getId() == R.id.close) {
            {
                Toast.makeText(this, "In visible", Toast.LENGTH_SHORT).show();
                layout.startAnimation(slideDown);
                layout.setVisibility(View.INVISIBLE);
                make_animation.setVisibility(View.VISIBLE);
            }
            //v.setClickable(true);
        }
    }
}
