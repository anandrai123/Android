package com.example.kiit.kiitwtpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    SeekBar sk;
    TextView tv;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        sk=findViewById(R.id.seekBar);
        tv=findViewById(R.id.textView16);
        sk.setOnSeekBarChangeListener(this);
        class MyThread extends Thread {
            public void run() {


                for (i = 0; i < 100; i++) {
                    sk.setProgress(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

            MyThread th = new MyThread();
            th.start();

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        tv.setText("position== "+progress);
        i=progress;

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
