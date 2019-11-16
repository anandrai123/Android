package com.example.kiit.kiitwtpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class RegistrationResultActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_result);
        tv1=findViewById(R.id.textView18);
        tv2=findViewById(R.id.textView19);
        tv3=findViewById(R.id.textView20);
        tv4=findViewById(R.id.textView21);
        tv5=findViewById(R.id.textView22);
        tv6=findViewById(R.id.textView23);
        tv7=findViewById(R.id.textView24);
        Bundle b=getIntent().getExtras();
        ArrayList<String> course=b.getStringArrayList("C");
        String name=b.getString("N");
        String pass=b.getString("p");
        String ph=b.getString("phone");
        String email=b.getString("E");
        String d=b.getString("D");
        String sem=b.getString("S");
        //String cou=b.getString("C");
        tv1.setText("name :"+name);
        tv2.setText("pass:"+pass);
        tv3.setText("phone n0.:"+ph);
        tv4.setText("Email:"+email);
        tv5.setText("Date:"+d);
        tv6.setText("Semester:"+sem);
       tv7.setText("courses:"+course);
    }
}
