package com.example.AndroidRPGNew;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class Main extends Activity {
    /**
     * Called when the activity is first created.
     */
    // TODO: Work on settings.xml, game.xml. Also add the features below!
    // ABILITY TO buy milk, eggs, cheese
    // Quests
    // Trading
    // Campaign
    // Multiplayer
    // Leveling System
    // Upgrades
    // IT WORKS!
    public static final String PREFS_NAME = "baseSettings";

    @Override
    protected void onStop() {
        super.onStop();
        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("disclaimerCompletion", true);
        // Commit the edits!
        editor.commit();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        boolean disclaimerCompletion = settings.getBoolean("disclaimerCompletion", false);
        if (disclaimerCompletion == true) {
            setContentView(R.layout.menu);
        } else {
            setContentView(R.layout.main);
            final Button button = (Button) findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    setContentView(R.layout.menu);
                }
            });
        }
        final Button menuSettings = (Button) findViewById(R.id.menuSettings);
        menuSettings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startSettings = new Intent(v.getContext(), SettingsHandler.class);
                startActivity(startSettings);
            }
        });
    }
}