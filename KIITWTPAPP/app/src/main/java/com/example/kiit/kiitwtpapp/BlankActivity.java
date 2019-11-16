package com.example.kiit.kiitwtpapp;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BlankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
        PowerReceiver pr=new PowerReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android:intent.action.ACTION_POWER_CONNECTED");
        Toast.makeText(this, "power connected", Toast.LENGTH_SHORT).show();
        registerReceiver(pr,filter);
    }
}
