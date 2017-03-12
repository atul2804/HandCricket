package com.example.atul.handcricket;

import android.content.DialogInterface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Playing2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing2);


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Playing2.this);
        builder.setCancelable(true);
        builder.setMessage("Do you want to quit ? Your progress will be deleted.");
        builder.setTitle("Exit !!");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                dialog.dismiss();
            }
        });

        AlertDialog a=builder.create();
        a.show();
        Button bq = a.getButton(DialogInterface.BUTTON_NEGATIVE);
        Button bq2 = a.getButton(DialogInterface.BUTTON_POSITIVE);
        bq.setTextColor(ContextCompat.getColor(Playing2.this, R.color.colorPrimary));
        bq2.setTextColor(ContextCompat.getColor(Playing2.this, R.color.colorPrimary));
    }
}
