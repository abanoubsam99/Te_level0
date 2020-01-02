package com.example.level0;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class well extends AppCompatActivity {
    private static int Splash_timer_out=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_well);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        new Handler(  ).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent=new Intent( well.this,MainActivity.class );
                startActivity( homeIntent );
                finish();
            }
        },Splash_timer_out );

    }
}
