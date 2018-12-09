package com.application.mymothernature;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ericshi.mymothernature.R;

public class SignUpProfile extends AppCompatActivity {
    private String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_profile);


        Intent myIntent = new Intent(getApplicationContext(), ProfileActivity.class);


        myIntent.putExtra("extra", userName);
        startActivityForResult(myIntent, 0);
    }

}
