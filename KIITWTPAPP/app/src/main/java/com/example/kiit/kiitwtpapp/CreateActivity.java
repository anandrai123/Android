package com.example.kiit.kiitwtpapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        b5=findViewById(R.id.button5);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==b1) {
            try {
                SQLiteDatabase db = openOrCreateDatabase("AKR", MODE_PRIVATE, null);
                String sql = "create table if not exists student(id int primary key,name varchar(30),email varchar(30))";
                db.execSQL(sql);
            } catch (Exception e) {
                Toast.makeText(this, "ERROR" + e, Toast.LENGTH_SHORT).show();
            }
        }
        else if(v==b2)
        {
            Intent i=new Intent(this,InsertActivity.class);
            startActivity(i);
        }
        else if(v==b3)
        {
            Intent i=new Intent(this,UpdateActivity.class);
            startActivity(i);
        }
        else if(v==b4)
        {
            Intent i=new Intent(this,DeleteActivity.class);
            startActivity(i);
        }
        else if(v==b5)
        {
            Intent i=new Intent(this,ShowActivity.class);
            startActivity(i);
        }

    }
}
