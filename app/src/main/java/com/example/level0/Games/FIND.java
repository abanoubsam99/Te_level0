package com.example.level0.Games;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.level0.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Arrays;
import java.util.Collections;

public class FIND extends AppCompatActivity {

    TextView p1,p2;

    ImageView im11,im12,im13,im14,im21,im22,im23,im24,im31,im32,im33,im34;

    //array for images
    Integer[] cardArray={101,102,103,104,105,106,201,202,203,204,205,206};

    //actual images

    int img101,img102,img103,img104,img105,img106
            ,img201,img202,img203,img204,img205,img206;

    int firstCard ,SecondCard;
    int ClickFirst,ClickSecond;
    int CardNumber=1;

    int turn =1;
    int playerPoint=0  ,  CupPoint=0;


    private AdView mAdView;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        MobileAds.initialize(this, "ca-app-pub-9066719717930706~6805817120");

        mAdView = findViewById(R.id.adViewgames);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/5013023536");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());




        p1=findViewById(R.id.p1);
        p2=findViewById(R.id.p2);

        im11=findViewById(R.id.im11);
        im12=findViewById(R.id.im12);
        im13=findViewById(R.id.im13);
        im14=findViewById(R.id.im14);
        im21=findViewById(R.id.im21);
        im22=findViewById(R.id.im22);
        im23=findViewById(R.id.im23);
        im24=findViewById(R.id.im24);
        im31=findViewById(R.id.im31);
        im32=findViewById(R.id.im32);
        im33=findViewById(R.id.im33);
        im34=findViewById(R.id.im34);


        im11.setTag("0");
        im12.setTag("1");
        im13.setTag("2");
        im14.setTag("3");
        im21.setTag("4");
        im22.setTag("5");
        im23.setTag("6");
        im24.setTag("7");
        im31.setTag("8");
        im32.setTag("9");
        im33.setTag("10");
        im34.setTag("11");

        //load the card image
        frontOfCardResourses();

        Collections.shuffle(Arrays.asList(cardArray));

        //Changing the color of the Second Player
        p2.setTextColor(Color.GRAY);


