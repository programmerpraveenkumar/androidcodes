package com.example.intent_service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ResponseReceiver.Receiver  {
    private ResponseReceiver receiver;
    TextView input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setProgressBarIndeterminate(true);
        setProgress(50);
        setProgressBarVisibility(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (TextView) findViewById(R.id.textview);
    }
    public void call_service(View w){
        log("callaed start");
        setProgressBarIndeterminateVisibility(true);
        setProgressBarVisibility(true);

        String strInputMsg = input.getText().toString();
        input.setText("Loading...");
        receiver = new ResponseReceiver(new Handler());
        Intent intent = new Intent(Intent.ACTION_SYNC, null, this, SimpleIntentService.class);
        intent.putExtra("receiver", receiver);
        intent.putExtra(SimpleIntentService.PARAM_IN_MSG, strInputMsg);
        startService(intent);
        log("callaed over");
        IntentFilter filter = new IntentFilter(ResponseReceiver.ACTION_RESP);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        receiver.setReceiver(this);
        //registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    public void log(String m){
        Log.i("praveen,",m);
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        if(resultCode == 1){
            setProgressBarIndeterminateVisibility(false);
            setProgressBarVisibility(false);
            log("complete");input.setText(resultData.getString("val"));
        }
    }
}

