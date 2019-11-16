package com.example.kiit.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Ques1Activity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    RadioGroup rg;
    RadioButton r1,r2,r3,r4;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques1);
        r1=findViewById(R.id.radioButton);
        r2=findViewById(R.id.radioButton2);
        r3=findViewById(R.id.radioButton3);
        r4=findViewById(R.id.radioButton4);
        rg=findViewById(R.id.radioGroup);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        rg.setOnCheckedChangeListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

    @Override
    public void onClick(View v) {
        if(v==b1) {
            rg.clearCheck();
        }
        else if(v==b2)
        {
            String Ans=r1.getText().toString();
            Intent i=new Intent (this,Ques2Activity.class);
            i.putExtra("Ques1",Ans);
            startActivity(i);
        }
        }

}

