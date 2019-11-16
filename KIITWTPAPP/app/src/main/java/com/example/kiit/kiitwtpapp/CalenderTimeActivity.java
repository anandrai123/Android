package com.example.kiit.kiitwtpapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class CalenderTimeActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv1,tv2;
    EditText e1,e2;
    Date d=new Date();
    //Calendar c=new Calendar() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_time);
        tv1=findViewById(R.id.textView14);
        tv2=findViewById(R.id.textView15);
        e1=findViewById(R.id.editText8);
        e2=findViewById(R.id.editText9);
        e1.setOnClickListener(this);
        e2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==e1)
        {
            DatePickerDialog dp=new DatePickerDialog(this,new MyDate(),d.getDay(),d.getMonth(),d.getYear());
            dp.show();
        }
        else
        {
            TimePickerDialog tp=new TimePickerDialog(this,new MyTime(),d.getHours(),d.getMinutes(),true);
            tp.show();
        }

    }


    private class MyDate implements DatePickerDialog.OnDateSetListener {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String data=dayOfMonth+"-"+(month+1)+"-"+year;
            e1.setText(data);
            tv1.setText(data);

        }
    }

    private class MyTime implements TimePickerDialog.OnTimeSetListener {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String data=hourOfDay+":"+minute;
            e2.setText(data);
            tv2.setText(data);
        }
    }
}
