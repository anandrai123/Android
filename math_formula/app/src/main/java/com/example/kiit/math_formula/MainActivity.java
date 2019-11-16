package com.example.kiit.math_formula;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
    EditText e1;
    TextView tv;
    Button b, b2, b3, b4, b5, b6, b7;
    double i, a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editText3);
        tv = findViewById(R.id.textView2);
        b = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b5.setText(Html.fromHtml("x<sup>2</sup>"));
        b6.setText(Html.fromHtml("x<sup>3</sup>"));
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = Double.parseDouble(e1.getText().toString());
                a = Math.sin(i);
                tv.setText("sin :" + a);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = Double.parseDouble(e1.getText().toString());
                a = Math.cos(i);
                tv.setText("cos :" + a);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = Double.parseDouble(e1.getText().toString());
                a = Math.tan(i);
                tv.setText("tan :" + a);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = Double.parseDouble(e1.getText().toString());
                a = Math.sqrt(i);
                tv.setText("root :" + a);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = Double.parseDouble(e1.getText().toString());
                a = Math.pow(i, 2);
                tv.setText("square:" + a);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = Double.parseDouble(e1.getText().toString());
                a = Math.pow(i, 3);
                tv.setText("cubic :" + a);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = Double.parseDouble(e1.getText().toString());
                a = i;
                for (int j = (int) i-1; j > 1; j--) {
                    a = a * j;
                }
                // a=Math.f(i);
                tv.setText("fact :" + a);
            }
        });
    }

}
