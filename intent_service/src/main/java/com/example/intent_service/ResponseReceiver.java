package com.example.intent_service;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
/**
 * Created by gitpl-des-078 on 03-06-2016.
 */
public class ResponseReceiver extends ResultReceiver {
    //public static final String ACTION_RESP = "praveen.action.MESSAGE_PROCESSED";
    public static final String ACTION_RESP = "praveen.kumar";
    private Receiver mReceiver;
    public ResponseReceiver(Handler handler) {
        super(handler);
    }
    public void setReceiver(Receiver receiver) {
        mReceiver = receiver;
    }
    public interface Receiver {
        public void onReceiveResult(int resultCode, Bundle resultData);
    }
    //    @Override
//    public void onReceive(Context context, Intent intent) {
//            //TextView result = (TextView) findViewById(R.id.textview);
//            String text = intent.getStringExtra(SimpleIntentService.PARAM_OUT_MSG);
//            Log.i("praveen","received "+text);
//            setProgressBarIndeterminateVisibility(true);
//            //result.setText(text);
//            }
//    }
@Override
protected void onReceiveResult(int resultCode, Bundle resultData) {
    if (mReceiver != null) {
        mReceiver.onReceiveResult(resultCode, resultData);
    }
}
}
