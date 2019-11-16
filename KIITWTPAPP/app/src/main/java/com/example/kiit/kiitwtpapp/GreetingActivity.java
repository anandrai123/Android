package com.example.kiit.kiitwtpapp;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class GreetingActivity extends AppCompatActivity {
    EditText e;
    TextView tv;
    Button b;int h;Time t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        e=findViewById(R.id.editText3);
        tv=findViewById(R.id.textView7);
        b=findViewById(R.id.button7);
        final Date currentTime = Calendar.getInstance().getTime();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // int h= (int) currentTime.getTime();
                 h= (int) currentTime.getHours();
                 int m= (int) currentTime.getMinutes();
                int sec= (int) currentTime.getSeconds();
                String num=e.getText().toString();

                //Toast.makeText(GreetingActivity.this, ""+h, Toast.LENGTH_SHORT).show();
                if(h>=2&&h<12)
                {
                    tv.setText("good Morning-"+num+h+":"+m+":"+sec);
                }
                else if((h>=12)&&(h<=16))
                {
                    tv.setText("good After noon-"+num+h+":"+m+":"+sec);
                }
                else if(h>16&&h<=23)
                {
                    tv.setText(" very good Evening-"+num+h+":"+m+":"+sec);
                }

            }
        });


    }
}
