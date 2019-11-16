package com.example.kiit.kiitwtpapp;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    String[] c={"DSA","DAA","WT","BETC","PDC","DEC","COA","PHYSICS","OS","CN"};
    String[] s={"1","2","3","4","5"};
    int i=0;
    EditText e1,e2,e3,e4,e5;
    Button b;
    Date d=new Date();
    String radioData;
    String date;
    ArrayList<String>course=new ArrayList<>();
     //Calendar cl=Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        e1=findViewById(R.id.editText11);
        e2=findViewById(R.id.editText12);
        e3=findViewById(R.id.editText13);
        e4=findViewById(R.id.editText14);
        e5=findViewById(R.id.editText15);
        e5.setOnClickListener(this);
        b=findViewById(R.id.button14);
       // b2=findViewById(R.id.button15);
        b.setOnClickListener(this);


    }

    public void semester(View view) {
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setIcon(android.R.drawable.alert_dark_frame);
        b.setTitle("Select your courses");
        b.setSingleChoiceItems(s, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                i=which;

            }
        });
        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(RegistrationActivity.this, "SELECTED", Toast.LENGTH_SHORT).show();
                radioData = s[i];

            }
        });
        b.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(RegistrationActivity.this, "NOT SELECTED", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog =b.create();
        alertDialog.show();
    }

    public void Courses(View view) {
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setIcon(android.R.drawable.alert_dark_frame);
        b.setTitle("Select your courses");
//        b.setSingleChoiceItems(c, -1, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                i=which;
//            }
//        });

        b.setMultiChoiceItems(c, new boolean[]{false, false, false, false, false, false, false, false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                i = which;

                    course.add(c[i]);             }


        });
        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(RegistrationActivity.this, "SELECTED", Toast.LENGTH_SHORT).show();


            }
        });
        b.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(RegistrationActivity.this, "NOT SELECTED", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog =b.create();
        alertDialog.show();
    }




    public void Cancel(View view) {
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setIcon(R.drawable.bf);
        b.setTitle("cancel");
        b.setMessage("do you want to cancel :");
        b.setPositiveButton("CANCEL FORM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(RegistrationActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        b.setNeutralButton("BACK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(RegistrationActivity.this, "Stay on same page", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog=b.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v == e5) {
            DatePickerDialog dp = new DatePickerDialog(this, new MyDate(), d.getDay(), d.getMonth(), d.getYear());
            dp.show();
        } else {
            String name = e1.getText().toString();
            String pass = e2.getText().toString();
            String ph = e3.getText().toString();
            String em = e4.getText().toString();


            Intent i = new Intent(this, RegistrationResultActivity.class);
            i.putExtra("N", name);
            i.putExtra("p", pass);
            i.putExtra("phone", ph);
            i.putExtra("E", em);

            i.putExtra("S", radioData);
            i.putExtra("C", course);
            i.putExtra("D", e5.getText().toString());


            startActivity(i);
        }
    }


    private class MyDate implements DatePickerDialog.OnDateSetListener {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String data=dayOfMonth+"-"+(month+1)+"-"+year;
            e5.setText(data);
            //tv1.setText(data);
        }
    }




   /* private class Calendar1 {
        int y=cl.get(Calendar.YEAR);
        int m=cl.get(Calendar.MONTH);
        int d=cl.get(Calendar.DAY_OF_MONTH);
        String data=(d+"-"+"-"+m+"-"+y);
       String s=e5.getText().toString();
       void getDate(String date)
       {

       }

        //String data=hourOfDay+":"+minute;



    }*/
}
