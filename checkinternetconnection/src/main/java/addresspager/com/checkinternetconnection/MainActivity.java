package addresspager.com.checkinternetconnection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
  boolean wifi,mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        wifi=mobile=false;
        String status = " nothing";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectivityManager conn = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfo = conn.getAllNetworkInfo();
        for(NetworkInfo net :networkInfo){
            if(net.getTypeName().equalsIgnoreCase("WIFI")){
                if(net.isConnected()){
                    wifi = true;
                    status = "wifi";
                }

            }
            if(net.getTypeName().equalsIgnoreCase("MOBILE")){
                if(net.isConnected()){
                    mobile = true;
                    status = "Mobile";
                }

            }
        }
        TextView s = (TextView)findViewById(R.id.test);
        s.setText(""+status);
        //Log.i("praveen", "stauts of the network "+status);
        //return wifi || mobile;
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
}
