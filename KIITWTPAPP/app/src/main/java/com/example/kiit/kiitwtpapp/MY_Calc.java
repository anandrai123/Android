package com.example.kiit.kiitwtpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MY_Calc extends AppCompatActivity {
    EditText e1,e2;
    TextView tv1;
    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__calc);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        tv1=findViewById(R.id.textView4);
        b1=findViewById(R.id.button3);
        b2=findViewById(R.id.button4);
        b3=findViewById(R.id.button5);
        b4=findViewById(R.id.button6);
        Sum s=new Sum();
        b1.setOnClickListener(s);
        Sub s1=new Sub();
        b2.setOnClickListener(s1);
        Mul m=new Mul();
        b3.setOnClickListener(m);
        Div d=new Div();
        b4.setOnClickListener(d);
    }

    private class Sum implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String num1=e1.getText().toString();
            int a=Integer.parseInt(num1);
            int b=Integer.parseInt(e2.getText().toString());
            int c=a+b;
            tv1.setText("sum="+c);
        }
    }

    private class Sub implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String num1=e1.getText().toString();
            int a=Integer.parseInt(num1);
            int b=Integer.parseInt(e2.getText().toString());
            int e=a-b;
            tv1.setText("sub="+e);

        }
    }

    private class Mul implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String num1=e1.getText().toString();
            int a=Integer.parseInt(num1);
            int b=Integer.parseInt(e2.getText().toString());
            int f=a*b;
            tv1.setText("mul="+f);

        }
    }

    private class Div implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String num1=e1.getText().toString();
            int a=Integer.parseInt(num1);
            int b=Integer.parseInt(e2.getText().toString());
            int g=a/b;
            tv1.setText("div="+g);
        }
    }
}
