package com.example.kiit.mymusicapp;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String songsNames[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.ListView);

        final ArrayList<File> songs = readSongs(Environment.getExternalStorageDirectory());

        songsNames = new String[songs.size()];
        for (int i = 0; i < songs.size(); ++i) {
            songsNames[i] = songs.get(i).getName().toString().replace(".mp3", "");
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.sonds_layout ,R.id.textView,songsNames);

        lv.setAdapter(adapter);
       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
               startActivity( new Intent(MainActivity.this,AudioPlayer.class).putExtra("position",i).putExtra("list",songs));
           }
       });
    }
    private ArrayList<File> readSongs( File root){
        ArrayList<File>arrayList=new ArrayList<File>();
        File files[]=root.listFiles();

        for(File file : files){
            if(file.isDirectory())
            {
               arrayList.addAll(readSongs(file));

            }else{
                if(file.getName().endsWith(".mp3")){
                    arrayList.add(file);
                }
            }
        }
        return  arrayList;
    }
}
