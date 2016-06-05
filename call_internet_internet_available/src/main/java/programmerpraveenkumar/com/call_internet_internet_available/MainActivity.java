package programmerpraveenkumar.com.call_internet_internet_available;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_view = (TextView) findViewById(R.id.text_view);



        //this.registerReceiver(tmprecv,new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        text_view.setText("enalbled Ready statrt");
        //tmprecv.
//        try{
//            ComponentName component = new ComponentName(this, ConnectivityChangeReceiver.class);
//            int status = this.getPackageManager().getComponentEnabledSetting(component);
//            if(status == PackageManager.COMPONENT_ENABLED_STATE_ENABLED){
//                to("enabled");
//                text_view.setText("enalbled");
//            }else if(status == PackageManager.COMPONENT_ENABLED_STATE_DISABLED){
//                to("Disabled");
//                text_view.setText("disabled");
//            }else{
//                text_view.setText("else unknown status ");
//                to("else unknown status "+status);
//            }
//        }catch (Exception e){
//            to("unknown status ");
//            text_view.setText("unknown status "+e.getMessage());
//        }


        //registerReceiver(new ConnectivityChangeReceiver(),new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
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
    public void to(String m){
        Toast.makeText(this,"Eror "+m,Toast.LENGTH_LONG).show();

    }
}

