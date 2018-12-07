package com.application.mymothernature;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.example.ericshi.mymothernature.R;

public class ProfileActivity extends AppCompatActivity {
    TextView ecolutions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ecolutions = findViewById(R.id.ecolutions);
        ecolutions.setMovementMethod(new ScrollingMovementMethod());

    }

}
