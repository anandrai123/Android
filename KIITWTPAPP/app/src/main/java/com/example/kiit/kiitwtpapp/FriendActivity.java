package com.example.kiit.kiitwtpapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FriendActivity extends ListActivity {
    String[] name={"abhi","aniket","himanshu","Nitin","piyush","ritik","priya","amar"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter ad=new ArrayAdapter(this,android.R.layout.simple_list_item_1,name);
        setListAdapter(ad);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this,"Clicked on" +name[position],Toast.LENGTH_LONG).show();

    }
}
