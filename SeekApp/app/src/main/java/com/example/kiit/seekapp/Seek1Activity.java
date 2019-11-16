package com.example.kiit.seekapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Seek1Activity extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek1);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        b1=findViewById(R.id.button);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String min=e1.getText().toString();
        String sec=e2.getText().toString();
        //String total=(min*60)+sec;
        Intent i=new Intent(this,Seek2Activity.class);
        i.putExtra("M",min);
        i.putExtra("S",sec);
        startActivity(i);
    }
}
