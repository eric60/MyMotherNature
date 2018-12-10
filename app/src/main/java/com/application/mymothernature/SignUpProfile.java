package com.application.mymothernature;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ericshi.mymothernature.R;

import java.util.ArrayList;
import java.util.List;

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
        choices.add("Novice");
        choices.add("Beginner");
        choices.add("Quite Knowledgeable");
        choices.add("Expert");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, choices);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        user_knowledge.setAdapter(dataAdapter);
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
