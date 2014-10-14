package com.example.AndroidRPGNew.multiplayer;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.AndroidRPGNew.Main;
import com.example.AndroidRPGNew.R;

import java.io.IOException;
import java.lang.String;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MultiplayerMenu extends Activity {
    public static String IP;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        final SharedPreferences settings = getSharedPreferences(Main.PREFS_NAME, 0);
        final String login = settings.getString("userId", null);
        if(login != null){
            setContentView(R.layout.multiplayermenu);
            // load server list via SQL, and then onClick start a game connecting to server
            // Here, connect to sql database, find servers and all IPs, test all IPs to see if they connect
            // Find pings, etc, current players, and then update server list and show it in the table
            final ListView serverListView = (ListView) findViewById(R.id.serverList);
            ArrayList<String> servers = getAvailableIPs();
            ArrayAdapter<String> serverAdapter = new ArrayAdapter<String>(this, R.layout.serverlistview, servers);
            serverListView.setAdapter(serverAdapter);
            serverListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String IP = serverListView.getItemAtPosition(position).toString();
                    Log.w("IP is:", IP);
                    setIP(IP);
                    Intent startServerConnect = new Intent(view.getContext(), ServerConnect.class);
                    startActivity(startServerConnect);
                }
            });
            final Button serverListBack = (Button) findViewById(R.id.serverListBack);
            serverListBack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent backToMenu = new Intent(v.getContext(), Main.class);
                    startActivity(backToMenu);
                }
            });
        }
        else {
            Intent startAccountSetup = new Intent(this.getApplicationContext(), AccountSetup.class);
            startActivity(startAccountSetup);
        }
    }

    public ArrayList<String> getAvailableIPs(){
        // Lists all available IPs. Find via SQL or some sort of database.
        ArrayList<String> IPList = new ArrayList<String>();
        IPList.add("192.168.2.3");
        return IPList;
    }
    public static String getIP(){
        return IP; // Returns the IP choice the user made.
    }
    public void setIP(String newIP){
        // Set the IP from the choice user made from the list
        IP = newIP;
    }
}