package com.example.kiit.contentprovider;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
   // Button b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // b1=findViewById(R.id.button1);
       // b2=findViewById(R.id.button2);
        //b3=findViewById(R.id.button3);
        //b4=findViewById(R.id.button4);
        //b5=findViewById(R.id.button5);
       // b1.setOnClickListener(this);

    }


    public void Insert(View view) {
        Intent i=new Intent(this,InsertActivity.class);
        startActivity(i);
    }

    public void update(View view) {
        Intent i=new Intent(this,UpdateActivity.class);
        startActivity(i);
    }

    public void delete(View view) {
        Intent i=new Intent(this,DeleteActivity.class);
        startActivity(i);
    }
}
