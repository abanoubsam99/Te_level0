package com.example.level0;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.level0.Games.games;
import com.example.level0.Quizes.Quiz1C;
import com.example.level0.Quizes.QuizCatalogue;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    private InterstitialAd mInterstitialAd;

    TextView textView6,textView5,text_moraga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-9066719717930706~6805817120");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/5013023536");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        Typeface typeface2=Typeface.createFromAsset( this.getAssets(),"a-massir-ballpoint.ttf" );


        textView6=findViewById(R.id.textView6);
        textView5=findViewById(R.id.textView5);
        text_moraga=findViewById(R.id.text_moraga);


        textView6.setTypeface(typeface2);
        textView5.setTypeface(typeface2);
        text_moraga.setTypeface(typeface2);

    }

    public void F(View view) {
       Intent intent=new Intent(this, Tamhidy_1.class);
        startActivity( intent );

    }
    public void s(View view) {
       Intent intent=new Intent(this, Tamhidy_2.class);
       startActivity( intent );

    }

    public void Game(View view) {
        Intent intent=new Intent(this, games.class);
        startActivity( intent );

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }


    }

    public void quiz(View view) {
        Intent intent=new Intent(this, QuizCatalogue.class);
        startActivity( intent );

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }

    }

    public void Morag3a(View view) {

        Intent intent=new Intent(this, Morag3a.class);
        startActivity( intent );

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("هل تريد المغادرة ؟ ")
                .setCancelable(false)
                .setPositiveButton(" موافق ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton(" الغاء ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }



}
