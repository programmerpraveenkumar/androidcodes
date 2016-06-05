package programmerpraveenkumar.com.call_internet_internet_available;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by kumar on 5/6/16.
 */
public class ConnectivityChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        try{
            Bundle extras = intent.getExtras();
            if (!intent.getAction().equals(WifiManager.NETWORK_STATE_CHANGED_ACTION) &&
                !intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION) &&
                !intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
                return;
            }

            ConnectivityManager cm = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
            if (cm == null) {
                Toast.makeText(context, "No internet", Toast.LENGTH_SHORT).show();
                return;

            }else if(cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected()) {
                // Start the service to do our thing
                //Intent pushIntent = new Intent(context, ContentCheckService.class);
                //context.startService(pushIntent);
                Log.d("praveen","Connected");
                Toast.makeText(context, "Praveen Connected!!!", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(context, "Praveen Not Connected!!!", Toast.LENGTH_SHORT).show();
                Log.d("praveen","Praveen Not Connected!!!");
            }
        }catch (Exception e){
            Toast.makeText(context, "Error in broadcast receivev "+e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.d("praveen",""+e.getMessage());
        }
    }
}
