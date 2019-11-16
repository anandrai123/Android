package com.example.kiit.kiitwtpapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        e1=findViewById(R.id.editText);
        b=findViewById(R.id.button);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String i=e1.getText().toString();
        //String e=e2.getText().toString();
        try {
            SQLiteDatabase db = openOrCreateDatabase("AKR", MODE_PRIVATE, null);
            String sql="delete from student where id=="+i;
            db.execSQL(sql);
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e3)
        {
            Toast.makeText(this, "ERROR"+e3, Toast.LENGTH_SHORT).show();
        }
    }
}
