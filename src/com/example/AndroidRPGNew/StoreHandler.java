package com.example.AndroidRPGNew;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StoreHandler extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store);
        Button purchaseRemoveAds = (Button) findViewById(R.id.purchaseRemoveAds);
        purchaseRemoveAds.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                // Purchase remove ads
            }
        });
        // StoreToMenu button
        final Button storeToMenu = (Button) findViewById(R.id.storeToMenu); //Button in menu to store
        storeToMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}