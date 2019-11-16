package com.example.kiit.kiitwtpapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {
  ImageView iv;
  Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        iv=findViewById(R.id.imageView);
        b=findViewById(R.id.button);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,500);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
          if(resultCode==RESULT_OK && data !=null)
          {
              Bitmap bitmap=(Bitmap)data.getExtras().get("data");
              iv.setImageBitmap(bitmap);
          }
          else
          {
              Toast.makeText(this, "Photo not selected", Toast.LENGTH_SHORT).show();
          }
    }

}
