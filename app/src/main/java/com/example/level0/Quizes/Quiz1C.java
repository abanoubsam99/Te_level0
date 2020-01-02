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

public class Quiz1C extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    public static final String EXTRA_SCORE1C = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS1C  = 20000;

    private static final String KEY_SCORE1C  = "keyScore";
    private static final String KEY_QUESTION_COUNT1C  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFT1C  = "keyMillisLeft";
    private static final String KEY_ANSWERED1C  = "keyAnswered";
    private static final String KEY_QUESTION_LIST1C  = "keyQuestionList";

    private TextView textViewQuestion1C ;
    private TextView textViewScore1C ;
    private TextView textViewQuestionCount1C ;
    private TextView textViewCountDown1C ;
    private RadioGroup rbGroup1C ;
    private RadioButton rb11C ;
    private RadioButton rb21C ;
    private RadioButton rb31C ;
    private Button buttonConfirmNext1C ;

    private ColorStateList textColorDefaultRb1C ;
    private ColorStateList textColorDefaultCd1C ;

    private CountDownTimer countDownTimer1C ;
    private long timeLeftInMillis1C ;

    private ArrayList<Questions> questionList1C ;
    private int questionCounter1C ;
    private int questionCountTotal1C ;
    private Questions currentQuestion1C ;

    private int score1C ;
    private boolean answered1C ;

    private long backPressedTime1C ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1_c);

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


        textViewQuestion1C = findViewById(R.id.text_view_question1C);
        textViewScore1C = findViewById(R.id.text_view_score1C);
        textViewQuestionCount1C = findViewById(R.id.text_view_question_count1C);
        textViewCountDown1C = findViewById(R.id.text_view_countdown1C);
        rbGroup1C = findViewById(R.id.radio_group1C);
        rb11C = findViewById(R.id.radio_button11C);
        rb11C.setTypeface( typeface );
        rb21C = findViewById(R.id.radio_button21C);
        rb21C.setTypeface( typeface );
        rb31C= findViewById(R.id.radio_button31C);
        rb31C.setTypeface( typeface );
        buttonConfirmNext1C = findViewById(R.id.button_confirm_next1C);
        buttonConfirmNext1C.setTypeface(typeface2);

        textColorDefaultRb1C = rb11C.getTextColors();
        textColorDefaultCd1C = textViewCountDown1C.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionList1C = dbHelper.getAllQuestions1C();
            questionCountTotal1C = questionList1C.size();
            Collections.shuffle(questionList1C);

            showNextQuestion();
        } else {
            questionList1C = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST1C);
            questionCountTotal1C = questionList1C.size();
            questionCounter1C = savedInstanceState.getInt(KEY_QUESTION_COUNT1C);
            currentQuestion1C = questionList1C.get(questionCounter1C - 1);
            score1C = savedInstanceState.getInt(KEY_SCORE1C);
            timeLeftInMillis1C = savedInstanceState.getLong(KEY_MILLIS_LEFT1C);
            answered1C = savedInstanceState.getBoolean(KEY_ANSWERED1C);

            if (!answered1C) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNext1C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered1C) {
                    if (rb11C.isChecked() || rb21C.isChecked() || rb31C.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(Quiz1C.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb11C.setTextColor(textColorDefaultRb1C);
        rb21C.setTextColor(textColorDefaultRb1C);
        rb31C.setTextColor(textColorDefaultRb1C);
        rbGroup1C.clearCheck();

        if (questionCounter1C < questionCountTotal1C) {
            currentQuestion1C = questionList1C.get(questionCounter1C);

            textViewQuestion1C.setText(currentQuestion1C.getQuestion1C());
            rb11C.setText(currentQuestion1C.getOption11C());
            rb21C.setText(currentQuestion1C.getOption21C());
            rb31C.setText(currentQuestion1C.getOption31C());

            questionCounter1C++;
            textViewQuestionCount1C.setText("Question: " + questionCounter1C + "/" + questionCountTotal1C);
            answered1C = false;
            buttonConfirmNext1C.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillis1C = COUNTDOWN_IN_MILLIS1C;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimer1C = new CountDownTimer(timeLeftInMillis1C, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis1C = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis1C = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis1C / 1000) / 60;
        int seconds = (int) (timeLeftInMillis1C / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown1C.setText(timeFormatted);

        if (timeLeftInMillis1C < 10000) {
            textViewCountDown1C.setTextColor(Color.RED);
        } else {
            textViewCountDown1C.setTextColor(textColorDefaultCd1C);
        }
    }

    private void checkAnswer() {
        answered1C = true;

        countDownTimer1C.cancel();

        RadioButton rbSelected = findViewById(rbGroup1C.getCheckedRadioButtonId());
        int answerNr = rbGroup1C.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion1C.getAnswerNr1C()) {
            score1C++;
            textViewScore1C.setText("Score: " + score1C);
        }

        showSolution();
    }

    private void showSolution() {
        rb11C.setTextColor(Color.RED);
        rb21C.setTextColor(Color.RED);
        rb31C.setTextColor(Color.RED);

        switch (currentQuestion1C.getAnswerNr1C()) {
            case 1:
                rb11C.setTextColor(Color.GREEN);
                break;
            case 2:
                rb21C.setTextColor(Color.GREEN);
                break;
            case 3:
                rb31C.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounter1C < questionCountTotal1C) {
            buttonConfirmNext1C.setText("التالي ");
        } else {
            buttonConfirmNext1C.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE1C, score1C);
        setResult(RESULT_OK, resultIntent);

        AlertDialog.Builder alert=new AlertDialog.Builder(Quiz1C.this);
        alert.setMessage( " الدرجة  : "+score1C+"/"+"25"+"\nاعلي درجة  : "+QuizCatalogue.highscore1c+"/"+"25")
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
        if (backPressedTime1C + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTime1C = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer1C != null) {
            countDownTimer1C.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE1C, score1C);
        outState.putInt(KEY_QUESTION_COUNT1C, questionCounter1C);
        outState.putLong(KEY_MILLIS_LEFT1C, timeLeftInMillis1C);
        outState.putBoolean(KEY_ANSWERED1C, answered1C);
        outState.putParcelableArrayList(KEY_QUESTION_LIST1C, questionList1C);
    }
}
