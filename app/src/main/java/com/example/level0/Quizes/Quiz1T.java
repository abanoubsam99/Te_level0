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

public class Quiz1T extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    public static final String EXTRA_SCORE1T = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS1T  = 20000;

    private static final String KEY_SCORE1T  = "keyScore";
    private static final String KEY_QUESTION_COUNT1T  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFT1T  = "keyMillisLeft";
    private static final String KEY_ANSWERED1T  = "keyAnswered";
    private static final String KEY_QUESTION_LIST1T  = "keyQuestionList";

    private TextView textViewQuestion1T ;
    private TextView textViewScore1T ;
    private TextView textViewQuestionCount1T ;
    private TextView textViewCountDown1T ;
    private RadioGroup rbGroup1T ;
    private RadioButton rb11T ;
    private RadioButton rb21T ;
    private RadioButton rb31T ;
    private Button buttonConfirmNext1T ;

    private ColorStateList textColorDefaultRb1T ;
    private ColorStateList textColorDefaultCd1T ;

    private CountDownTimer countDownTimer1T ;
    private long timeLeftInMillis1T ;

    private ArrayList<Questions1T> questionList1T ;
    private int questionCounter1T ;
    private int questionCountTotal1T ;
    private Questions1T currentQuestion1T ;

    private int score1T ;
    private boolean answered1T ;

    private long backPressedTime1T ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1_t);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~6805817120");
        Typeface typeface2=Typeface.createFromAsset( this.getAssets(),"a-massir-ballpoint.ttf" );

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/5013023536");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        textViewQuestion1T = findViewById(R.id.text_view_question1T);
        textViewScore1T = findViewById(R.id.text_view_score1T);
        textViewQuestionCount1T = findViewById(R.id.text_view_question_count1T);
        textViewCountDown1T = findViewById(R.id.text_view_countdown1T);
        rbGroup1T = findViewById(R.id.radio_group1T);
        rb11T = findViewById(R.id.radio_button11T);
        rb21T = findViewById(R.id.radio_button21T);
        rb31T= findViewById(R.id.radio_button31T);
        buttonConfirmNext1T = findViewById(R.id.button_confirm_next1T);
        buttonConfirmNext1T.setTypeface(typeface2);

        textColorDefaultRb1T = rb11T.getTextColors();
        textColorDefaultCd1T = textViewCountDown1T.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionList1T = dbHelper.getAllQuestions1T();
            questionCountTotal1T = questionList1T.size();
            Collections.shuffle(questionList1T);

            showNextQuestion();
        } else {
            questionList1T = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST1T);
            questionCountTotal1T = questionList1T.size();
            questionCounter1T = savedInstanceState.getInt(KEY_QUESTION_COUNT1T);
            currentQuestion1T = questionList1T.get(questionCounter1T - 1);
            score1T = savedInstanceState.getInt(KEY_SCORE1T);
            timeLeftInMillis1T = savedInstanceState.getLong(KEY_MILLIS_LEFT1T);
            answered1T = savedInstanceState.getBoolean(KEY_ANSWERED1T);

            if (!answered1T) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNext1T.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered1T) {
                    if (rb11T.isChecked() || rb21T.isChecked() || rb31T.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(Quiz1T.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb11T.setTextColor(textColorDefaultRb1T);
        rb21T.setTextColor(textColorDefaultRb1T);
        rb31T.setTextColor(textColorDefaultRb1T);
        rbGroup1T.clearCheck();


        if (questionCounter1T < questionCountTotal1T) {
            currentQuestion1T = questionList1T.get(questionCounter1T);

            textViewQuestion1T.setText(currentQuestion1T.getQuestion1T());
            rb11T.setText(currentQuestion1T.getOption11T());
            rb21T.setText(currentQuestion1T.getOption21T());
            rb31T.setText(currentQuestion1T.getOption31T());

            questionCounter1T++;
            textViewQuestionCount1T.setText("Question: " + questionCounter1T + "/" + questionCountTotal1T);
            answered1T = false;
            buttonConfirmNext1T.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillis1T = COUNTDOWN_IN_MILLIS1T;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimer1T = new CountDownTimer(timeLeftInMillis1T, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis1T = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis1T = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis1T / 1000) / 60;
        int seconds = (int) (timeLeftInMillis1T / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown1T.setText(timeFormatted);

        if (timeLeftInMillis1T < 10000) {
            textViewCountDown1T.setTextColor(Color.RED);
        } else {
            textViewCountDown1T.setTextColor(textColorDefaultCd1T);
        }
    }

    private void checkAnswer() {
        answered1T = true;

        countDownTimer1T.cancel();

        RadioButton rbSelected = findViewById(rbGroup1T.getCheckedRadioButtonId());
        int answerNr = rbGroup1T.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion1T.getAnswerNr1T()) {
            score1T++;
            textViewScore1T.setText("Score: " + score1T);
        }

        showSolution();
    }

    private void showSolution() {
        rb11T.setTextColor(Color.RED);
        rb21T.setTextColor(Color.RED);
        rb31T.setTextColor(Color.RED);


        switch (currentQuestion1T.getAnswerNr1T()) {
            case 1:
                rb11T.setTextColor(Color.GREEN);
                break;
            case 2:
                rb21T.setTextColor(Color.GREEN);
                break;
            case 3:
                rb31T.setTextColor(Color.GREEN);
                break;
        }


        if (questionCounter1T < questionCountTotal1T) {
            buttonConfirmNext1T.setText("التالي ");
        } else {
            buttonConfirmNext1T.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE1T, score1T);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(Quiz1T.this);
        alert.setMessage( " الدرجة  : "+score1T+"/"+"14"+"\nاعلي درجة  : "+QuizCatalogue.highscore1t+"/"+"14")
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
        if (backPressedTime1T + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTime1T = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer1T != null) {
            countDownTimer1T.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE1T, score1T);
        outState.putInt(KEY_QUESTION_COUNT1T, questionCounter1T);
        outState.putLong(KEY_MILLIS_LEFT1T, timeLeftInMillis1T);
        outState.putBoolean(KEY_ANSWERED1T, answered1T);
        outState.putParcelableArrayList(KEY_QUESTION_LIST1T, questionList1T);
    }
}
