package com.motion_sensar;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    SensorManager sm = null;
    TextView textView1 = null;
    List list;
    int width,height;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Get a SensorManager instance */
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        textView1 = (TextView) findViewById(R.id.val);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        list = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (list.size() > 0) {
            sm.registerListener(sel, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            Toast.makeText(getBaseContext(), "Error: No Accelerometer.", Toast.LENGTH_LONG).show();
        }

    }


    SensorEventListener sel = new SensorEventListener(){


        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        public void onSensorChanged(SensorEvent event) {
            try{
                Thread.sleep(20);
            }catch(InterruptedException e){

            }
            float[] values = event.values;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            int tmp_top = Math.round(values[1])* 100;
            int tmp_left = Math.round(values[0]) * 100;
            params.topMargin = (tmp_top)>height?height:tmp_top;
            params.leftMargin =  (tmp_left)>width?width:tmp_left;
            log(params.topMargin+" "+params.leftMargin);
            textView1.setText("called X "+ Math.round(values[0])+"\ny: "+ Math.round(values[1])+"\nz: "+Math.round(values[2]));
            textView1.setLayoutParams(params);
        }
    };
private void log(String m){
    Log.i("praveen",m);
}


}
