package com.example.atul.handcricket;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class TossActivity extends AppCompatActivity {

    TextView tosstext,text1;
    ProgressBar progressBar;
    Button head,tails,start;
    ImageView tossimg;
    public String mytoss = "",mychoice="";
    String string1,string2;
    public int int_toss=0,rand_toss;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);

        head = (Button) findViewById(R.id.headsbtn);
        tails = (Button) findViewById(R.id.tailsbtn);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        tosstext = (TextView) findViewById(R.id.wintext);
        text1 = (TextView) findViewById(R.id.text1);
        tossimg = (ImageView) findViewById(R.id.toss_img);
        start = (Button) findViewById(R.id.match);

   //     string1 = getIntent().getStringExtra("overs");
    //    string2 = getIntent().getStringExtra("oppteam");

        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int_toss = 0;
                tails.setEnabled(false);
                progressBar.setVisibility(View.VISIBLE);
                evaluate();
            }
        });

        tails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int_toss = 1;
                head.setEnabled(false);
                progressBar.setVisibility(View.VISIBLE);
                evaluate();
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //        Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TossActivity.this,Playing.class);
       //         intent.putExtra("overs1",string1);
      //          intent.putExtra("oppteam1",string2);
                startActivity(intent);
                finish();
            }
        });
    }

    public void evaluate() {
        Random r = new Random();
        rand_toss = r.nextInt(2);

        if(rand_toss == int_toss)
        {
            tosstext.setText("You Won");

            AlertDialog.Builder builder = new AlertDialog.Builder(TossActivity.this);
            builder.setCancelable(false);
            builder.setMessage("What do you elect ? ");
            builder.setTitle("You Won Toss!!");
            builder.setPositiveButton("Ball", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    tosstext.setText("You Won.You chose to bowl first.");
                }
            });

            builder.setNegativeButton("Bat", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    tosstext.setText("You Won and chose to bat first.");
                }
            });

            AlertDialog a=builder.create();
            a.show();
            Button bq = a.getButton(DialogInterface.BUTTON_NEGATIVE);
            Button bq2 = a.getButton(DialogInterface.BUTTON_POSITIVE);
            bq.setTextColor(ContextCompat.getColor(TossActivity.this, R.color.colorPrimary));
            bq2.setTextColor(ContextCompat.getColor(TossActivity.this, R.color.colorPrimary));
        }
        else {
            if (rand_toss == 0) {
                tosstext.setText("You lose.Opponent chose to bat.");
            } else {
                tosstext.setText("You lose.Opponent chose to bowl.");
            }
        }
        head.setEnabled(false);
        tails.setEnabled(false);
        progressBar.setVisibility(View.GONE);

    }

}
