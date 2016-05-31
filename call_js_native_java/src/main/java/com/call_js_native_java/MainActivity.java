package com.call_js_native_java;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends FragmentActivity{
    WebView myBrowser;
    EditText Msg;
    Button btnSendMsg;
    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBrowser = (WebView)findViewById(R.id.mybrowser);

        final MyJavaScriptInterface myJavaScriptInterface
                = new MyJavaScriptInterface(this);
        myBrowser.addJavascriptInterface(myJavaScriptInterface, "AndroidFunction");

        myBrowser.getSettings().setJavaScriptEnabled(true);
        myBrowser.setWebChromeClient(new WebChromeClient());
        myBrowser.loadUrl("file:///android_asset/mypage.html");

        Msg = (EditText)findViewById(R.id.msg);
        btnSendMsg = (Button)findViewById(R.id.sendmsg);
        btnSendMsg.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String msgToSend = "praveen kumar";
                myBrowser.loadUrl("javascript:callFromActivity(\""+msgToSend+"\")");
            }});
    }

    public class MyJavaScriptInterface {
        Context mContext;

        MyJavaScriptInterface(Context c) {
            mContext = c;
        }

        public void showToast(String toast){
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

//        public void openAndroidDialog(){
//            AlertDialog.Builder myDialog
//                    = new AlertDialog.Builder(AndroidHTMLActivity.this);
//            myDialog.setTitle("DANGER!");
//            myDialog.setMessage("You can do what you want!");
//            myDialog.setPositiveButton("ON", null);
//            myDialog.show();
//        }

    }



}
