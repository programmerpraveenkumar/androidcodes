package addresspager.com.serverconnection;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new server().execute("");
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
class server extends AsyncTask<String ,String ,String > {
    String result;
    @Override
    protected void onPreExecute() {
        //this.library().log("on pre execute");
        super.onPreExecute();

    }
    public void log(String m){
        Log.i("logger","response of the server "+m);
    }

    @Override
    protected String doInBackground(String... te) {
        HttpClient client=new DefaultHttpClient();
        HttpPost post=new HttpPost("http://10.0.2.2/ksource/index.php");
        List<NameValuePair> valobj=new ArrayList<NameValuePair>(2);
        valobj.add(new BasicNameValuePair("email","sriram@gmail.com"));
        valobj.add(new BasicNameValuePair("user","praveen.com"));
        try{
      //      this.library().log("backend server connection staarted");
            post.setEntity(new UrlEncodedFormEntity(valobj));
            HttpResponse ree = client.execute(post);
            String t = EntityUtils.toString(ree.getEntity());
            this.result = t;
        //    this.library().log("backend server connection ok..");
        }
        catch(UnsupportedEncodingException e){
            this.result = "encoding exception";
            //e.printStackTrace();
        }
        catch(ClientProtocolException e){
            this.result = "protocal exception";
            //e.printStackTrace();
        }
        catch(IOException e){
            this.result = "IO exception";
            //e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    //    this.library().log("onpost execute");
  //      this.getServerResult.serverResult(this.result);
    }

}