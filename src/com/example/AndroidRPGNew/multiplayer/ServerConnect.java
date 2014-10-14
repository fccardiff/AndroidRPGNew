package com.example.AndroidRPGNew.multiplayer;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import com.example.AndroidRPGNew.Main;
import com.example.AndroidRPGNew.R;
import java.net.Socket;

/**
 * Created by fccardiff on 9/18/14.
 */
public class ServerConnect extends Activity {
    // Establish connection to server, with IP from MultiplayerMenu
    // Initiate ChatConnect
    // TODO: Establish SharedPreferences correctly!
    //SharedPreferences settings = getSharedPreferences(Main.PREFS_NAME, 0);
    //final String userId = settings.getString("userId", "unknown");
    static Button b = null;
    static String userId = null;
    static TextView text = null;
    static TextView chatLog = null;
    static SharedPreferences s;
    static String password = null;
    static Socket socket;
    public static Context context;
    //String newUserId = null;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        context = this;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.game);
        s = getSharedPreferences(Main.PREFS_NAME, 0);
        userId = s.getString("userId", "unknown");
        if(userId == ""){
            userId = "unknown";
        }
        password = s.getString("password", "");
        if(password == ""){
            password = "unknown";
        }
        b = (Button) findViewById(R.id.chatMessageSend);
        text = (TextView) findViewById(R.id.chatMessage);
        chatLog = (TextView) findViewById(R.id.chatView);
        Log.w("Buttons", "declared");
        // TODO: KEEP THE ABOVE TWO LINES ONLY TEMPORARILY - FIND A FIX!
        connect();
    }
    public static void connect() {
        final int port = 2525;
        final String IP = MultiplayerMenu.getIP();
        try {
            Log.w("attempting socket connection", "...");
            socket = new Socket(IP, port);
            Log.w("Server:", "Connected to " + IP + ":" + port);
            ChatConnect client = new ChatConnect(socket);
            Thread thread = new Thread(client);
            thread.start();

        } catch (Exception serverNotFound) {
            serverNotFound.printStackTrace();
        }
    }
}
