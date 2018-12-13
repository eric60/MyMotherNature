package com.application.mymothernature;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ericshi.mymothernature.R;
import com.application.mymothernature.Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class GameActivity extends AppCompatActivity {
    private TextView textQuestion;
    private TextView textScore;
    private TextView textQuestionCount;
    private TextView textTimer;

    private ImageView gameImage;
    private RadioButton r1;
    private RadioButton r2;
    private RadioButton r3;
    private RadioGroup radioGroup;

    private FloatingTextButton confirmButton;
    private ColorStateList defaultColor;
    private ColorStateList timerdefaultColor;
    private int questionCounter = 0;
    private int questionTotal;
    private String currQuestion;
    private boolean currSubmitted;
    private int scoreTotal;
    private long backButtonTime;

    private int passed_countdown_time; // passed from previous intent
    private CountDownTimer actualTimer; // actual timer
    private long timeLeft;
    private AddQuestions questionObj;
    private ArrayList<Questions> listQuestions;

    private String passedQuestions = "";
    private String passedEcolutions = "";

    // --------------------------------------------------------deprecated code

  /*  private ArrayList<String> questionList;
    private ArrayList<ArrayList<String>> answerList;
    private ArrayList<Integer> imageList;
    private ArrayList<Integer> answerNumList;
  */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent myIntent = getIntent();
        passed_countdown_time = myIntent.getIntExtra("extra", 0); // should be 20000, 12000, or 5000

        textQuestion = findViewById(R.id.game_question);
        textQuestionCount = findViewById(R.id.game_question_count);
        textScore = findViewById(R.id.game_score);
        textTimer = findViewById(R.id.game_timer);
        radioGroup = findViewById(R.id.radio_group);
        gameImage = findViewById(R.id.game_pic);

        r1 = findViewById(R.id.radio1);
        r2 = findViewById(R.id.radio2);
        r3 = findViewById(R.id.radio3);
        confirmButton = findViewById(R.id.confirm_button);

        questionObj = new AddQuestions();
        listQuestions = questionObj.questionList;


        questionTotal = listQuestions.size(); // 5 hardcoded questions
        System.out.println(questionTotal);
        defaultColor = r1.getTextColors();
        timerdefaultColor = textTimer.getTextColors();

        Collections.shuffle(listQuestions);
        moveNextQuestion(); // Moves to first question slide number 1/5


        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!currSubmitted) {
                    if(r1.isChecked() || r2.isChecked() || r3.isChecked()) {
                        checkCurrAnswer(); // question counter on curr Num
                        actualTimer.cancel();
                    } else {
                        Toast.makeText(GameActivity.this, "Please choose an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    moveNextQuestion();
                }
            }
        });

    }

    private void moveNextQuestion() {

        r1.setTextColor(defaultColor);
        r2.setTextColor(defaultColor);
        r3.setTextColor(defaultColor);
        radioGroup.clearCheck();

        if(questionCounter < questionTotal) { // questionCounter starts at 0
            Questions questionObj = listQuestions.get(questionCounter);
            currQuestion = questionObj.question; // 5 total questions: 0,1,2,3,4

            passedQuestions += ("EcoQuestion " + (questionCounter + 1) + "\n" + currQuestion +  "\n\n");
            passedEcolutions += ("Ecolution " + (questionCounter + 1) + "\n" + questionObj.ecolution +  "\n\n");

            textQuestion.setTextColor(Color.BLACK);
            textQuestion.setText(currQuestion);

            ArrayList<String> currAnsList = listQuestions.get(questionCounter).answerList;
            r1.setText(currAnsList.get(0));
            r2.setText(currAnsList.get(1));
            r3.setText(currAnsList.get(2));
            Drawable myDrawable = getResources().getDrawable(listQuestions.get(questionCounter).image);
            gameImage.setImageDrawable(myDrawable);

            questionCounter ++;
            textQuestionCount.setText("Question: " + questionCounter + "/" + questionTotal);
            currSubmitted = false; // after answered prev question now on curr question currSubmitted is false
            confirmButton.setTitleColor(Color.BLACK);
            confirmButton.setTitle("Confirm Answer");

            timeLeft = passed_countdown_time + 1000;
            startCountDown();
        } else {
            // finished quiz
            finishQuiz();
        }
    }

    private void finishQuiz() {
        Intent myIntent = new Intent(getApplicationContext(), AfterGame.class);
        String scoreString = Integer.toString(scoreTotal);

        myIntent.putExtra("extra", scoreString);
        System.out.println(passedQuestions);
        myIntent.putExtra("passedQues", passedQuestions.toString());
        myIntent.putExtra("passedEcolutions", passedEcolutions.toString());

        startActivityForResult(myIntent, 0);
        finish(); // finishes the activity
    }

    public void checkCurrAnswer() {
        currSubmitted = true; // question was submitted for checkCurrAnswer
        RadioButton selectedRadioNum = findViewById(radioGroup.getCheckedRadioButtonId());
        int radioAnswerNumber = radioGroup.indexOfChild(selectedRadioNum) + 1;
        Boolean correct = (radioAnswerNumber == listQuestions.get(questionCounter - 1).answerNum);
        if(correct) {
            scoreTotal += 5;
            textScore.setText("EcoScore: " + scoreTotal);
        }
        showAnswer();
    }

    private void startCountDown() {
        actualTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long l) {
                timeLeft = l;
                updateTextTime();
            }

            @Override
            public void onFinish() {
                timeLeft = 0; // stops at 1 sec
                updateTextTime();
                checkCurrAnswer();
            }
        }.start(); // start right after creating it
    }

    public void updateTextTime() {
        int seconds = (int) (timeLeft / 1000) % 60;
        String timeString = String.format(Locale.US, "%02d", seconds);
        textTimer.setText(timeString);
        if (timeLeft < 5000) {
            textTimer.setTextColor(Color.RED);
        } else {
            textTimer.setTextColor(Color.GREEN);
        }
    }


    public void showAnswer() {
        r1.setTextColor(Color.RED);
        r2.setTextColor(Color.RED);
        r3.setTextColor(Color.RED);
        int answerNum = listQuestions.get(questionCounter - 1).answerNum;

        RadioButton selectedRadioNum = findViewById(radioGroup.getCheckedRadioButtonId());
        int radioAnswerNumber = radioGroup.indexOfChild(selectedRadioNum) + 1;
        Boolean correct = (radioAnswerNumber == answerNum);

            if(answerNum == 1) {
                r1.setTextColor(Color.GREEN);
                if(correct) {
                    textQuestion.setText("Correct! The first option was correct");
                    textQuestion.setTextColor(Color.GREEN);
                } else {
                    textQuestion.setText("Sorry, The first option was correct");
                    textQuestion.setTextColor(Color.RED);
                }
            }
            else if(answerNum == 2) {
                r2.setTextColor(Color.GREEN);
                if(correct) {
                    textQuestion.setText("Correct! The second option was correct");
                    textQuestion.setTextColor(Color.GREEN);
                } else {
                    textQuestion.setText("Sorry, The second option was correct");
                    textQuestion.setTextColor(Color.RED);
                }

            }
            else if(answerNum == 3) {
                r3.setTextColor(Color.GREEN);
                if(correct) {
                    textQuestion.setText("Correct! The third option was correct");
                    textQuestion.setTextColor(Color.GREEN);
                } else {
                    textQuestion.setText("Sorry, The third option was correct");
                    textQuestion.setTextColor(Color.RED);
                }
            }

            if(questionCounter < questionTotal) {
                confirmButton.setTitle("Next Question");
                confirmButton.setTitleColor(Color.WHITE);
            } else {
                confirmButton.setTitle("Finish Quiz");
                confirmButton.setTitleColor(Color.WHITE);
            }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(actualTimer != null) {
            actualTimer.cancel(); // must cancel timer in background
        }
    }
    @Override
    public void onBackPressed() {
        if (backButtonTime + 2000 > System.currentTimeMillis()) { // if user clicks back button within 2 seconds time from original system time , finish quiz
            finishQuiz();
        } else {
            Toast.makeText(this, "Hit back again to quit", Toast.LENGTH_SHORT).show();
        }
        backButtonTime = System.currentTimeMillis();
    }
}
