package com.example.kiit.mymusicapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.File;
import java.util.ArrayList;

public class AudioPlayer extends AppCompatActivity implements View.OnClickListener {
    Button btnPlay,btnBack,btnFor;
    SeekBar sk;
   static private MediaPlayer mp;
    Runnable runnable;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);
        if(mp!=null){
            mp.stop();
            mp.release();
        }

        Bundle bundle=getIntent().getExtras();

        ArrayList<File>songs= (ArrayList) bundle.getParcelableArrayList("list");
        int position =bundle.getInt("position");
        Uri uri =Uri.parse(songs.get(position).toString());

        mp=MediaPlayer.create(this,uri);

        btnPlay=findViewById(R.id.button);
        btnFor=findViewById(R.id.button2);
        btnBack=findViewById(R.id.button3);
        handler=new Handler();
        sk=findViewById(R.id.seekBar);
       // mp=MediaPlayer.create(this,R.raw.akr1);
        btnFor.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                sk.setMax(mp.getDuration());
                mp.start();
                changeSeekbar();
            }
        });
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    mp.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void changeSeekbar() {
        sk.setProgress(mp.getCurrentPosition());
        if(mp.isPlaying())
        {
            runnable=new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handler.postDelayed(runnable,200);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button:
                if(mp.isPlaying()){
                    mp.pause();
                    btnPlay.setText(">");
                }else{
                    mp.start();
                    btnPlay.setText("||");
                    changeSeekbar();
                }
                break;
            case R.id.button2:
                mp.seekTo(mp.getCurrentPosition()+5000);
                break;
            case R.id.button3:
                mp.seekTo(mp.getCurrentPosition()-5000);

        }
    }


}

