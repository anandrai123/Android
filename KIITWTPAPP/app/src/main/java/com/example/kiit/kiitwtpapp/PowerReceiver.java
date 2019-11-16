package com.example.kiit.kiitwtpapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class PowerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {


            MediaPlayer mp = MediaPlayer.create(context, R.raw.akr);
            mp.start();
            Toast.makeText(context, "Power Connected", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "Power Disconnected", Toast.LENGTH_SHORT).show();
        }
    }
}
