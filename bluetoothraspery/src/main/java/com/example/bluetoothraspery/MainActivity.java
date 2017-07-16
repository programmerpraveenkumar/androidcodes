package com.example.bluetoothraspery;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;
    ListView lv;
    ArrayList list = null;
    TextView error_tv = null;
    BluetoothDevice btDdevice = null;
    BluetoothSocket socket = null;
    public static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        try{
//            Calendar today = Calendar.getInstance();
//            Calendar expiry_dt = Calendar.getInstance();
//            expiry_dt.set(2017,06,17);//06 for july
//            if(expiry_dt.before(today)){
//                this.toast("App Error..","");
//                return;
//            }
//            Log.i("praveen","date aavlaue "+expiry_dt.before(today));
//            //Log.i("praveen","date aavlaue "+expiry_dt.equals(today));
////            if(dateEnd.compareTo(dateStart)){
////
////            }
//        }catch (Exception e){
//            Log.i("praveen","date Error "+e.getMessage());
//        }



        BA = BluetoothAdapter.getDefaultAdapter();
        lv = (ListView)findViewById(R.id.listview);
        list = new ArrayList();
        lv.setOnItemClickListener(this);
        error_tv = (TextView) findViewById(R.id.error);
        if(BA != null){
            if(!BA.isEnabled()){
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
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
        //error_tv.setText(message);
        Log.i("praveen_blue",message);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
        //int pos;
                    for(BluetoothDevice bt : pairedDevices){
                        if (bt.getName().equalsIgnoreCase(list.get(i).toString())) {
                            btDdevice = bt;
                            //return;
                        }
                    }
                    if(btDdevice == null){
                        toast("No device found with the name "+list.get(i));
                        return;
                    }
                    //BA.cancelDiscovery();
//                    Thread th = new Thread(){
//                        @Override
//                        public void run() {



                            try{
                                ParcelUuid[] uuids = btDdevice.getUuids();
//                                toast(""+uuids.length,"");
//                                //MY_UUID = uuids[0].getUuid();
//                                toast(""+uuids[0].getUuid()+" "+MY_UUID+" -- ","");
                                socket = btDdevice.createRfcommSocketToServiceRecord(uuids[1].getUuid());

                            }catch (Exception e){
                                toast("Error Bluetooth connection! trying fallback for "+btDdevice.getName()+e.getMessage(),"");
                                try {
//                                    Method m = btDdevice.getClass().getMethod("createRfcommSocketToServiceRecord", new Class[] { int.class });
//                                    socket = (BluetoothSocket) m.invoke(btDdevice, 1);
                                    socket = btDdevice.createInsecureRfcommSocketToServiceRecord(MY_UUID);

                                } catch (Exception ee) {
                                    //socket.close();
                                    toast("Error fallback! "+e.getMessage(),"");
                                }
                            }
                    Thread th = new Thread(){
                        @Override
                        public void run(){
                            BA.cancelDiscovery();
                            try{
                                socket.connect();

                            }catch (IOException e){
                                toast("unable to close() socket during connection failure"+e.getMessage(),"");
                                try {
                                    socket.close();

                                } catch (IOException e2) {
                                    toast("unable to close() socket during connection failure"+e2.getMessage(),"");
                                }
                            }

                        }
                    };
                    th.start();



//            try {
//                socket.connect();
//            }catch (Exception e){
//                try {

//                    this.toast("trying fallback...");
//
//                    socket =(BluetoothSocket) btDdevice.getClass().getMethod("createRfcommSocket", new Class[] {int.class}).invoke(btDdevice,2);
//                    socket.connect();
//
//                    //Log.e("","Connected");
//                }
//                catch (Exception e2) {
//                    this.toast("Couldn't establish Bluetooth connection!","");
//                }



    }


    public void sendData(View v){
        if(socket !=null) {
            String data = ((EditText)(findViewById(R.id.data_send))).getText().toString();
            if(data.equals("")){
                toast("Please enter data to send");
                return;
            }
            String err_Mesage = new connectAndSendThread(socket, this,data).toString();
            toast("Status " + err_Mesage, "");
        }else{
            toast("No Socket connection!!! ", "");
        }
    }

}

class connectAndSendThread extends  Thread{
    private final BluetoothSocket bSocket;
    private OutputStream outputStream = null;
    private String error_message;
    Context c;
    //private InputStream inStream;
    connectAndSendThread(BluetoothSocket bSocket, Context c,String data){
        this.bSocket = bSocket;
        this.c = c;
        try{
            Toast.makeText(this.c,"Stream started!!!",Toast.LENGTH_SHORT).show();
            outputStream = this.bSocket.getOutputStream();
            outputStream.write(data.getBytes());
            error_message = "Data value "+data+" Sent success!!!"+this.bSocket.getRemoteDevice().getName();
            Toast.makeText(this.c,error_message,Toast.LENGTH_SHORT).show();
            //this.bSocket.close();
            //this.outputStream.close();
        }catch (Exception e){
            Toast.makeText(this.c,"Error "+e.getMessage(),Toast.LENGTH_SHORT).show();
            error_message = "Error "+e.getMessage();
        }



    }
    @Override
    public String toString(){
        return this.error_message;
    }
}
