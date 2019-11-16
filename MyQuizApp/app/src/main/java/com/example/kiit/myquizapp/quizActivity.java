package com.example.kiit.myquizapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class quizActivity extends AppCompatActivity {
     TextView textViewQuestion;
     private static final long COUNTDOWN_IN_MILLIS = 30000;
     public static final String EXTRA_SCORE="es";
     private static final  String KEY_SCORE="kys";
     private static final String KEY_QUES_COUNT="kqc";
     private static final String KEY_MILLIS_LEFT="kml";
     private static final String KEY_ANSWER="ka";
     private static final String KEY_QUES_LIST="kql";

     TextView textViewScore;
     TextView textViewQuestionCount;
     TextView textViewCountDown;
     RadioGroup rbGroup;
     RadioButton rb1;
     RadioButton rb2;
     RadioButton rb3;
     Button buttonConfirmNext;
    private ColorStateList textColorDefaultRb;
    private ColorStateList  textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeleftInMillis;

     List<Question>questionList;
     private int questionCounter;
     private int questionCountTotal;
     private Question currentQuestion;
     private int score;
     private boolean answered;

     private long backPressedTime;
     public  static final String EXTRA_SCORE="extraScore";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        textViewQuestion=findViewById(R.id.textView6);
        textViewScore=findViewById(R.id.textView3);
        textViewQuestionCount=findViewById(R.id.textView4);
        textViewCountDown=findViewById(R.id.textView5);
        rbGroup=findViewById(R.id.radio_group);
        rb1=findViewById(R.id.radioButton);
        rb2=findViewById(R.id.radioButton2);
        rb3=findViewById(R.id.radioButton3);
        buttonConfirmNext=findViewById(R.id.button2);
        textColorDefaultRb=rb1.getTextColors();

        textColorDefaultCd =textViewCountDown.getTextColors();
        QuizDbHelper dbHelper=new QuizDbHelper(this);
        questionList= dbHelper.getAllQuestion();
        questionList=dbHelper.getAllQuestion();
        questionCountTotal=questionList.size();
        Collections.shuffle(questionList);
        showNextQuestion();
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered)
                {
                    if(rb1.isChecked()||rb2.isChecked()||rb3.isChecked()){
                        checkAnswer();
                    }else{
                        Toast.makeText(quizActivity.this, "please select an answer", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    showNextQuestion();
                }
            }
        });


    }
    private void showNextQuestion(){
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();
        if(questionCounter < questionCountTotal)
        {
            currentQuestion=questionList.get(questionCounter);
            textViewQuestion.setText(currentQuestion.getQuetion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            questionCounter++;
            textViewQuestionCount.setText("Question : " + questionCounter + "/" +questionCountTotal);
            answered= false;
            buttonConfirmNext.setText("confirm");

            timeleftInMillis=COUNTDOWN_IN_MILLIS;
            startCountDown();
        }else{
            finishQuiz();
        }
    }
    private void startCountDown(){
        countDownTimer=new CountDownTimer(timeleftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
              timeleftInMillis=millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeleftInMillis=0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText(){
        int minutes=(int)(timeleftInMillis/1000)/60;
        int seconds=(int)(timeleftInMillis/1000)%60;

        String timeFormatted=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);

        textViewCountDown.setText(timeFormatted);

        if(timeleftInMillis<10000){
            textViewCountDown.setTextColor(Color.RED);
        }else{
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }
    private void checkAnswer(){
        answered=true;

        countDownTimer.cancel();
        RadioButton rbselected=findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr=rbGroup.indexOfChild(rbselected)+1;

        if(answerNr==currentQuestion.getAnswerNr())
        {
            score=score+4;
            textViewScore.setText("Score :" + score);
        }
        else
        {
            score--;
            textViewScore.setText("Score :"+score);
        }


        showSolution();
    }
    private void showSolution(){
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);

        switch(currentQuestion.getAnswerNr()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 1 is correct");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 2 is correct");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 3 is correct");
                break;

        }
        if(questionCounter<questionCountTotal){
            buttonConfirmNext.setText("Next");
        }else{
            buttonConfirmNext.setText("Finish");
        }

    }
    private void finishQuiz(){
        Intent ri=new Intent();
        ri.putExtra(EXTRA_SCORE,score);
        setResult(RESULT_OK,ri);
        finish();
    }

    @Override
    public void onBackPressed() {
       if(backPressedTime + 2000 > System.currentTimeMillis()){
           finishQuiz();
       }else{
           Toast.makeText(this, "press back again to finish", Toast.LENGTH_SHORT).show();
       }
       backPressedTime=System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE,score);
        outState.putInt(KEY_QUES_COUNT,questionCounter);
        outState.putLong(KEY_MILLIS_LEFT,timeleftInMillis);
        outState.putBoolean(KEY_ANSWER,answered);
        outState.putParcelableArrayList(KEY_QUES_LIST,questionList);