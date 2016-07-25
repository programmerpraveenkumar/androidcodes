package programmerpraveenkumar.com.multiple_downloads;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Integer> d_list = new ArrayList<>();
    HashMap<Integer,Thread> thread_list = new HashMap<Integer, Thread>();
    Handler hand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);
        Button btn3 = (Button)findViewById(R.id.btn3);
        Button btn4 = (Button)findViewById(R.id.btn4);
        Button btn5 = (Button)findViewById(R.id.btn5);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        Button total_dowlaod = (Button)findViewById(R.id.total_dowlaod);
        total_dowlaod.setOnClickListener(this);
        hand = new Handler(){
            @Override
            public void handleMessage(Message message) {
                int id = message.getData().getInt("test");
                Button btn = (Button) findViewById(id);
                int tag_id = Integer.parseInt(btn.getTag().toString());
                btn.setText("compelted!!!");
                d_list.remove(new Integer(tag_id));
                thread_list.remove(tag_id);
                //return super.getMessageName(message);

            }
        };
    }


    @Override
    public void onClick(View view) {
        try{
            Button btn = (Button) view;
            if(view.getId()==R.id.total_dowlaod){
                        this.l("total_download in the queues are (thread)"+thread_list.size()+" list "+d_list.size());
            }else{
                int id = Integer.parseInt(view.getTag().toString());
                if(d_list.contains(id)){
                    d_list.remove(new Integer(id));
                    thread_list.get(id).interrupt();
                    thread_list.remove(id);
                    btn.setText("Start Download");
                    this.l("thread queues are "+thread_list.size()+" list queues are "+d_list.size());
                }else{
                    d_list.add(id);
                    btn.setText("Downloading...");
                    downloadLoop(1500,view.getId());
                }
            }

        }catch (Exception e){
            this.l(""+e.getMessage());
        }


    }
    private void l(String m){
        Log.i("praveen",m);
        Toast.makeText(this,""+m,Toast.LENGTH_SHORT).show();
    }

    private void downloadLoop(final int time, final int id){
        final Message msg = new Message();
        final Bundle tmp = new Bundle();
        thread_list.put(id,new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finishDownload(id);
                tmp.putInt("test",id);
                msg.setData(tmp);
                hand.sendMessage(msg);
            }
        }));
        thread_list.get(id).start();

    }
    private void finishDownload(int id){
//        Button btn = (Button) v;
//        btn.setText("COmpelted!!!!");
        d_list.remove(new Integer(id));
        this.l("last downlaod is "+id+" total_download in the queues are "+d_list.size());
    }
}
