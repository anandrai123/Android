package com.example.kiit.kiitwtpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmationActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv1,tv2,tv3;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        tv1=findViewById(R.id.textView10);
        tv2=findViewById(R.id.textView11);
        tv3=findViewById(R.id.textView12);
        b1=findViewById(R.id.button10);
        b2=findViewById(R.id.button11);

        Bundle b=getIntent().getExtras();
        String name=b.getString("N");
        String pass=b.getString("p");
        tv1.setText("Quantity :"+name);
        tv2.setText("price:"+pass);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==b1)
        {
            tv3.setText("deal is confirmed");
        }
        else if(v==b2)
        {
            tv3.setText("deal is cancle");
        }
    }
}
