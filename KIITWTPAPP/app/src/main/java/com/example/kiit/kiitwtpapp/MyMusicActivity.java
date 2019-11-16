package com.example.kiit.kiitwtpapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyMusicActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener {
    Button b1, b2;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_music);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        mp=MediaPlayer.create(this,R.raw.akr);
        b2.setEnabled(false);
        mp.setOnCompletionListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == b1) {
            mp.start();
            b2.setEnabled(true);
            b1.setEnabled(false);
          //  mp.

        } else {
            mp.pause();
            b1.setEnabled(true);
            b2.setEnabled(false);

        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.stop();

    }


}
