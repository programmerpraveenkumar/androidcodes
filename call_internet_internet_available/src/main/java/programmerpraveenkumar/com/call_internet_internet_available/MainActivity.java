package programmerpraveenkumar.com.call_internet_internet_available;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    TextView text_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_view = (TextView) findViewById(R.id.text_view);
        String uniqueID = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        text_view.setText("uniqid is "+uniqueID);
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

    public void unregisterreceiver(View v){
        PackageManager pm = getPackageManager();
        ComponentName name = new ComponentName(getApplicationContext(),ConnectivityChangeReceiver.class);
        pm.setComponentEnabledSetting(name,PackageManager.COMPONENT_ENABLED_STATE_DISABLED,PackageManager.DONT_KILL_APP);
        to("unregister.");
    }
}


class server extends AsyncTask<String ,String ,String > {
    String result;
    Context c;
    public server(Context c){
        this.c = c;
    }
    @Override
    protected void onPreExecute() {
        //this.library().log("on pre execute");
        super.onPreExecute();

    }
    public void log(String m){
        Log.i("logger","response of the server "+m);
        Toast.makeText(c,""+m,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(String... te) {
        try{
            String response = "";
            URL url = new URL("http://10.0.2.2/php/mysql_connection/index.php?id=test_from_android");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
  //          writer.write(getPostDataString(postDataParams));

            writer.flush();
            writer.close();
            os.close();
            int responseCode=conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                response = br.readLine();
                //Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
                log("server response "+response);

            }
            else {
                response="Error Registering";
            }
        }catch (Exception e){
            Log.i("praveen",e.getMessage());
        }



//        OutputStream os = conn.getOutputStream();
//        BufferedWriter writer = new BufferedWriter(
//                new OutputStreamWriter(os, "UTF-8"));
//        writer.write(getPostDataString(postDataParams));
//
//        writer.flush();
//        writer.close();
//        os.close();
//        HttpClient client=new DefaultHttpClient();
//        HttpPost post=new HttpPost("http://10.0.2.2/ksource/index.php");
//        List<NameValuePair> valobj=new ArrayList<NameValuePair>(2);
//        valobj.add(new BasicNameValuePair("email","sriram@gmail.com"));
//        valobj.add(new BasicNameValuePair("user","praveen.com"));
//        try{
//            //      this.library().log("backend server connection staarted");
//            post.setEntity(new UrlEncodedFormEntity(valobj));
//            HttpResponse ree = client.execute(post);
//            String t = EntityUtils.toString(ree.getEntity());
//            this.result = t;
//            //    this.library().log("backend server connection ok..");
//        }
//        catch(UnsupportedEncodingException e){
//            this.result = "encoding exception";
//            //e.printStackTrace();
//        }
//        catch(ClientProtocolException e){
//            this.result = "protocal exception";
//            //e.printStackTrace();
//        }
//        catch(IOException e){
//            this.result = "IO exception";
//            //e.printStackTrace();
//        }
        return null;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //    this.library().log("onpost execute");
        //      this.getServerResult.serverResult(this.result);
    }

}