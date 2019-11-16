package com.example.kiit.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Ques2Activity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    RadioButton r1,r2,r3,r4;
    RadioGroup rg;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques2);
        r1=findViewById(R.id.radioButton5);
        r2=findViewById(R.id.radioButton6);
        r3=findViewById(R.id.radioButton7);
        r4=findViewById(R.id.radioButton8);
        rg=findViewById(R.id.radioGroup);
        b1=findViewById(R.id.button3);
        b2=findViewById(R.id.button4);
        rg.setOnCheckedChangeListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

    @Override
    public void onClick(View v) {

    }
}
