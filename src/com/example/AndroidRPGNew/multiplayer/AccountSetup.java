package com.example.AndroidRPGNew.multiplayer;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.AndroidRPGNew.Main;
import com.example.AndroidRPGNew.R;

public class AccountSetup extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        final SharedPreferences settings = getSharedPreferences(Main.PREFS_NAME, 0);
        final SharedPreferences.Editor editor = settings.edit();
        setContentView(R.layout.accountsetup);
        //TODO: TEMPORARY! Use encryption to store passwords.
        // TODO: See http://stackoverflow.com/questions/1132567/encrypt-password-in-configuration-files-java
        // TODO: Make "Account Created Successfully!" Notification
        // TODO: Connect to server, send account creation request, and save user and encrypted password to server
        // TODO: to doublecheck
        Button createAccount = (Button) findViewById(R.id.createAccount);
        createAccount.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView username = (TextView) findViewById(R.id.username);
                TextView password = (TextView) findViewById(R.id.password);
                String user = username.getText().toString(); // Before connecting, check if user is available and if pass is secure enough
                String pass = password.getText().toString(); // then create account and save username to sharedpreferences, and save password (securely)
                editor.putString("userId", user).commit();
                editor.putString("userPass", pass).commit();
                Intent startMultiplayer = new Intent(v.getContext(), MultiplayerMenu.class);
                startActivity(startMultiplayer);
            }
        });
        Button backToMenu = (Button) findViewById(R.id.backToMenu);
        backToMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.menu);
            }
        });
    }

}