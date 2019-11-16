package com.example.kiit.kiitwtpapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        e1=findViewById(R.id.editText);
        e3=findViewById(R.id.editText2);

        b1=findViewById(R.id.button);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String i=e1.getText().toString();
        String e=e3.getText().toString();
        try {
            SQLiteDatabase db = openOrCreateDatabase("AKR", MODE_PRIVATE, null);
           String sql="update student set email == '"+e+"' where id=="+i;
            db.execSQL(sql);
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e3)
        {
            Toast.makeText(this, "ERROR"+e3, Toast.LENGTH_SHORT).show();
        }


    }
}
