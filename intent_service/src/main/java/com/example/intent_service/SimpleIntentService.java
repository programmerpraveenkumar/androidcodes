package com.example.intent_service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.text.format.DateFormat;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class SimpleIntentService extends IntentService {
    public static final String PARAM_IN_MSG = "imsg";
    public static final String PARAM_OUT_MSG = "omsg";

    public SimpleIntentService() {
        super("SimpleIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        final ResultReceiver receiver = intent.getParcelableExtra("receiver");
        //String msg = intent.getStringExtra(PARAM_IN_MSG);
        String msg = "";
        SystemClock.sleep(30000); // 30 seconds
        String resultTxt = msg+ " Praveen KUmar "+ DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());
        Bundle bundle = new Bundle();
        bundle.putString("val",resultTxt);
        receiver.send(1,bundle);
//        Intent broadcastIntent = new Intent();
//        broadcastIntent.setAction(ResponseReceiver.ACTION_RESP);
//        broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
//        broadcastIntent.putExtra(PARAM_OUT_MSG, resultTxt);
//        sendBroadcast(broadcastIntent);
    }
}

