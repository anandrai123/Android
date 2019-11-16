package com.example.kiit.contentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2,e3;
    Button b1;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        e1=findViewById(R.id.editText16);
        e2=findViewById(R.id.editText17);
        e3=findViewById(R.id.editText19);
        b1=findViewById(R.id.button16);
        b1.setOnClickListener(this);
        String path="content://akr.1998/student";
        uri=Uri.parse(path);
    }

    @Override
    public void onClick(View v) {
        int id=Integer.parseInt(e1.getText().toString());
        String name=e2.getText().toString();
        String email=e3.getText().toString();
        ContentValues values=new ContentValues();
        values.put("id",id);
        values.put("name",name);
        values.put("email",email);
        ContentResolver resolver=getContentResolver();
        resolver.insert(uri,values);
        Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();

    }
}
