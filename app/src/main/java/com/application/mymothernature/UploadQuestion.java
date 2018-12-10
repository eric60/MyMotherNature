package com.application.mymothernature;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

public class UploadQuestion extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private FloatingTextButton upload;
    private FloatingTextButton sharebtn1;
    private EditText ecoquestion;
    private EditText ecolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_question);

        ecoquestion = findViewById(R.id.editQuestion);
        ecolution = findViewById(R.id.edit_ecolutions);

        sharebtn1 = findViewById(R.id.upload_share1);
        sharebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String subject = "Check out my new EcoQuestion and Ecolution!";
                String body = "Check out my new EcoQuestion!\n" + ecoquestion.getText().toString() + "\nCheck out my new Ecolution!\n" + ecolution.getText().toString();
                myIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                myIntent.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
        });

        Spinner user_knowledge = findViewById(R.id.spinner_category);
        user_knowledge.setOnItemSelectedListener(this);
        List<String> choices = new ArrayList<String>();
        choices.add("Human Transportation");
        choices.add("Food Consumption and Waste");
        choices.add("Resource Consumption and Waste");
        choices.add("Just a question I wanted to ask :)");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, choices);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        user_knowledge.setAdapter(dataAdapter);


        upload = findViewById(R.id.submit_ecoquestion);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UploadQuestion.this, "Submitted! You got 15 EcoPoints!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

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
