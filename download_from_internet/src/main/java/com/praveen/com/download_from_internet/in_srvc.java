package com.praveen.com.download_from_internet;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by gitpl-des-078 on 16-06-16.
 */

public class in_srvc extends IntentService {
    public in_srvc(){
        super("in_srvc");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        final String type = intent.getStringExtra("type");
        log("start "+type);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (Exception e){

                }
                log("completetd "+type);
            }
        }).start();
    }
    public void log(String m){
        Log.i("praveen",m);
    }
}
