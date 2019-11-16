package com.example.kiit.seekapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class Seek2Activity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    TextView tv;
    SeekBar sk;
    int i=0;
    String s1,s2;
    int min,sec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek2);
        sk=findViewById(R.id.seekBar);
        tv=findViewById(R.id.textView);
        sk.setOnSeekBarChangeListener(this);
        Bundle b=getIntent().getExtras();
           s1=b.getString("M");
           s2=b.getString("S");
           min=Integer.parseInt(s1);
           sec=Integer.parseInt(s2);
          sk.setMax(min*60+sec);

        class MyThread extends Thread {
            public void run() {


                for (i = 0;i<((min*60)+sec);i++) {
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

        //Bundle b=getIntent().getExtras();

       // String pass=b.getString("S");

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        tv.setText("Time"+(progress/60)+":"+(progress%60));
            i=progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
