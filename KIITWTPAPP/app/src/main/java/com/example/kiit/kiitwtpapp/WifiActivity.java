package com.example.kiit.kiitwtpapp;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WifiActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3;
    Switch s;
    ListView lv;
    TextView tv;
    WifiManager wm;
    ArrayList<String> al= new ArrayList<String>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        b1=findViewById(R.id.button20);
        b2=findViewById(R.id.button21);
        b3=findViewById(R.id.button22);
        tv=findViewById(R.id.textView25);
        s=findViewById(R.id.switch1);
        lv=findViewById(R.id.lv);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        s.setOnClickListener(this);
        wm=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);


    }

    @Override
    public void onClick(View v) {
        if(v==s)
        {
            if(s.isChecked())
            {
                wm.setWifiEnabled(true);
            }
            else{
                wm.setWifiEnabled(false);
            }
        }else if(v==b1)
        {
            List<WifiConfiguration> devices = wm.getConfiguredNetworks();
            for(WifiConfiguration singleDevice : devices)
            {
                String name = singleDevice.SSID;

                al.add(name);
            }
            ArrayAdapter ad=new ArrayAdapter(this,android.R.layout.simple_list_item_1,al);
            lv.setAdapter(ad);
        }
        else if(v==b2)
        {
            WifiInfo info= wm.getConnectionInfo();
            String name= info.getSSID();
            int rssi = info.getRssi();
            int signal= wm.calculateSignalLevel(rssi,10);
            tv.setText(name+" : "+signal);

        }
        else if(v==b3)
        {
            Intent i= new Intent(Settings.ACTION_WIFI_SETTINGS);
            startActivity(i);
        }

    }
}
