package com.praveen.com.xmpp_connection;

import android.os.AsyncTask;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;

/**
 * Created by gitpl-des-078 on 10-06-16.
 */
public class XMPP{
    private String serverAddress;
    private XMPPConnection connection;
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
                boolean isConnected = false;

                ConnectionConfiguration config = new ConnectionConfiguration(serverAddress);
                config.setReconnectionAllowed(true);

                connection = new XMPPTCPConnection(config);

                try{
                    connection.connect();
                    isConnected = true;
                } catch (IOException e){
                } catch (SmackException e){
                } catch (XMPPException e){
                }

                return isConnected;
            }
        };
        connectionThread.execute();
    }
}
