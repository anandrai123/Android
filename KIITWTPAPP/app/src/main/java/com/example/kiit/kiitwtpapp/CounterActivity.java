package com.example.kiit.kiitwtpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {
    TextView tv;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        tv= findViewById(R.id.textView2);
        //tv2= findViewById(R.id.textView2);
    }

    public void increment(View view) {
        i++;
        tv.setText("Counter ="+i);
    }

    public void Decrement(View view) {
        i--;
        tv.setText("Counter ="+i);
    }
}

