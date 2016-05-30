package programmerpraveenkumar.com.create_folder_in_m;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Prompt Android 6 user if permission is not yet granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 123);
        } else {
           createDir();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 123:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    createDir();
                } else {

                }
        }
    }

    public void createDir(){

        File myDirectory = new File(Environment.getExternalStorageDirectory(), "shiva");
        if(!myDirectory.exists()) {
            myDirectory.mkdirs();
            this.Log("created "+myDirectory.getAbsolutePath());

        }else{
            this.Log("exists "+myDirectory.getAbsolutePath());
        }
    }
    private void Log(String m){
        Log.i("praveen",""+m);
        Toast.makeText(this,  " "+m, Toast.LENGTH_LONG).show();
    }
    private void toast(String m){

    }

}