        im11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int thecard=Integer.parseInt((String)view.getTag());
                doSuff(im11,thecard);
            }
        });

        im12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int thecard=Integer.parseInt((String)view.getTag());
                doSuff(im12,thecard);
            }
        });

        im13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int thecard=Integer.parseInt((String)view.getTag());
                doSuff(im13,thecard);
            }
        });

        im14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int thecard=Integer.parseInt((String)view.getTag());
                doSuff(im14,thecard);
            }
        });

        im21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int thecard=Integer.parseInt((String)view.getTag());
                doSuff(im21,thecard);
            }
        });

        im22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int thecard=Integer.parseInt((String)view.getTag());
                doSuff(im22,thecard);
            }
        });

        im23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int thecard=Integer.parseInt((String)view.getTag());
                doSuff(im23,thecard);
            }
        });

        im24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int thecard=Integer.parseInt((String)view.getTag());
                doSuff(im24,thecard);
            }
        });

        im31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int thecard=Integer.parseInt((String)view.getTag());
                doSuff(im31,thecard);
            }
        });

        im32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int thecard=Integer.parseInt((String)view.getTag());
                doSuff(im32,thecard);
            }
        });


        im33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int thecard=Integer.parseInt((String)view.getTag());
                doSuff(im33,thecard);
            }
        });


        im34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int thecard=Integer.parseInt((String)view.getTag());
                doSuff(im34,thecard);
            }
        });

    }

    private void doSuff(ImageView im,int card){
        //set the correct image to imageview
        if(cardArray[card]==101){
            im.setImageResource(img101);
        }
        else  if(cardArray[card]==102){
            im.setImageResource(img102);
        }
        else  if(cardArray[card]==103){
            im.setImageResource(img103);
        }
        else  if(cardArray[card]==104){
            im.setImageResource(img104);
        }
        else  if(cardArray[card]==105){
            im.setImageResource(img105);
        }
        else  if(cardArray[card]==106){
            im.setImageResource(img106);
        }
        else  if(cardArray[card]==201){
            im.setImageResource(img201);
        }
        else  if(cardArray[card]==202){
            im.setImageResource(img202);
        }
        else  if(cardArray[card]==203){
            im.setImageResource(img203);
        }
        else  if(cardArray[card]==204){
            im.setImageResource(img204);
        }
        else  if(cardArray[card]==205){
            im.setImageResource(img205);
        }
        else  if(cardArray[card]==206){
            im.setImageResource(img206);
        }


        // Check which image is selected  and save it to temporary variable

        if(CardNumber==1){
            firstCard=cardArray[card];
            if(firstCard>200){
                firstCard=firstCard-100;
            }
            CardNumber=2;
            ClickFirst=card;

            im.setEnabled(false);
        }
        else if(CardNumber==2){
            SecondCard=cardArray[card];
            if(SecondCard>200){
                SecondCard=SecondCard-100;
            }
            CardNumber=1;
            ClickSecond=card;

            im11.setEnabled(false);
            im12.setEnabled(false);
            im13.setEnabled(false);
            im14.setEnabled(false);
            im21.setEnabled(false);
            im22.setEnabled(false);
            im23.setEnabled(false);
            im24.setEnabled(false);
            im31.setEnabled(false);
            im32.setEnabled(false);
            im33.setEnabled(false);
            im34.setEnabled(false);

            Handler handler =new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //chick if the selected images are equale
                    Calculat();
                }
            },1000);

        }


    }

    private void Calculat(){
        //if images are equale remove it and add point

        if(firstCard==SecondCard){
            if(ClickFirst==0){
                im11.setVisibility(View.INVISIBLE);
            }
            else  if(ClickFirst==1){
                im12.setVisibility(View.INVISIBLE);
            }
            else  if(ClickFirst==2){
                im13.setVisibility(View.INVISIBLE);
            }
            else  if(ClickFirst==3){
                im14.setVisibility(View.INVISIBLE);
            }
            else  if(ClickFirst==4){
                im21.setVisibility(View.INVISIBLE);
            }
            else  if(ClickFirst==5){
                im22.setVisibility(View.INVISIBLE);
            }
            else  if(ClickFirst==6){
                im23.setVisibility(View.INVISIBLE);
            }
            else  if(ClickFirst==7){
                im24.setVisibility(View.INVISIBLE);
            }
            else  if(ClickFirst==8){
                im31.setVisibility(View.INVISIBLE);
            }
            else  if(ClickFirst==9){
                im32.setVisibility(View.INVISIBLE);
            }
            else  if(ClickFirst==10){
                im33.setVisibility(View.INVISIBLE);
            }
            else  if(ClickFirst==11){
                im34.setVisibility(View.INVISIBLE);
            }


            if(ClickSecond==0){
                im11.setVisibility(View.INVISIBLE);
            }
            else  if(ClickSecond==1){
                im12.setVisibility(View.INVISIBLE);
            }
            else  if(ClickSecond==2){
                im13.setVisibility(View.INVISIBLE);
            }
            else  if(ClickSecond==3){
                im14.setVisibility(View.INVISIBLE);
            }
            else  if(ClickSecond==4){
                im21.setVisibility(View.INVISIBLE);
            }
            else  if(ClickSecond==5){
                im22.setVisibility(View.INVISIBLE);
            }
            else  if(ClickSecond==6){
                im23.setVisibility(View.INVISIBLE);
            }
            else  if(ClickSecond==7){
                im24.setVisibility(View.INVISIBLE);
            }
            else  if(ClickSecond==8){
                im31.setVisibility(View.INVISIBLE);
            }
            else  if(ClickSecond==9){
                im32.setVisibility(View.INVISIBLE);
            }
            else  if(ClickSecond==10){
                im33.setVisibility(View.INVISIBLE);
            }
            else  if(ClickSecond==11){
                im34.setVisibility(View.INVISIBLE);
            }

            // add point
            if(turn==1){
                playerPoint++;
                p1.setText("player1 : "+playerPoint);
            }else if(turn==2){
                CupPoint++;
                p2.setText("Player2 : "+CupPoint);
            }
        }
        else {
            im11.setImageResource(R.drawable.logo0);
            im12.setImageResource(R.drawable.logo0);
            im13.setImageResource(R.drawable.logo0);
            im14.setImageResource(R.drawable.logo0);
            im21.setImageResource(R.drawable.logo0);
            im22.setImageResource(R.drawable.logo0);
            im23.setImageResource(R.drawable.logo0);
            im24.setImageResource(R.drawable.logo0);
            im31.setImageResource(R.drawable.logo0);
            im32.setImageResource(R.drawable.logo0);
            im33.setImageResource(R.drawable.logo0);
            im34.setImageResource(R.drawable.logo0);

            //change the player
            if(turn==1){
                turn=2;
                p1.setTextColor(Color.GRAY);
                p2.setTextColor(Color.RED);
            }else   if(turn==2){
                turn=1;
                p2.setTextColor(Color.GRAY);
                p1.setTextColor(Color.GREEN);
            }
        }
        im11.setEnabled(true);
        im12.setEnabled(true);
        im13.setEnabled(true);
        im14.setEnabled(true);
        im21.setEnabled(true);
        im22.setEnabled(true);
        im23.setEnabled(true);
        im24.setEnabled(true);
        im31.setEnabled(true);
        im32.setEnabled(true);
        im33.setEnabled(true);
        im34.setEnabled(true);

        //check if the game is end
        checkend();
    }

    private void  checkend(){
        if(im11.getVisibility()==View.INVISIBLE &&
                im12.getVisibility()==View.INVISIBLE &&
                im13.getVisibility()==View.INVISIBLE &&
                im14.getVisibility()==View.INVISIBLE &&
                im21.getVisibility()==View.INVISIBLE &&
                im22.getVisibility()==View.INVISIBLE &&
                im23.getVisibility()==View.INVISIBLE &&
                im24.getVisibility()==View.INVISIBLE &&
                im31.getVisibility()==View.INVISIBLE &&
                im32.getVisibility()==View.INVISIBLE &&
                im33.getVisibility()==View.INVISIBLE &&
                im34.getVisibility()==View.INVISIBLE )
        {

            AlertDialog.Builder alert=new AlertDialog.Builder(FIND.this);
            alert.setMessage( " GAME OVER\nplayer1 : "+playerPoint+"\nPlayer2 : "+CupPoint)
                    .setCancelable(false)
                    .setPositiveButton("اللعب مرة اخري", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent=new Intent(getApplicationContext(),FIND.class);
                            startActivity(intent);
                            if (mInterstitialAd.isLoaded()) {
                                mInterstitialAd.show();
                            } else {
                                Log.d("TAG", "The interstitial wasn't loaded yet.");
                            }


                            finish();

                        }
                    })
                    .setNegativeButton("الذهاب لصفحة الالعاب ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent=new Intent(getApplicationContext(), games.class);
                            startActivity(intent);
                            if (mInterstitialAd.isLoaded()) {
                                mInterstitialAd.show();
                            } else {
                                Log.d("TAG", "The interstitial wasn't loaded yet.");
                            }

                            finish();
                        }
                    });

            AlertDialog alertDialog=alert.create();
            alertDialog.show();

        }
    }


    private void frontOfCardResourses(){
        img101=R.drawable.index;
        img102=R.drawable.index2;
        img103=R.drawable.index3;
        img104=R.drawable.index4;
        img105=R.drawable.index5;
        img106=R.drawable.index6;
        img201=R.drawable.index11;
        img202=R.drawable.index22;
        img203=R.drawable.index33;
        img204=R.drawable.index44;
        img205=R.drawable.index55;
        img206=R.drawable.index66;

    }
}
