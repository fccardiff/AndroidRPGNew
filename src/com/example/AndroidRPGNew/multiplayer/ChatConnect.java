package com.example.AndroidRPGNew.multiplayer;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by fccardiff on 9/18/14.
 */
public class ChatConnect implements Runnable,Serializable {
    // Ability to send message via chatMessageSend - Sends chat message data from chatMessage text field
    // Once connected, log to chat. Allow for multicolors, etc.
    private Socket socket;
    //public static SharedPreferences getSharedPreferences(Context context){
    //    return context.getSharedPreferences(Main.PREFS_NAME, 0);
    //}
    public ChatConnect(Socket s){
        socket = s;
    }
    public void run(){
        try{
            final Scanner in = new Scanner(socket.getInputStream());
            final PrintWriter out = new PrintWriter(socket.getOutputStream());
            final String userId = ServerConnect.userId;
            final Button sendMessage = ServerConnect.b;
            final DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            sendMessage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // while(true) {
                        TextView input = ServerConnect.text;
                        String inputMsg = input.getText().toString();
                        TextView chatLog = ServerConnect.chatLog;
                        input.setText("");
                        out.println(userId + ": " + inputMsg);
                        out.flush();
                        try {
                            // Send userId
                            dataOutputStream.writeByte(1);
                            dataOutputStream.writeUTF(userId);
                            dataOutputStream.flush();
                            // TODO: HASHED? SEND PASSWORD
                            // TODO: Get server to check user group and check message color
                            // Send inputMsg
                            dataOutputStream.writeByte(2);
                            dataOutputStream.writeUTF(inputMsg);
                            dataOutputStream.flush();
                        }
                        catch(IOException e){
                            e.printStackTrace();
                        }
                        // Use DataOutputStream to write byte to server, then write userId, etc.
                        input.setText("");
                        if (in.hasNext()) { // If server sent us a message...
                            String newInput = in.nextLine();
                            chatLog.append("\n" + newInput);
                           // out.println(newInput);
                           // out.flush();
                           // input.setText("");
                            run();
                        }
                    }
                //}
            });
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
