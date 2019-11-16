package com.example.kiit.kiitwtpapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DealActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal);
        e1=findViewById(R.id.editText6);
        e2=findViewById(R.id.editText7);
        b=findViewById(R.id.button9);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String quan=e1.getText().toString();
        String price=e2.getText().toString();
        Intent i=new Intent(this,ConfirmationActivity.class);
        i.putExtra("N",quan);
        i.putExtra("p",price);
        Log.e("Quantity",quan);
        Log.e("Price",price);
        startActivity(i);
    }
}
