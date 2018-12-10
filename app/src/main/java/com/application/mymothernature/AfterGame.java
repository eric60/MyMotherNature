package com.application.mymothernature;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.ericshi.mymothernature.R;

import java.util.ArrayList;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class AfterGame extends AppCompatActivity {

    private TextView textScore;
    private FloatingTextButton sharebtn1;
    private FloatingTextButton sharebtn2;
    private FloatingTextButton sharebtn3;
    private FloatingTextButton sharebtn4;
    private FloatingTextButton sharebtn5;
    private TextView eco1;
    private TextView eco2;
    private TextView eco3;
    private TextView eco4;
    private TextView eco5;

    private AddQuestions questionObj;
    private ArrayList<Questions> listQuestions;
    private String allQuestions;
    private String allEcolutions;
    private String score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_game);
        textScore = findViewById(R.id.final_score);

        sharebtn1 = findViewById(R.id.button_share1);
        sharebtn2 = findViewById(R.id.button_share2);
        sharebtn3 = findViewById(R.id.button_share3);
        sharebtn4 = findViewById(R.id.button_share4);
        sharebtn5 = findViewById(R.id.button_share5);

        allEcolutions = getIntent().getStringExtra("passedEcolutions");
        String[] ecolutions = allEcolutions.split("\n\n");

        eco1 = findViewById(R.id.view_ecolutions_scroll);
        eco2 = findViewById(R.id.view_ecolutions_scroll2);
        eco3 = findViewById(R.id.view_ecolutions_scroll3);
        eco4 = findViewById(R.id.view_ecolutions_scroll4);
        eco5 = findViewById(R.id.view_ecolutions_scroll5);

        eco1.setText(ecolutions[0]);
        eco2.setText(ecolutions[1]);
        eco3.setText(ecolutions[2]);
        eco4.setText(ecolutions[3]);
        eco5.setText(ecolutions[4]);


        sharebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String subject = "Check out my Ecolution!";
                String body = "Check out my Ecolution\n" + eco1.getText().toString();
                myIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                myIntent.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
        });
        sharebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String subject = "Check out my Ecolution!";
                String body = "Check out my Ecolution\n" + eco2.getText().toString();
                myIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                myIntent.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
        });
        sharebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String subject = "Check out my Ecolution!";
                String body = "Check out my Ecolution\n" + eco3.getText().toString();
                myIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                myIntent.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
        });
        sharebtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String subject = "Check out my Ecolution!";
                String body = "Check out my Ecolution\n" + eco4.getText().toString();
                myIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                myIntent.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
        });
        sharebtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String subject = "Check out my Ecolution!";
                String body = "Check out my Ecolution\n" + eco5.getText().toString();
                myIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                myIntent.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
        });




        score = getIntent().getStringExtra("extra");
        allQuestions = getIntent().getStringExtra("passedQues");
        //allEcolutions = getIntent().getStringExtra("passedEcolutions");
        textScore.setText("Your EcoScore was: " + score);

        /*
            Intent myIntent = new Intent(getApplicationContext(), AfterGame.class);
            String scoreString = Integer.toString(scoreTotal);
            myIntent.putExtra("extra", scoreString);
            startActivityForResult(myIntent, 0);
        */

/*
        questionObj = new AddQuestions();
        listQuestions = questionObj.questionList;
        for(int i = 0; i < listQuestions.size(); i++) {
            allQuestions += ("EcoQuestion " + i + "\n" + listQuestions.get(i).question + "\n\n");
        }
*/

        FloatingTextButton playButton = findViewById(R.id.view_profile);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);


                intent.putExtra("allEcoStrings", allEcolutions);
                intent.putExtra("allQuestions", allQuestions);
                intent.putExtra("game_score", score);
                startActivityForResult(intent,0);
            }
        });
    }

}
