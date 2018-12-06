package com.application.mymothernature;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ericshi.mymothernature.R;

public class ChooseCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CardView transportationCard = (CardView) findViewById(R.id.transportation);
        CardView foodCard = (CardView) findViewById(R.id.food);
        CardView productsCard = (CardView) findViewById(R.id.products);
        CardView randomCard = (CardView) findViewById(R.id.random);

        transportationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BeforeGameStart.class);
                startActivity(intent);
            }
        });
        foodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BeforeGameStart.class);
                startActivity(intent);
            }
        });
        productsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BeforeGameStart.class);
                startActivity(intent);
            }
        });
        randomCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BeforeGameStart.class);
                startActivity(intent);
            }
        });




    }

}
