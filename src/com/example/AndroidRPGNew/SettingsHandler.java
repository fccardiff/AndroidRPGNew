package com.example.AndroidRPGNew;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by fccardiff on 9/13/14.
 */
public class SettingsHandler extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SharedPreferences settings = getSharedPreferences(Main.PREFS_NAME, 0);
        final SharedPreferences.Editor editor = settings.edit();
        setContentView(R.layout.settings);
        String currentSeekValueString = settings.getString("SFXseekString", null);
        int newSeekValue = settings.getInt("SFXseekAmt", 30);
        if (currentSeekValueString != String.valueOf(newSeekValue)) {
            final TextView seekAmtString = (TextView) findViewById(R.id.SFXAmt);
            String newSeekValueString = String.valueOf(newSeekValue);
            CharSequence charSequence = newSeekValueString;
            seekAmtString.setText(charSequence);
        }
        String musicSeekAmtString = settings.getString("musicSeekAmtString", null);
        int newMusicSeekAmt = settings.getInt("musicSeekAmt", 30);
        if (musicSeekAmtString != String.valueOf(newMusicSeekAmt)) {
            final TextView musicSeekAmtText = (TextView) findViewById(R.id.MusicAmt);
            String newMusicSeekAmtString = String.valueOf(newMusicSeekAmt);
            CharSequence musicCharSequence = newMusicSeekAmtString;
            musicSeekAmtText.setText(musicCharSequence);
        }
        final SeekBar SFXseek = (SeekBar) findViewById(R.id.SFXseek);
        int seekAmt2 = settings.getInt("SFXseekAmt", 0);
        if (seekAmt2 == 0) {
            editor.putInt("SFXseekAmt", 30).commit();
        }
        SFXseek.setProgress(settings.getInt("SFXseekAmt", 30));
        final Button settingsOK = (Button)findViewById(R.id.SettingsOK);
        settingsOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        SFXseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editor.putInt("SFXseekAmt", progress).commit();
                editor.putString("SFXseekString", String.valueOf(progress)).commit();
                int newSeekValue = settings.getInt("SFXseekAmt", 30);
                final TextView seekAmtString = (TextView) findViewById(R.id.SFXAmt);
                String newSeekValueString = String.valueOf(newSeekValue);
                CharSequence charSequence = newSeekValueString;
                seekAmtString.setText(charSequence);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
        });
        final SeekBar musicSeek = (SeekBar) findViewById(R.id.musicSeek);
        int musicSeekAmt = settings.getInt("musicSeekAmt", 0);
        if (musicSeekAmt == 0) {
            editor.putInt("musicSeekAmt", 30).commit();
        }
        musicSeek.setProgress(settings.getInt("musicSeekAmt", 30));
        musicSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editor.putInt("musicSeekAmt", progress).commit();
                editor.putString("musicSeekAmtString", String.valueOf(progress)).commit();
                int newMusicSeekValue = settings.getInt("musicSeekAmt", 30);
                final TextView musicSeekAmtTextViewNew = (TextView) findViewById(R.id.MusicAmt);
                String newMusicSeekValueString = String.valueOf(newMusicSeekValue);
                CharSequence musicCharSequenceNew = newMusicSeekValueString;
                musicSeekAmtTextViewNew.setText(musicCharSequenceNew);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
