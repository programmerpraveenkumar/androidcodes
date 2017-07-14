package com.example.bluetoothraspery;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;
    ListView lv;
    ArrayList list = null;
    TextView error_tv = null;
    private OutputStream outputStream;
    private InputStream inStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BA = BluetoothAdapter.getDefaultAdapter();
        lv = (ListView)findViewById(R.id.listview);
        list = new ArrayList();
        lv.setOnItemClickListener(this);
        error_tv = (TextView) findViewById(R.id.error);
        if(BA != null){
            if(!BA.isEnabled()){
                toast("Bluetooth is not enabled..Please enable Bluetooth and restart app.","");
            }else{
                list_devices();
            }
        }else{
            toast("Bluetooth is not enabled..Please enable Bluetooth and restart app..","");
        }

    }

    public void list_devices(){
        pairedDevices = BA.getBondedDevices();

        for(BluetoothDevice bt : pairedDevices)
            list.add(bt.getName());
        if(list.size() == 0){
            this.toast("No device Found..","");
        }else {
            ArrayAdapter adapter = new  ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
            lv.setAdapter(adapter);
        }


    }

    void toast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    void toast(String message,String showText){
        error_tv.setText(message);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //int pos;
        try{
            toast("conneting ...device name is "+list.get(i));
            BluetoothDevice device = (BluetoothDevice) list.get(i);
            ParcelUuid[] uuids = device.getUuids();
            BluetoothSocket socket = device.createRfcommSocketToServiceRecord(uuids[0].getUuid());
            socket.connect();
            outputStream = socket.getOutputStream();
            inStream = socket.getInputStream();
        }catch (Exception e){
                toast("Error "+e.getMessage(),"");
        }

    }
}
