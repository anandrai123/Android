package com.example.kiit.kiitwtpapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=findViewById(R.id.editText4);
        e2=findViewById(R.id.editText5);
        b=findViewById(R.id.button8);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name=e1.getText().toString();
        String pass=e2.getText().toString();
        Intent i=new Intent(this,LoginResultActivity.class);
        i.putExtra("N",name);
        i.putExtra("p",pass);
        Log.e("NAME",name);
        Log.e("PASS",pass);
        startActivity(i);
    }
}
