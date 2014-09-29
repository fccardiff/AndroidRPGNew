package com.example.AndroidRPGNew;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

public class MusicInitiator extends Activity {
 //   public static int musicVolume;
 //   public static int sfxVolume;
 //   public static MediaPlayer SFXmediaPlayer;
 //   public static MediaPlayer musicMediaPlayer;
 //   public AudioManager audioManager;
 //   private final static int MAX_VOLUME = 100;
 //   public void onCreate(Bundle savedInstanceState) {
 //       setContentView(R.layout.menu);
 //       audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
 //       final int initVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
 //       final int maxVolume  = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
 //       super.onCreate(savedInstanceState);
 //       musicVolume = getSharedPreferences(Main.PREFS_NAME, 0).getInt("musicSeekAmt", 30);
 //       sfxVolume = getSharedPreferences(Main.PREFS_NAME, 0).getInt("SFXseekAmt", 30);
 //       float musicVolumeFloat = (float) (1 - (Math.log(100 - musicVolume) / Math.log(100)));
 //       float SFXVolumeFloat = (float) (1 - (Math.log(100 - sfxVolume) / Math.log(100)));
 //       musicMediaPlayer.setVolume(musicVolumeFloat, musicVolumeFloat);
 //       SFXmediaPlayer.setVolume(SFXVolumeFloat, SFXVolumeFloat);
 //       setVolumeControlStream(AudioManager.STREAM_MUSIC);
 //       audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
 //       audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,maxVolume, 0);
 //       Intent startMainMenu = new Intent(this, Main.class);
 //       startActivity(startMainMenu);
 //   }
}