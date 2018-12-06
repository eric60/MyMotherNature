package com.application.mymothernature;

import android.content.res.ColorStateList;
import android.os.Bundle;
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

import com.example.ericshi.mymothernature.R;
import com.application.mymothernature.Questions;

import java.util.ArrayList;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class GameActivity extends AppCompatActivity {
    private TextView textQuestion;
    private TextView textScore;
    private TextView textQuestionCount;
    private TextView textTimer;
    private ImageView image;
    private RadioButton r1;
    private RadioButton r2;
    private RadioButton r3;
    private RadioGroup radioGroup;
    private FloatingTextButton confirmButton;
    private ColorStateList defaultColor;
    private int questionCounter;
    private int questionTotal;
    private String currQuestion;
    private Questions questionObj;
    private boolean currSubmitted;
    private int scoreTotal;
    private ArrayList<String> questionList;
    private ArrayList<ArrayList<String>> answerList;
    private ArrayList<Integer> imageList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textQuestion = findViewById(R.id.game_question);
        textQuestionCount = findViewById(R.id.game_question_count);
        textScore = findViewById(R.id.game_score);
        textTimer = findViewById(R.id.timer);
        radioGroup = findViewById(R.id.radio_group);
        r1 = findViewById(R.id.radio1);
        r2 = findViewById(R.id.radio2);
        r3 = findViewById(R.id.radio3);
        confirmButton = findViewById(R.id.confirm_button);
        questionObj = new Questions();
        questionList = questionObj.questions;
        answerList = questionObj.answers;
        imageList = questionObj.images;
        questionTotal = questionList.size(); // 5 hardcoded questions
        defaultColor = r1.getTextColors();
        moveNextQuestion();
    }

    private void moveNextQuestion() {
        r1.setTextColor(defaultColor);
        r2.setTextColor(defaultColor);
        r3.setTextColor(defaultColor);
        radioGroup.clearCheck();

        if(questionCounter < questionTotal) {
            currQuestion = (String) questionList.get(questionCounter); // 5 total questions: 0,1,2,3,4
            textQuestion.setText(currQuestion);
            ArrayList<String> currAnsList = (ArrayList<String>)answerList.get(questionCounter);
            r1.setText(currAnsList.get(0));
            r2.setText(currAnsList.get(1));
            r3.setText(currAnsList.get(2));
            questionCounter ++;
            textQuestionCount.setText("Question: " + questionCounter + "/" + questionTotal);
            currSubmitted = false; // after answered prev question now on curr question currSubmitted is false
            confirmButton.setTitle("Confirm");
        } else {
            // finished quiz
            finishQuiz();
        }
    }

    private void finishQuiz() {
        finish();
    }

}
