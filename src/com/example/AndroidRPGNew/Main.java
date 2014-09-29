package com.example.AndroidRPGNew;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import com.example.AndroidRPGNew.multiplayer.MultiplayerMenu;

public class Main extends Activity {
    /**
     * Called when the activity is first created.
     */
    // TODO: Work on game.xml, add in app purchases to StoreHandler
    // TODO: Work on adding users to database, AccountSetup + accountsetup.xml
    // TODO: Establish SQL Database connection with SQLConnection
    // TODO: List multiplayer servers with MultiplayerMenu.java (Table?)
    // TODO: Figure out custom buttons - ImageButton or change button look?
    // TODO: Loading bar (custom), Pixel Art, ideas, character skins, items, ui, etc.
    // TODO: Consider in-app purchases. None, specific items? Etc.
    // TODO: Implement server connections and setup test server. Add chat functionality first.
    // TODO: Optionally, join server by IP
    // Quests
    // Trading
    // Campaign
    // Multiplayer
    // Leveling System
    // Upgrades
    public static final String PREFS_NAME = "baseSettings";
  //  @Override
  //  protected void onStop() {
  //      super.onStop();
        //MusicInitiator.audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, MusicInitiator.initVolume, 0);
    //    MusicInitiator.musicMediaPlayer.stop();
    //    MusicInitiator.SFXmediaPlayer.stop();
   // }
   // @Override
   // protected void onDestroy(){
     //   super.onDestroy();
        //MusicInitiator.audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, MusicInitiator.initVolume, 0);
    //    MusicInitiator.musicMediaPlayer.stop();
    //    MusicInitiator.SFXmediaPlayer.stop();
    //}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        boolean disclaimerCompletion = settings.getBoolean("disclaimerCompletion", false);
        if (disclaimerCompletion == true) {
          //  Intent startMusicInitiatior = new Intent(this, MusicInitiator.class);
          //  startActivity(startMusicInitiatior);
            // Start Loading Screen
            setContentView(R.layout.menu);
            final Button menuSettings = (Button) findViewById(R.id.menuSettings); //Button in menu to settings
            menuSettings.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent startSettings = new Intent(v.getContext(), SettingsHandler.class);
                    startActivity(startSettings);
                }
            });
            final Button menuStore = (Button) findViewById(R.id.menuStore); //Button in menu to store
            menuStore.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent startStore = new Intent(v.getContext(), StoreHandler.class);
                    startActivity(startStore);
                }
            });
            final Button menuMultiplayer = (Button) findViewById(R.id.menuMultiplayer);
            menuMultiplayer.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent startMultiplayer = new Intent(v.getContext(), MultiplayerMenu.class);
                    startActivity(startMultiplayer);
                }
            });
        } else {
            setContentView(R.layout.main);
            final Button button = (Button) findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, 0).edit();
                    editor.putBoolean("disclaimerCompletion", true).commit();
                    Intent startMenu = new Intent(v.getContext(), Main.class);
                    startActivity(startMenu);
                }
            });
        }
    }
}