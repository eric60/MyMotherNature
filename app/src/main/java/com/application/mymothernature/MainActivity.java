package com.application.mymothernature;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ericshi.mymothernature.R;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class MainActivity extends AppCompatActivity {
    private Dialog popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        popup = new Dialog(this);
        showDialog();

        FloatingTextButton playButton = (FloatingTextButton) findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChooseCategoryActivity.class);
                startActivity(intent);
            }
        });

        FloatingTextButton newQuestionButton = (FloatingTextButton) findViewById(R.id.new_question);
        newQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ReviewQuestion.class);
                startActivity(intent);
            }
        });

        FloatingTextButton leaderBoardsButton = (FloatingTextButton) findViewById(R.id.leaderboards_button);
        leaderBoardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeaderBoardActivity.class);
                startActivity(intent);
            }
        });

        FloatingTextButton viewProfileButton = findViewById(R.id.view_profile_button);
        viewProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


    }

    public void showDialog() {
        TextView closeButton;
        popup.setContentView(R.layout.popup1);
        closeButton  =(TextView) popup.findViewById(R.id.exit_button);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });
        popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popup.show();
    }
}
