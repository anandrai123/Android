package com.example.kiit.kiitwtpapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NatificationActivity extends AppCompatActivity {
    String channel_id="RCPL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_natification);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void showNoti(View view) {
        NotificationCompat.Builder builder=
                new NotificationCompat.Builder(this,channel_id);
             Intent i=new Intent(this,LoginActivity.class);
        PendingIntent pi=PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);

        createChannel();
        builder.setSmallIcon(android.R.drawable.star_big_on);
        builder.setContentTitle("Android batch");
        builder.setContentText("love u all");
        builder.setOngoing(true);
        Notification n=builder.build();
        NotificationManager nm= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(500,n);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O);
        String channel_name="for wtp";
        String description ="for android";
        NotificationChannel channel=new NotificationChannel(channel_id,channel_name,NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription(description);
        NotificationManager nm=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        nm.createNotificationChannel(channel);


    }

    public void cancelNoti(View view) {
        NotificationManager nm=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        nm.cancel(500);
    }

    public void bigPIC(View view) {
        NotificationCompat.Builder builder=
                new NotificationCompat.Builder(this,channel_id);



        createChannel();
        builder.setSmallIcon(android.R.drawable.star_big_on);
        Intent i=new Intent(this,LoginActivity.class);
        PendingIntent pi=PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);

        builder.setContentTitle("Android batch");
        builder.setContentText("EXAM ON 3rd Feb at 4:00 PM");

        NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.bf);
        style.bigPicture(bitmap);
        Bitmap bit2=BitmapFactory.decodeResource(getResources(),R.drawable.peng);
        style.bigLargeIcon(bit2);
        style.setBigContentTitle("BIG TITLE");
        style.setSummaryText("SUMMARY TEXT");
        builder.setStyle(style);
       // builder.setOngoing(true);
        Notification n=builder.build();
        NotificationManager nm= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(500,n);
    }
}
