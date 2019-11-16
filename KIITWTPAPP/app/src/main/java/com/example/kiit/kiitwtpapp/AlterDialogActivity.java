package com.example.kiit.kiitwtpapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AlterDialogActivity extends AppCompatActivity {
    String[] fr={"Red","Green","Blue","Gray"};
    String [] c={"java","python","Android","ML","C++"};
    LinearLayout l;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter_dialog);
        l=findViewById(R.id.lay);
    }

    public void SimpleDialog(View view) {
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setIcon(R.drawable.bf);
        b.setTitle("AkR...");
        b.setMessage("do you want to fire missile :");
        b.setPositiveButton("Fire", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlterDialogActivity.this, "Fired", Toast.LENGTH_SHORT).show();
            }
        });
        b.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlterDialogActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog=b.create();
        alertDialog.show();


    }

    public void ListDialog(View view) {
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setIcon(android.R.drawable.alert_dark_frame);
        b.setTitle("Select your colour");
        b.setItems(fr, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlterDialogActivity.this, ""+fr[which], Toast.LENGTH_SHORT).show();
                switch(which)
                {
                    case 0:
                        l.setBackgroundColor(Color.RED);
                    break;

                    case 1:
                        l.setBackgroundColor(Color.GREEN);

                    break;
                    case 2:
                        l.setBackgroundColor(Color.BLUE);
                        break;

                    case 3:
                        l.setBackgroundColor(Color.GRAY);
                        break;
                }

            }
        });
        AlertDialog alertDialog =b.create();
        alertDialog.show();
    }

    public void Course(View view) {
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setIcon(android.R.drawable.alert_dark_frame);
        b.setTitle("Select your courses");
        b.setSingleChoiceItems(c, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                i=which;
            }
        });
        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlterDialogActivity.this, "SELECTED", Toast.LENGTH_SHORT).show();

            }
        });
        b.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlterDialogActivity.this, "NOT SELECTED", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog =b.create();
        alertDialog.show();

    }


    public void CustomDialog(View view) {
        final Dialog d=new Dialog(this);
        d.setTitle("CUSTOM DIALOG: REGISTRATION");
        d.setContentView(R.layout.customdialog);
        final EditText e1=d.findViewById(R.id.editText10);
        Button b1=d.findViewById(R.id.button4);
        Button b2=d.findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AlterDialogActivity.this, "REGISTERED"+e1.getText().toString(), Toast.LENGTH_SHORT).show();
                d.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AlterDialogActivity.this, "CANCEL"+e1.getText().toString(), Toast.LENGTH_SHORT).show();
                d.dismiss();
            }
        });
        d.show();
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setIcon(R.drawable.bf);
        b.setTitle("BACK");
        b.setMessage("do you want to go back :");
        b.setPositiveButton("BACK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlterDialogActivity.this, "back", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        b.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlterDialogActivity.this, "Stay on same page", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog=b.create();
        alertDialog.show();
    }
}
