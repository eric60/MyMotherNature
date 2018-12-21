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

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class LeaderBoardActivity extends AppCompatActivity {
    private FloatingTextButton button_viewProfile;
    private String score;
    private TextView textViewScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);

        textViewScore = findViewById(R.id.rank3);
        score = getIntent().getStringExtra("extra");

        if(score != null) {
            textViewScore.setText("Rank 2: name: EcoScore: " + score);
        }
        button_viewProfile = findViewById(R.id.view_profile);
        button_viewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(score != null) {
                    finish();
                } else {
                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
