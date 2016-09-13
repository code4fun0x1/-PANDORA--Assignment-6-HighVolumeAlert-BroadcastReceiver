package com.ahdollars.crazyeights.volumebroadcastreceiver;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.Log;

public class VolumeListenerService extends Service {

    public static final String TAG="VOLUMELISTERNER";
    public static boolean running=true;
    AudioManager manager;
    public Context context;
    boolean alerted=false;

    public VolumeListenerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context=VolumeListenerService.this;
        manager= (AudioManager) getSystemService(Context.AUDIO_SERVICE);


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        MyVolumeThread t=new MyVolumeThread();
        Thread runner=new Thread(t);
        runner.start();
        return START_STICKY;
    }

    public class MyVolumeThread implements Runnable {

        public MyVolumeThread(){
        }

        @Override
        public void run() {
            while(running){
                if(manager.getStreamVolume(AudioManager.STREAM_RING)>(manager.getStreamMaxVolume(AudioManager.STREAM_RING)/2)){
                    Log.d(TAG, "VOLUME GREATER THAN LIMIT");
                    if(!alerted){
                        sendBroadcast(new Intent("my.custom.volume"));
                        alerted=true;
                    }
                }else{
                    alerted=false;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Log.d(TAG, "CUSTOm error stopping service thread");
                }
            }
        }
    }


}
