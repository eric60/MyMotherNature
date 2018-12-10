package com.application.mymothernature;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ericshi.mymothernature.R;

import java.util.ArrayList;
import java.util.List;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class SignUpProfile extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String userName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_profile);

/*
        Intent myIntent = new Intent(getApplicationContext(), ProfileActivity.class);
        myIntent.putExtra("extra", userName);
        startActivityForResult(myIntent, 0);
*/

        Spinner user_knowledge = findViewById(R.id.user_knowledge);
        user_knowledge.setOnItemSelectedListener(this);
        List<String> choices = new ArrayList<String>();
        choices.add("I'm a Novice");
        choices.add("I'm a Beginner");
        choices.add("I'm Quite Knowledgeable actually");
        choices.add("I'm an Expert");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, choices);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        user_knowledge.setAdapter(dataAdapter);

        Spinner user_help = findViewById(R.id.how_much_help);
        user_help.setOnItemSelectedListener(this);
        List<String> help_choices = new ArrayList<String>();
        help_choices.add("Not much");
        help_choices.add("A little");
        help_choices.add("ALOT!");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, help_choices);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        user_help.setAdapter(dataAdapter2);


        FloatingTextButton buttonSignUp = (FloatingTextButton) findViewById(R.id.button_finish_sign_up);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               EditText edit_first_name = findViewById(R.id.edit_first_name);
               EditText password = findViewById(R.id.edit_password);
               EditText first_ecolution = findViewById(R.id.edit_first_ecolution);
               EditText first_ecoquestion = findViewById(R.id.edit_first_ecolution2);

                if(TextUtils.isEmpty(edit_first_name.getText()) || TextUtils.isEmpty(password.getText()) || TextUtils.isEmpty(first_ecolution.getText()) || TextUtils.isEmpty(first_ecoquestion.getText())) {
                    Toast.makeText(getApplicationContext(), "Please fill out all selections", Toast.LENGTH_SHORT).show();
                }
                else {
                    /*
                        Intent myIntent = new Intent(getApplicationContext(), AfterGame.class);
        String scoreString = Integer.toString(scoreTotal);
        myIntent.putExtra("extra", scoreString);
        startActivityForResult(myIntent, 0);
                     */
                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    String userName = edit_first_name.getText().toString();
                    String string_ecoquesiton = first_ecolution.getText().toString();
                    String string_ecolution = first_ecoquestion.getText().toString();
                    intent.putExtra("userName", userName);
                    intent.putExtra("ecoquestion", string_ecoquesiton);
                    intent.putExtra("ecolution", string_ecolution);
                    Toast.makeText(SignUpProfile.this, "Good Job. +10 EcoPoints for signing up", Toast.LENGTH_LONG).show();
                    startActivityForResult(intent,0);
                }

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String item = adapterView.getItemAtPosition(position).toString();
        Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
