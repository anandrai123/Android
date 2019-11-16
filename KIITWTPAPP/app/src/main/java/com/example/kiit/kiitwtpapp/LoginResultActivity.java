package com.example.kiit.kiitwtpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginResultActivity extends AppCompatActivity {
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);
        tv1=findViewById(R.id.textView8);
        tv2=findViewById(R.id.textView9);
        Bundle b=getIntent().getExtras();
        String name=b.getString("N");
        String pass=b.getString("p");
        tv1.setText("name :"+name);
        tv2.setText("pass:"+pass);
    }
}
