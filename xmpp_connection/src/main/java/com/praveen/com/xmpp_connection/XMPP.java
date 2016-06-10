package com.praveen.com.xmpp_connection;

import android.os.AsyncTask;

/**
 * Created by gitpl-des-078 on 10-06-16.
 */
public class XMPP{
    private String serverAddress;
    private XMPPTCPConnection connection;
    private String loginUser;
    private String passwordUser;

    public XMPP(String serverAddress, String user, String password){
        this.serverAddress = serverAddress;
        this.loginUser = loginUser;
        this.passwordUser = passwordUser;
    }

    public void connect(){
        AsyncTask<Void, Void, Boolean> connectionThread = new AsyncTask<Void, Void, Boolean>(){
            @Override
            protected Boolean doInBackground(Void... arg0){
                return true;
            }
        };
        connectionThread.execute();
    }
}
