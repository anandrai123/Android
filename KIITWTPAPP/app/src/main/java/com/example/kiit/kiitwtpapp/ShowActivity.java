package com.example.kiit.kiitwtpapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {
    ListView lv;
    ArrayList al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        lv=findViewById(R.id.lvw);
        al=new ArrayList();
        SQLiteDatabase db = openOrCreateDatabase("AKR", MODE_PRIVATE, null);
        String sql="select * from student";
        Cursor cur=db.rawQuery(sql,null);
        while(cur.moveToNext())
        {
            String id=cur.getString(0);
            String name=cur.getString(1);
            String email=cur.getString(2);
            String data=id+"-"+name+"-"+email;
            al.add(data);

        }
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(adapter);
    }
}
