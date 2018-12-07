package com.application.mymothernature;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ericshi.mymothernature.R;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class BeforeGameStart extends AppCompatActivity {

    private RadioGroup radioGroup;
    private int passedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_game_start);



        FloatingTextButton playButton = findViewById(R.id.start_game_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup = findViewById(R.id.radio_group);
                int selectedRadioId = radioGroup.getCheckedRadioButtonId();
                if(selectedRadioId == R.id.easy) {
                    passedTime = 20000;
                } else if(selectedRadioId == R.id.med) {
                    passedTime = 12000;
                } else if(selectedRadioId == R.id.hard) {
                    passedTime = 5000;
                }
                Intent myIntent = new Intent(getApplicationContext(), GameActivity.class);
                myIntent.putExtra("extra", passedTime);
                startActivity(myIntent);
            }
        });

    }

}
