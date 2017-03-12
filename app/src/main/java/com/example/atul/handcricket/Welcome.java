package com.example.atul.handcricket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.os.Handler;

public class Welcome extends Activity {

    public static int timeout = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ImageView img = (ImageView)findViewById(R.id.welcome_image);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Welcome.this,TeamActivity.class);
                startActivity(i);
                finish();
            }
        },timeout);
    }
}
