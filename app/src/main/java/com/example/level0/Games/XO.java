package com.example.level0.Games;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.level0.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class XO extends AppCompatActivity implements View.OnClickListener  {

    private AdView mAdView;

    private Button[][] buttons=new Button[3][3];

    private boolean player1turn=true;

    private int roundcount;

    private int player1points;
    private int player2points;

    private TextView player1;
    private TextView player2;


    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xo);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        MobileAds.initialize(this, "ca-app-pub-9066719717930706~6805817120");

        mAdView = findViewById(R.id.adViewgames);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/5013023536");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        player1=findViewById(R.id.player1);
        player2=findViewById(R.id.player2);


        for (int i=0;i<3;i++){

            for(int j=0;j<3;j++){

                String buttonId="bt"+i+j;

                int resetId=getResources().getIdentifier(buttonId,"id",getPackageName());

                buttons[i][j]=findViewById(resetId);

                buttons[i][j].setOnClickListener(this);
            }

        }

        Typeface typeface2=Typeface.createFromAsset( this.getAssets(),"a-massir-ballpoint.ttf" );

        Button buttonResert=findViewById(R.id.reset);
        buttonResert.setTypeface(typeface2);
        buttonResert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                resetGame();

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }


            }
        });


    }
    @Override
    public void onClick(View v) {

        if( !((Button )v).getText().toString().equals("")){
            return;
        }

        if(player1turn){
            ((Button)v).setText("X");
            ((Button)v).setTextColor(Color.RED);



        }
        else {
            ((Button)v).setText("O");
            ((Button)v).setTextColor(Color.GREEN);



        }

        roundcount++;

        if(checkForWin()){
            if(player1turn){
                player1Wins();
            }
            else {
                player2Wins();
            }
        }
        else if (roundcount==9){
            draw();
        }
        else {
            player1turn=!player1turn;
        }
    }
    private boolean checkForWin(){

        String [][]field =new String[3][3];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                field[i][j]=buttons[i][j].getText().toString();
            }
        }
        for(int i=0;i<3;i++){
            if(field[i][0].equals(field[i][1])   &&    field[i][0].equals(field[i][2])   &&   !field[i][0].equals("")) {
                return true;
            }
        }

        for(int i=0;i<3;i++){
            if(field[0][i].equals(field[1][i])   &&    field[0][i].equals(field[2][i])   &&   !field[0][i].equals("")) {
                return true;
            }
        }

        if(field[0][0].equals(field[1][1])   &&    field[0][0].equals(field[2][2])   &&   !field[0][0].equals("")) {
            return true;
        }

        return field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].equals("");
    }

    private void player1Wins(){

        player1points++;
        Toast.makeText(this, "  X  the Winner !!", Toast.LENGTH_SHORT).show();
        updatepointText();
        resetBoard();
    }
    private void player2Wins(){
        player2points++;
        Toast.makeText(this, " O  the Winner !!", Toast.LENGTH_SHORT).show();
        updatepointText();
        resetBoard();
    }
    private void draw(){
        Toast.makeText(this, "تـعـادل", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatepointText(){

        player1.setText("  X  :  "+player1points);
        player2.setText("  O  :  "+player2points);

    }
    private void resetBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                buttons[i][j].setText("");
            }
        }

        roundcount=0;
        player1turn=true;

    }

    private void resetGame(){

        player1points=0;
        player2points=0;

        updatepointText();
        resetBoard();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundcount",roundcount);
        outState.putInt("player1points",player1points);
        outState.putInt("player2points",player2points);
        outState.putBoolean("player1turn",player1turn);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        roundcount=savedInstanceState.getInt("roundcount");
        player1points=savedInstanceState.getInt("player1points");
        player2points=savedInstanceState.getInt("player2points");
        player1turn=savedInstanceState.getBoolean("player1turn");

    }
}
