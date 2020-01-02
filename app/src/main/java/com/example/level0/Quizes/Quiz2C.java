package com.example.level0.Quizes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.level0.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Quiz2C extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    public static final String EXTRA_SCORE2C = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS2C  = 20000;

    private static final String KEY_SCORE2C  = "keyScore";
    private static final String KEY_QUESTION_COUNT2C  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFT2C  = "keyMillisLeft";
    private static final String KEY_ANSWERED2C  = "keyAnswered";
    private static final String KEY_QUESTION_LIST2C  = "keyQuestionList";

    private TextView textViewQuestion2C ;
    private TextView textViewScore2C ;
    private TextView textViewQuestionCount2C ;
    private TextView textViewCountDown2C ;
    private RadioGroup rbGroup2C ;
    private RadioButton rb12C ;
    private RadioButton rb22C ;
    private RadioButton rb32C ;
    private Button buttonConfirmNext2C ;

    private ColorStateList textColorDefaultRb2C ;
    private ColorStateList textColorDefaultCd2C ;

    private CountDownTimer countDownTimer2C ;
    private long timeLeftInMillis2C ;

    private ArrayList<Questions2C> questionList2C ;
    private int questionCounter2C ;
    private int questionCountTotal2C ;
    private Questions2C currentQuestion2C ;

    private int score2C ;
    private boolean answered2C ;

    private long backPressedTime2C ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2_c);


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Typeface typeface=Typeface.createFromAsset( this.getAssets(),"Avva_Shenouda.ttf" );
        Typeface typeface2=Typeface.createFromAsset( this.getAssets(),"a-massir-ballpoint.ttf" );

        MobileAds.initialize(this, "ca-app-pub-9066719717930706~6805817120");

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/5013023536");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        textViewQuestion2C = findViewById(R.id.text_view_question2C);
        textViewQuestion2C.setTypeface( typeface );
        textViewScore2C = findViewById(R.id.text_view_score2C);
        textViewQuestionCount2C = findViewById(R.id.text_view_question_count2C);
        textViewCountDown2C = findViewById(R.id.text_view_countdown2C);
        rbGroup2C = findViewById(R.id.radio_group2C);
        rb12C = findViewById(R.id.radio_button12C);
        rb12C.setTypeface( typeface );
        rb22C = findViewById(R.id.radio_button22C);
        rb22C.setTypeface( typeface );
        rb32C= findViewById(R.id.radio_button32C);
        rb32C.setTypeface( typeface );
        buttonConfirmNext2C = findViewById(R.id.button_confirm_next2C);
        buttonConfirmNext2C.setTypeface(typeface2);

        textColorDefaultRb2C = rb12C.getTextColors();
        textColorDefaultCd2C = textViewCountDown2C.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionList2C = dbHelper.getAllQuestions2C();
            questionCountTotal2C = questionList2C.size();
            Collections.shuffle(questionList2C);

            showNextQuestion();
        } else {
            questionList2C = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST2C);
            questionCountTotal2C = questionList2C.size();
            questionCounter2C = savedInstanceState.getInt(KEY_QUESTION_COUNT2C);
            currentQuestion2C = questionList2C.get(questionCounter2C - 1);
            score2C = savedInstanceState.getInt(KEY_SCORE2C);
            timeLeftInMillis2C = savedInstanceState.getLong(KEY_MILLIS_LEFT2C);
            answered2C = savedInstanceState.getBoolean(KEY_ANSWERED2C);

            if (!answered2C) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNext2C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered2C) {
                    if (rb12C.isChecked() || rb22C.isChecked() || rb32C.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(Quiz2C.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb12C.setTextColor(textColorDefaultRb2C);
        rb22C.setTextColor(textColorDefaultRb2C);
        rb32C.setTextColor(textColorDefaultRb2C);
        rbGroup2C.clearCheck();



        if (questionCounter2C < questionCountTotal2C) {
            currentQuestion2C = questionList2C.get(questionCounter2C);

            textViewQuestion2C.setText(currentQuestion2C.getQuestion2C());
            rb12C.setText(currentQuestion2C.getOption12C());
            rb22C.setText(currentQuestion2C.getOption22C());
            rb32C.setText(currentQuestion2C.getOption32C());

            questionCounter2C++;
            textViewQuestionCount2C.setText("Question: " + questionCounter2C + "/" + questionCountTotal2C);
            answered2C = false;
            buttonConfirmNext2C.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillis2C = COUNTDOWN_IN_MILLIS2C;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimer2C = new CountDownTimer(timeLeftInMillis2C, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis2C = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis2C = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis2C / 1000) / 60;
        int seconds = (int) (timeLeftInMillis2C / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown2C.setText(timeFormatted);

        if (timeLeftInMillis2C < 10000) {
            textViewCountDown2C.setTextColor(Color.RED);
        } else {
            textViewCountDown2C.setTextColor(textColorDefaultCd2C);
        }
    }

    private void checkAnswer() {
        answered2C = true;

        countDownTimer2C.cancel();

        RadioButton rbSelected = findViewById(rbGroup2C.getCheckedRadioButtonId());
        int answerNr = rbGroup2C.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion2C.getAnswerNr2C()) {
            score2C++;
            textViewScore2C.setText("Score: " + score2C);
        }

        showSolution();
    }

    private void showSolution() {
        rb12C.setTextColor(Color.RED);
        rb22C.setTextColor(Color.RED);
        rb32C.setTextColor(Color.RED);


        switch (currentQuestion2C.getAnswerNr2C()) {
            case 1:
                rb12C.setTextColor(Color.GREEN);
                break;
            case 2:
                rb22C.setTextColor(Color.GREEN);
                break;
            case 3:
                rb32C.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounter2C < questionCountTotal2C) {
            buttonConfirmNext2C.setText("التالي ");
        } else {
            buttonConfirmNext2C.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE2C, score2C);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(Quiz2C.this);
        alert.setMessage( " الدرجة  : "+score2C+"/"+"22"+"\nاعلي درجة  : "+QuizCatalogue.highscore2c+"/"+"22")
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),Quiz1C.class);
                        startActivity(intent);
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }
                        finish();
                    }
                })
                .setNegativeButton("الذهاب للصفحة الرئيسية ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

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

    @Override
    public void onBackPressed() {
        if (backPressedTime2C + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTime2C = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer2C != null) {
            countDownTimer2C.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE2C, score2C);
        outState.putInt(KEY_QUESTION_COUNT2C, questionCounter2C);
        outState.putLong(KEY_MILLIS_LEFT2C, timeLeftInMillis2C);
        outState.putBoolean(KEY_ANSWERED2C, answered2C);
        outState.putParcelableArrayList(KEY_QUESTION_LIST2C, questionList2C);
    }
}

