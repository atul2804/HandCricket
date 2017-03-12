package com.example.atul.handcricket;

import android.content.DialogInterface;
import android.icu.text.PluralRules;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Playing extends AppCompatActivity {

    TextView run,wicket,player1,player2,over;
    TextView text_run,text_wick,text1,tex2,text_over;
    Button one,two,three,four,five,six;
    ImageView img1,img2;
    TextView team1,team2;
    int my = 0,opp = 0,maxo = 5;
    public int my_team=0,op_team=0,wick=0,balls=0;
    public static double num_over = 0.0;
    String oppteam,max_over,myteam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        run = (TextView) findViewById(R.id.runs);
        wicket = (TextView) findViewById(R.id.wickets);
        player1 = (TextView) findViewById(R.id.player_1);
        player2 = (TextView) findViewById(R.id.player_2);
        over = (TextView) findViewById(R.id.over);

      //  maxo = Integer.valueOf(getIntent().getExtras().getString("overs1"));
     //   maxo = Integer.decode(max_over);

        text_wick = (TextView) findViewById(R.id.text_score);
        text_run = (TextView) findViewById(R.id.text_runs);
        text1 = (TextView) findViewById(R.id.player1_run);
        tex2 = (TextView) findViewById(R.id.player2_run);
        text_over = (TextView) findViewById(R.id.text_overs);
        team1 = (TextView) findViewById(R.id.team1);
        team2 = (TextView) findViewById(R.id.team2);
        img1 = (ImageView) findViewById(R.id.image1);
        img2 = (ImageView) findViewById(R.id.image2);

        Prefmanager prefmanager = new Prefmanager(Playing.this);
        oppteam = prefmanager.getOpTeam();
        myteam = prefmanager.getMyTeam();
        max_over = prefmanager.getovers();

        team1.setText(myteam);
        team2.setText(oppteam);

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);

    //    init_team();

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my =1;
                calc();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my=2;
                calc();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my=3;
                calc();
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my=4;
                calc();
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my=5;
                calc();
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my=6;
                calc();
            }
        });
    }

    public void init_team() {

    }

    public void calc() {
        Random random = new Random();
        opp = random.nextInt(6) + 1;
        if (opp == my) {
            wick++;
        }
        else {
            my_team += my;
        }
        balls++;
     /*   if (balls%6 == 0) {
            num_over=(int)balls/6;
        } else {
            num_over += 0.1;
        }  */
        num_over = balls/6;
        if (max_over.equals(String.valueOf(num_over)) || wick == 10) {
            one.setEnabled(false);
            two.setEnabled(false);
            three.setEnabled(false);
            four.setEnabled(false);
            five.setEnabled(false);
            six.setEnabled(false);
        }
        wicket.setText(String.valueOf(wick));
        run.setText(String.valueOf(my_team));
        over.setText(String.valueOf(num_over));
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Playing.this);
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
        bq.setTextColor(ContextCompat.getColor(Playing.this, R.color.colorPrimary));
        bq2.setTextColor(ContextCompat.getColor(Playing.this, R.color.colorPrimary));
    }
}
