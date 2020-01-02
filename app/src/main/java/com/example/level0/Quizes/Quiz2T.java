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

public class Quiz2T extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    public static final String EXTRA_SCORE2T = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS2T  = 20000;

    private static final String KEY_SCORE2T  = "keyScore";
    private static final String KEY_QUESTION_COUNT2T  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFT2T  = "keyMillisLeft";
    private static final String KEY_ANSWERED2T  = "keyAnswered";
    private static final String KEY_QUESTION_LIST2T  = "keyQuestionList";

    private TextView textViewQuestion2T ;
    private TextView textViewScore2T;
    private TextView textViewQuestionCount2T ;
    private TextView textViewCountDown2T ;
    private RadioGroup rbGroup2T ;
    private RadioButton rb12T ;
    private RadioButton rb22T ;
    private RadioButton rb32T ;
    private Button buttonConfirmNext2T ;

    private ColorStateList textColorDefaultRb2T ;
    private ColorStateList textColorDefaultCd2T ;

    private CountDownTimer countDownTimer2T ;
    private long timeLeftInMillis2T ;

    private ArrayList<Questions2T> questionList2T ;
    private int questionCounter2T;
    private int questionCountTotal2T;
    private Questions2T currentQuestion2T ;

    private int score2T ;
    private boolean answered2T ;

    private long backPressedTime2T ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2_t);


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~6805817120");
        Typeface typeface2=Typeface.createFromAsset( this.getAssets(),"a-massir-ballpoint.ttf" );

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/5013023536");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        textViewQuestion2T = findViewById(R.id.text_view_question2T);
        textViewScore2T = findViewById(R.id.text_view_score2T);
        textViewQuestionCount2T = findViewById(R.id.text_view_question_count2T);
        textViewCountDown2T = findViewById(R.id.text_view_countdown2T);
        rbGroup2T = findViewById(R.id.radio_group2T);
        rb12T = findViewById(R.id.radio_button12T);
        rb22T = findViewById(R.id.radio_button22T);
        rb32T= findViewById(R.id.radio_button32T);
        buttonConfirmNext2T = findViewById(R.id.button_confirm_next2T);
        buttonConfirmNext2T.setTypeface(typeface2);

        textColorDefaultRb2T = rb12T.getTextColors();
        textColorDefaultCd2T = textViewCountDown2T.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionList2T = dbHelper.getAllQuestions2T();
            questionCountTotal2T = questionList2T.size();
            Collections.shuffle(questionList2T);

            showNextQuestion();
        } else {
            questionList2T = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST2T);
            questionCountTotal2T = questionList2T.size();
            questionCounter2T = savedInstanceState.getInt(KEY_QUESTION_COUNT2T);
            currentQuestion2T = questionList2T.get(questionCounter2T - 1);
            score2T = savedInstanceState.getInt(KEY_SCORE2T);
            timeLeftInMillis2T = savedInstanceState.getLong(KEY_MILLIS_LEFT2T);
            answered2T = savedInstanceState.getBoolean(KEY_ANSWERED2T);

            if (!answered2T) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNext2T.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered2T) {
                    if (rb12T.isChecked() || rb22T.isChecked() || rb32T.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(Quiz2T.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb12T.setTextColor(textColorDefaultRb2T);
        rb22T.setTextColor(textColorDefaultRb2T);
        rb32T.setTextColor(textColorDefaultRb2T);
        rbGroup2T.clearCheck();




        if (questionCounter2T < questionCountTotal2T) {
            currentQuestion2T = questionList2T.get(questionCounter2T);

            textViewQuestion2T.setText(currentQuestion2T.getQuestion2T());
            rb12T.setText(currentQuestion2T.getOption12T());
            rb22T.setText(currentQuestion2T.getOption22T());
            rb32T.setText(currentQuestion2T.getOption32TC());

            questionCounter2T++;
            textViewQuestionCount2T.setText("Question: " + questionCounter2T + "/" + questionCountTotal2T);
            answered2T = false;
            buttonConfirmNext2T.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillis2T = COUNTDOWN_IN_MILLIS2T;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimer2T = new CountDownTimer(timeLeftInMillis2T, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis2T = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis2T = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis2T / 1000) / 60;
        int seconds = (int) (timeLeftInMillis2T / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown2T.setText(timeFormatted);

        if (timeLeftInMillis2T < 10000) {
            textViewCountDown2T.setTextColor(Color.RED);
        } else {
            textViewCountDown2T.setTextColor(textColorDefaultCd2T);
        }
    }

    private void checkAnswer() {
        answered2T = true;

        countDownTimer2T.cancel();

        RadioButton rbSelected = findViewById(rbGroup2T.getCheckedRadioButtonId());
        int answerNr = rbGroup2T.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion2T.getAnswerNr2T()) {
            score2T++;
            textViewScore2T.setText("Score: " + score2T);
        }

        showSolution();
    }

    private void showSolution() {
        rb12T.setTextColor(Color.RED);
        rb22T.setTextColor(Color.RED);
        rb32T.setTextColor(Color.RED);

        switch (currentQuestion2T.getAnswerNr2T()) {
            case 1:
                rb12T.setTextColor(Color.GREEN);
                break;
            case 2:
                rb22T.setTextColor(Color.GREEN);
                break;
            case 3:
                rb32T.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounter2T < questionCountTotal2T) {
            buttonConfirmNext2T.setText("التالي ");
        } else {
            buttonConfirmNext2T.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE2T, score2T);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(Quiz2T.this);
        alert.setMessage( " الدرجة  : "+score2T+"/"+"13"+"\nاعلي درجة  : "+QuizCatalogue.highscore2t+"/"+"13")
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
        alertDialog.show();    }

    @Override
    public void onBackPressed() {
        if (backPressedTime2T + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTime2T = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer2T != null) {
            countDownTimer2T.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE2T, score2T);
        outState.putInt(KEY_QUESTION_COUNT2T, questionCounter2T);
        outState.putLong(KEY_MILLIS_LEFT2T, timeLeftInMillis2T);
        outState.putBoolean(KEY_ANSWERED2T, answered2T);
        outState.putParcelableArrayList(KEY_QUESTION_LIST2T, questionList2T);
    }
}
