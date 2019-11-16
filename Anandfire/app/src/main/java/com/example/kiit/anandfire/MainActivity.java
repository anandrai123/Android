package com.example.kiit.anandfire;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int GALLERY_REQUEST = 1;
    ImageButton mSelectImage;
    EditText mPostTitle;
    EditText mPostDesc;
    Button mSubmitBtn;
    Uri mImageUri=null;
    private StorageReference mStorage;
    ProgressDialog mProgress;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStorage=FirebaseStorage.getInstance().getReference();
        mSelectImage=findViewById(R.id.imageButton);
        mPostTitle=findViewById(R.id.editText3);
        mPostDesc=findViewById(R.id.editText4);
        mSubmitBtn=findViewById(R.id.button2);
        mProgress=new ProgressDialog(this);
        mSelectImage.setOnClickListener(this);
        mSubmitBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mSelectImage) {
            Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
            galleryIntent.setType("images/*");
            startActivityForResult(galleryIntent, GALLERY_REQUEST);
        } else if (v == mSubmitBtn) {
            startPosting();
        }
    }

    private void startPosting() {
        mProgress.setMessage("posting to blog....");
        mProgress.show();
        String title_val=mPostTitle.getText().toString().trim();
        String desc_val=mPostDesc.getText().toString().trim();
        if(!TextUtils.isEmpty(title_val)&&!TextUtils.isEmpty(desc_val)&&mImageUri!=null)
        {
            StorageReference filepath=mStorage.child("Blog_Images").child(mImageUri.getLastPathSegment());
            filepath.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri downloadUrl;
                    //downloadUrl = taskSnapshot.getDownloadUrl();
                    mProgress.dismiss();

                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GALLERY_REQUEST && resultCode==RESULT_OK){
            mImageUri = data.getData();
            mSelectImage.setImageURI(mImageUri);
        }
    }
}
