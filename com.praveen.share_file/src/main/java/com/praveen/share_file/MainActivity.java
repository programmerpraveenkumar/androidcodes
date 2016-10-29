package com.praveen.share_file;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String action = intent.getAction();
        TextView txt_view = (TextView) findViewById(R.id.txt_view);
        if (Intent.ACTION_SEND.equals(action)) {
            if (extras.containsKey(Intent.EXTRA_STREAM)) {
                try {
                    Uri imageUri = (Uri) getIntent().getExtras().get(Intent.EXTRA_STREAM);
                    File f = new File(imageUri.getPath());
                    txt_view.setText(f.getName()+" mime type is "+MimeUtils.getType(f.getName()));
                }catch (Exception e){
                    log("Error "+e.getMessage());
                }

            }
        }
    }
    public void log(String m){
        Log.i("praveen_log",m);
    }
}
