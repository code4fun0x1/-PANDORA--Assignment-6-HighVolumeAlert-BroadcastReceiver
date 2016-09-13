package com.ahdollars.crazyeights.volumebroadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {



    public static final String TAG="Voila";
    IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        startService(new Intent(MainActivity.this,VolumeListenerService.class));
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Registered");


    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}
