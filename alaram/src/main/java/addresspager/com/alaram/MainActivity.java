package addresspager.com.alaram;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends FragmentActivity {

    alarammanger alaram ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
          alaram = new alarammanger();
        }catch (Exception e){
            this.l("error "+e.getMessage());
        }
    }

    private void l(String m){
        Log.i("praveen", m);
    }

    public void startTimer(View w){
        try{
            alaram = new alarammanger();
            if(alaram != null){
                AlarmManager am=(AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(this, alarammanger.class);
                //intent.putExtra(ONE_TIME, Boolean.FALSE);
                PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent, 0);
                //After after 5 seconds
                am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 10, pi);
               // alaram.SetAlarm(this);
            }else{
                Toast.makeText(this, "Alarm is null", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            this.l("error "+e.getMessage());
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
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
