package com.ahdollars.crazyeights.volumebroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.Toast;

public class MyVolumeReceiver extends BroadcastReceiver {
    public MyVolumeReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("my.custom.volume")){
           // Toast.makeText(context,"High Volume",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(context,SecondActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           // context.startActivity(i);
            Toast mytoast=new Toast(context);
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mytoast.setView(inflater.inflate(R.layout.custom_toast,null,false));
            mytoast.setDuration(Toast.LENGTH_SHORT);
            mytoast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL,0,0);
            mytoast.show();
        }
    }
}
