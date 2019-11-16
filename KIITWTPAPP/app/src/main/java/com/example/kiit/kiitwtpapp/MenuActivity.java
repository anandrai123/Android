package com.example.kiit.kiitwtpapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends ListActivity {
    String [] screen={"MainActivity","CounterActivity","MY_Calc","GreetingActivity","LoginActivity","DealActivity","FriendActivity","horizontal_scrollActivity","CalendarTimeActivity","SeekBarActivity","AlterDialogActivity","RegistrationActivity","CreateActivity","MyServiceActivity","MyMusicActivity","BlankActivity","NatificationActivity","CameraActivity","WifiActivity","GPSActivity","LifeCycleActivity","EXIT"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter ad=new ArrayAdapter(this,android.R.layout.simple_list_item_1,screen);
        setListAdapter(ad);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this, ""+screen[position], Toast.LENGTH_SHORT).show();
        if(position==0)
        {
            Intent i=new Intent(this,MainActivity.class);
            startActivity(i);
        }
        else if(position==1)
        {
            Intent i=new Intent(this,CounterActivity.class);
            startActivity(i);
        }
        else if(position==2)
        {
            Intent i=new Intent(this,MY_Calc.class);
            startActivity(i);
        }
        else if(position==3)
        {
            Intent i=new Intent(this,GreetingActivity.class);
            startActivity(i);
        }
        else if(position==4)
        {
            Intent i=new Intent(this,LoginActivity.class);
            startActivity(i);
        }
        else if(position==5)
        {
            Intent i=new Intent(this,DealActivity.class);
            startActivity(i);
        }
        else if(position==6)
        {
            Intent i=new Intent(this,FriendActivity.class);
            startActivity(i);
        }

        else if(position==7)
        {
            Intent i=new Intent(this,horizontal_scrollActivity.class);
            startActivity(i);
        }
        else if(position==8)
        {
            Intent i=new Intent(this,CalenderTimeActivity.class);
            startActivity(i);
        }
        else if(position==9)
        {
            Intent i=new Intent(this,SeekBarActivity.class);
            startActivity(i);
        }
        else if(position==10)
        {
            Intent i=new Intent(this,AlterDialogActivity.class);
            startActivity(i);
        }
        else if(position==11)
        {
            Intent i=new Intent(this,RegistrationActivity.class);
            startActivity(i);
        }
        else if(position==12)
        {
            Intent i=new Intent(this,CreateActivity.class);
            startActivity(i);
        }
        else if(position==13)
        {
            Intent i=new Intent(this,MyServiceActivity.class);
            startActivity(i);
        }
        else if(position==14)
        {
            Intent i=new Intent(this,MyMusicActivity.class);
            startActivity(i);
        }
        else if(position==15)
        {
            Intent i=new Intent(this,BlankActivity.class);
            startActivity(i);
        }
        else if(position==16)
        {
            Intent i=new Intent(this,NatificationActivity.class);
            startActivity(i);
        }
        else if(position==17)
        {
            Intent i=new Intent(this,CameraActivity.class);
            startActivity(i);
        }
        else if(position==18)
        {
            Intent i=new Intent(this,WifiActivity.class);
            startActivity(i);
        }
        else if(position==19)
        {
            Intent i=new Intent(this,GPSActivity.class);
            startActivity(i);
        }
        else if(position==20)
        {
            Intent i=new Intent(this,LifeCycleActivity.class);
            startActivity(i);
        }

        else
        {
            finishAffinity();
        }
    }
}
