package programmerpraveenkumar.com.call_internet_internet_available;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by kumar on 5/6/16.
 */
public class service extends Service{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
   public void checkConnection(){
        try{

//            if (!intent.getAction().equals(WifiManager.NETWORK_STATE_CHANGED_ACTION) &&
//                    !intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION) &&
//                    !intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
//                return;
//
//            }
            ConnectivityManager cm = ((ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE));
            if (cm == null) {
                Toast.makeText(this, "No internet", Toast.LENGTH_SHORT).show();
                return;

            }else if(cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected()) {
                // Start the service to do our thing
                //Intent pushIntent = new Intent(context, ContentCheckService.class);
                //context.startService(pushIntent);
                Toast.makeText(this, "Praveen Connected!!!", Toast.LENGTH_SHORT).show();


            }else{
                Toast.makeText(this, "Praveen Not Connected!!!", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "Error in broadcast receivev "+e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.d("praveen",""+e.getMessage());
        }

    }
}
