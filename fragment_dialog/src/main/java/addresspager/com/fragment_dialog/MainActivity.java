package addresspager.com.fragment_dialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,login_details.onSubmitListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button open_dialog = (Button) findViewById(R.id.open_dialog);
        open_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_details l = new login_details();
                l.show(getFragmentManager(),"dialog");
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.save){
            //Dialog dialogView = D

//            EditText username = (EditText) dialogView.findViewById(R.id.username);
            //Log.i("programmerpraveen","user details are "+username.getText()+" "+lastname.getText());
            Log.i("programmerpraveen","user details are ");
        }
    }

    @Override
    public void setOnSubmitListener(View v) {
        if(v !=null){
            EditText username = (EditText) v.findViewById(R.id.username);
            EditText last_name = (EditText) v.findViewById(R.id.lastname);
            Log.i("programmerpraveen","user details are superb "+username.getText()+" -- "+last_name.getText());
        }

    }
}
