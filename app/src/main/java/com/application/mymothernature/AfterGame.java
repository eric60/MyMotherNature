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

public class AfterGame extends AppCompatActivity {

    private TextView textScore;
    private FloatingTextButton sharebtn1;
    private FloatingTextButton sharebtn2;
    private FloatingTextButton sharebtn3;
    private FloatingTextButton sharebtn4;
    private FloatingTextButton sharebtn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_game);
        textScore = findViewById(R.id.final_score);

        String score = getIntent().getStringExtra("extra");
        textScore.setText("Your EcoScore was: " + score);

        FloatingTextButton playButton = findViewById(R.id.view_profile);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });
    }

}
