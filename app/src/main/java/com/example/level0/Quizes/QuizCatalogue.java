package com.example.level0.Quizes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.level0.Quizes.Quiz1C;
import com.example.level0.Quizes.Quiz1T;
import com.example.level0.Quizes.Quiz2C;
import com.example.level0.Quizes.Quiz2T;
import com.example.level0.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class QuizCatalogue extends AppCompatActivity {

    private AdView mAdView,mAdView2,mAdView3;

    private InterstitialAd mInterstitialAd;

    private TextView textViewHighscore1t;
    private static final int REQUEST_CODE_QUIZ1t = 1;
    public static final String SHARED_PREFS1t = "sharedPrefs1t";
    public static final String KEY_HIGHSCORE1t = "keyHighscore1t";

    private TextView textViewHighscore1c;
    private static final int REQUEST_CODE_QUIZ1c = 2;
    public static final String SHARED_PREFS1c = "sharedPrefs1c";
    public static final String KEY_HIGHSCORE1c= "keyHighscore1c";

    private TextView textViewHighscore2t;
    private static final int REQUEST_CODE_QUIZ2t = 3;
    public static final String SHARED_PREFS2t = "sharedPrefs2t";
    public static final String KEY_HIGHSCORE2t = "keyHighscore2t";

    private TextView textViewHighscore2c;
    private static final int REQUEST_CODE_QUIZ2c = 4;
    public static final String SHARED_PREFS2c = "sharedPrefs2c";
    public static final String KEY_HIGHSCORE2c = "keyHighscore2c";


    public static int highscore1c;
    public static  int highscore1t;
    public static  int highscore2c;
    public static  int highscore2t;

    private Button quiz1t,quiz1c,quiz2t,quiz2c;
    private TextView textView7,bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_catalogue);

        Typeface typeface2=Typeface.createFromAsset( this.getAssets(),"a-massir-ballpoint.ttf" );

        quiz1t=findViewById(R.id.quiz1t);
        quiz1c=findViewById(R.id.quiz1c);
        quiz2t=findViewById(R.id.quiz2t);
        quiz2c=findViewById(R.id.quiz2c);
        textView7=findViewById(R.id.textView7);
        bt=findViewById(R.id.bt);


        quiz1t.setTypeface(typeface2);
        quiz1c.setTypeface(typeface2);
        quiz2t.setTypeface(typeface2);
        quiz2c.setTypeface(typeface2);
        textView7.setTypeface(typeface2);
        bt.setTypeface(typeface2);



        MobileAds.initialize(this, "ca-app-pub-9066719717930706~6805817120");

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView2 = findViewById(R.id.adViewquiz2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest2);


        mAdView3 = findViewById(R.id.adViewquiz3);
        AdRequest adRequest3 = new AdRequest.Builder().build();
        mAdView3.loadAd(adRequest3);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/5013023536");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);




        textViewHighscore1t = findViewById(R.id.hightscore1T);
        textViewHighscore1c = findViewById(R.id.hightscore1C);
        textViewHighscore2t = findViewById(R.id.hightscore2T);
        textViewHighscore2c = findViewById(R.id.hightscore2C);


        loadHighscore1t();
        loadHighscore1c();
        loadHighscore2t();
        loadHighscore2c();




    }

    public void quiz1c(View view) {
        Intent intent=new Intent(this, Quiz1C.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ1c);


        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }

    public void quiz1t(View view) {
        Intent intent=new Intent(this, Quiz1T.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ1t);

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }

    public void quiz2t(View view) {
        Intent intent=new Intent(this, Quiz2T.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ2t);

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }

    public void quiz2c(View view) {

        Intent intent=new Intent(this, Quiz2C.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ2c);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }






    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ1t) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(Quiz1T.EXTRA_SCORE1T, 0);
                if (score > highscore1t) {
                    updateHighscore1t(score);
                }
            }
        }


        else if (requestCode == REQUEST_CODE_QUIZ1c) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(Quiz1C.EXTRA_SCORE1C, 0);
                if (score > highscore1c) {
                    updateHighscore1c(score);
                }
            }
        }


        else if (requestCode == REQUEST_CODE_QUIZ2t) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(Quiz2T.EXTRA_SCORE2T, 0);
                if (score > highscore2t) {
                    updateHighscore2t(score);
                }
            }
        }


        else if (requestCode == REQUEST_CODE_QUIZ2c) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(Quiz2C.EXTRA_SCORE2C, 0);
                if (score > highscore2c) {
                    updateHighscore2c(score);
                }
            }
        }

        else {
            Toast.makeText(this, "error ", Toast.LENGTH_SHORT).show();
        }




    }

    private void loadHighscore1t() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS1t, MODE_PRIVATE);
        highscore1t = prefs.getInt(KEY_HIGHSCORE1t, 0);
        textViewHighscore1t.setText("HighScore: " + highscore1t+"/"+"14");
    }

    private void updateHighscore1t(int highscoreNew) {
        highscore1t = highscoreNew;
        textViewHighscore1t.setText("HighScore : " + highscore1t+"/"+"14");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS1t, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE1t, highscore1t);
        editor.apply();
    }



    private void loadHighscore1c() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS1c, MODE_PRIVATE);
        highscore1c = prefs.getInt(KEY_HIGHSCORE1c, 0);
        textViewHighscore1c.setText("HighScore: " + highscore1c+"/"+"26");
    }

    private void updateHighscore1c(int highscoreNew) {
        highscore1c = highscoreNew;
        textViewHighscore1c.setText("HighScore: " + highscore1c+"/"+"26");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS1c, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE1c, highscore1c);
        editor.apply();
    }



    private void loadHighscore2t() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS2t, MODE_PRIVATE);
        highscore2t = prefs.getInt(KEY_HIGHSCORE2t, 0);
        textViewHighscore2t.setText("HighScore: " + highscore2t+"/"+"13");
    }

    private void updateHighscore2t(int highscoreNew) {
        highscore2t = highscoreNew;
        textViewHighscore2t.setText("HighScore: " + highscore2t+"/"+"13");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS2t, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE2t, highscore2t);
        editor.apply();
    }


    private void loadHighscore2c() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS2c, MODE_PRIVATE);
        highscore2c = prefs.getInt(KEY_HIGHSCORE2c, 0);
        textViewHighscore2c.setText("HighScore: " + highscore2c+"/"+"22");
    }

    private void updateHighscore2c(int highscoreNew) {
        highscore2c = highscoreNew;
        textViewHighscore2c.setText("HighScore: " + highscore2c+"/"+"22");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS2c, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE2c, highscore2c);
        editor.apply();
    }

}
