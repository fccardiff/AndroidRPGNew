package com.example.AndroidRPGNew.multiplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by fccardiff on 10/14/14.
 */
public class AccountVerify extends Activity implements Runnable,Serializable{
    private Socket socket;
    private String username;
    private String password;
    protected Context context;
    public AccountVerify(Socket s, String user, String pass){
        socket = s;
        username = user;
        password = pass;
    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        run();
    }
    public void run(){
        try{
            final DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            final Scanner in = new Scanner(socket.getInputStream());
            dataOutputStream.writeByte(80);
            dataOutputStream.writeUTF("verify");
            dataOutputStream.flush();
            dataOutputStream.writeByte(81);
            dataOutputStream.writeUTF(username);
            dataOutputStream.flush();
            dataOutputStream.writeByte(82);
            dataOutputStream.writeUTF(password);
            dataOutputStream.flush();
            if(in.hasNext()){
                String canCreate = in.nextLine();
                boolean available = Boolean.parseBoolean(canCreate);
                if(available == false){
                    userNotAvailable();
                }
                else if(available == true){
                    try{
                        Toast.makeText(context, "Successfully created user!", Toast.LENGTH_SHORT).show();
                        Intent startMultiplayer = new Intent(getApplicationContext(), MultiplayerMenu.class);
                        startActivity(startMultiplayer);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    // TODO Send encountered error, is client connected to internet?
                    Toast.makeText(context, "Cannot create user! Is client connected to the internet?", Toast.LENGTH_SHORT).show();
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void userNotAvailable(){
        Toast.makeText(context, "Username not available! Please try a different username!", Toast.LENGTH_SHORT).show();
    }
}
