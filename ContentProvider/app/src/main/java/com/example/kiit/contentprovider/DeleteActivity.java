package com.example.kiit.contentprovider;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1;
    Button b;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        e1=findViewById(R.id.editText);
        b=findViewById(R.id.button);
        b.setOnClickListener(this);
        String path="content://akr.1998/student";
        uri=Uri.parse(path);
    }

    @Override
    public void onClick(View v) {
        String i=e1.getText().toString();
        ContentResolver resolver=getContentResolver();
        resolver.delete(uri,"id ="+i,null);
        Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show();
    }
}
