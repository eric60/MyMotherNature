package com.application.mymothernature;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.example.ericshi.mymothernature.R;

import java.util.ArrayList;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class ProfileActivity extends AppCompatActivity {
    private TextView profile_ecolutions;
    private TextView profile_ecoquestions;
    private TextView profile_userName;
    private TextView profile_score;

    private FloatingTextButton sharebtn1;
    private FloatingTextButton sharebtn2;
    private FloatingTextButton button_go_home;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String input_userName = getIntent().getStringExtra("userName");
        String input_ecoquestion = getIntent().getStringExtra("ecoquestion");
        String input_ecolution = getIntent().getStringExtra("ecolution");


        String afterGame_ecoquestions = getIntent().getStringExtra("allQuestions"); // problem - null at beginning of string?
        String afterGame_ecolutions = getIntent().getStringExtra("allEcoStrings"); // problem - null at beginning of string?

        String afterGameScore = getIntent().getStringExtra("game_score");


        profile_userName = findViewById(R.id.username);
        profile_ecolutions = findViewById(R.id.ecolutions);
        profile_ecoquestions = findViewById(R.id.ecoquestions);
        profile_score = findViewById(R.id.ecoscore);

        // could be 2 different attempts: 1 from signupprofile, 1 from aftergame
        if(input_userName != null) {
            profile_userName.setText(input_userName);
        } else {
            profile_userName.setText("Username");
        }
        if(input_ecoquestion != null) {
            profile_ecoquestions.setText(input_ecoquestion);
        } else {
            profile_ecoquestions.setText(afterGame_ecoquestions);
        }

        // could be 2 different attempts: 1 from signupprofile, 1 from aftergame
        if(input_ecolution != null) {
            profile_ecolutions.setText(input_ecolution);

        } else {
            profile_ecolutions.setText(afterGame_ecolutions);
        }

        if(afterGameScore != null) {
            profile_score.setText("EcoScore: " + afterGameScore);
        } else {
            profile_score.setText("EcoScore: 10");
        }


        profile_ecolutions.setMovementMethod(new ScrollingMovementMethod());
        profile_ecoquestions.setMovementMethod(new ScrollingMovementMethod());

        sharebtn1 = findViewById(R.id.share_ecoquestion);
        sharebtn2 = findViewById(R.id.share_ecolution);


        sharebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String subject = "Check out my EcoQuestion!";
                String body = "Check out all my EcoQuestions!\n" + profile_ecoquestions.getText().toString();
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
                String body = "Check out all my Ecolutions!\n" + profile_ecolutions.getText().toString();
                myIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                myIntent.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
        });

        button_go_home = findViewById(R.id.button_home);
        button_go_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
