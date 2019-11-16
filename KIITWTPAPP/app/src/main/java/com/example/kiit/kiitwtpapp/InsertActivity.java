package com.example.kiit.kiitwtpapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2,e3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        e1=findViewById(R.id.editText16);
        e2=findViewById(R.id.editText17);
        e3=findViewById(R.id.editText19);
        b1=findViewById(R.id.button16);
        b1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String id=e1.getText().toString();
        String name=e2.getText().toString();
        String email=e3.getText().toString();
        try {
            SQLiteDatabase db = openOrCreateDatabase("AKR", MODE_PRIVATE, null);
            String sql = "insert into student values(" + id + ",'" + name + "','" + email + "')";
            db.execSQL(sql);
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(this, "ERROR : "+e, Toast.LENGTH_SHORT).show();
        }


    }
}
