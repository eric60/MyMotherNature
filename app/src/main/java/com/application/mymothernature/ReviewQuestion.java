package com.application.mymothernature;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;


import com.example.ericshi.mymothernature.R;

import java.util.ArrayList;
import java.util.List;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class ReviewQuestion extends AppCompatActivity implements OnItemSelectedListener{
    //  private Spinner rateQuestion;
        private Dialog popup;
        private EditText edit_ecolutions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_question);

        popup = new Dialog(this);
        showDialog();

        Spinner rateQuestion = findViewById(R.id.rate_question);
        rateQuestion.setOnItemSelectedListener(this);
        List<String> choices = new ArrayList<String>();
        choices.add("1. Good. Question made me think");
        choices.add("2. Okay. Could be more interesting");
        choices.add("3. Bad. Question was boring/too obvious");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, choices);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rateQuestion.setAdapter(dataAdapter);

        FloatingTextButton submitReviewButton = (FloatingTextButton) findViewById(R.id.submit_review);
        submitReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_ecolutions = findViewById(R.id.edit_ecolutions);
                if(TextUtils.isEmpty(edit_ecolutions.getText())) {
                    Toast.makeText(getApplicationContext(), "Please fill out all selections", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(), UploadQuestion.class);
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

    public void showDialog() {
        TextView closeButton;
        popup.setContentView(R.layout.popup2);
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
