package com.praveen.com.download_from_internet;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pd = new ProgressDialog(this);
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
    public void start_servc(View v){
        switch (v.getId()){
            case R.id.start1:
                st("first");
                pd.setMessage("Progress is goin...");
                pd.setProgress(50);
                pd.setMax(100);
                pd.show();
            break;
            case R.id.start2:
                if(!pd.isShowing()){
                    pd.show();
                }
                st("second");
            break;
            case R.id.check:

            break;
        }
    }
    private void st(String t){
        Intent in_s = new Intent(this,in_srvc.class);
        in_s.putExtra("type",t);
        this.startService(in_s);
    }
}
