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

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e3;
    Button b1;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        e1=findViewById(R.id.editText);
        e3=findViewById(R.id.editText2);

        b1=findViewById(R.id.button);
        b1.setOnClickListener(this);
        String path="content://akr.1998/student";
        uri=Uri.parse(path);
    }

    @Override
    public void onClick(View v) {
        String id=(e1.getText().toString());
        String email=e3.getText().toString();
        ContentValues values=new ContentValues();
        values.put("id",id);
       // val.put("name",name);
        values.put("email",email);
        ContentResolver resolver=getContentResolver();
        resolver.update(uri,values,"id ="+id,null);
        Toast.makeText(this, "Data updated", Toast.LENGTH_SHORT).show();
    }
}
