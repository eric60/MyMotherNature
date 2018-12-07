package com.application.mymothernature;

import android.media.Image;

import com.example.ericshi.mymothernature.R;

import java.util.ArrayList;
import java.util.List;

public class Questions {
    /*
    public ArrayList<String> questions;
    public ArrayList<ArrayList<String>> answers;
    public ArrayList<Integer> answerNums;
    public ArrayList<Integer> images;
    public ArrayList<String> currAnswers; // temp list to add to answers
*/

//--------------------------------------------------------- new better OOP code
    public String question;
    public ArrayList<String> answerList;
    public int answerNum;
    public Integer image;

    public Questions(){
        answerList = new ArrayList<String>();
        /*
        currAnswers = new ArrayList<String>();
        questions = new ArrayList<String>();
        answers = new ArrayList<ArrayList<String>>();
        images = new ArrayList<Integer>();
        answerNums = new ArrayList<Integer>();
        addQuestion1();
        addQuestion2();
        addQuestion3();
        addQuestion4();
        addQuestion5();
        */
    }
/*
    private void addQuestion1() {
        questions.add("How much plastic waste do humans waste each year?");
        currAnswers.add("10 million tons");
        currAnswers.add("80 million tons");
        currAnswers.add("300 million tons"); // 3 correct
        answerNums.add(3);
        answers.add(currAnswers);
        images.add(R.drawable.game_plastic_pic);
    }

    private void addQuestion2() {
        questions.add("How many miles of car emissions is equivalent to eating 1 portion of steak?");
        currAnswers.add("0.5 miles");
        currAnswers.add("1 mile");
        currAnswers.add("3 miles"); // 3 correct
        answerNums.add(3);
        answers.add(currAnswers);
        images.add(R.drawable.game_cow_pic);
    }


    private void addQuestion3() {
        questions.add("How many pounds of of annual CO2 emissions does a person create from deciding to not take the bus on a 20 mile commute?");
        currAnswers.add("630 pounds");
        currAnswers.add("4800 pounds"); // 2 correct
        currAnswers.add("11000 pounds");
        answerNums.add(2);
        answers.add(currAnswers);
        images.add(R.drawable.game_bus_pic);
    }

    private void addQuestion4() {
        questions.add("The average American throws away 185 pounds of plastic/year. How any marine animals are killed by plastic bags anually?");
        currAnswers.add("20,000");
        currAnswers.add("60,000");
        currAnswers.add("100,000"); // 3 correct
        answerNums.add(3);
        answers.add(currAnswers);
        images.add(R.drawable.game_plastic_fish);
    }

    private void addQuestion5() {
        questions.add("How much does transportation emissions contribute to greenhouse gas emissions(GHG) in the United States?");
        currAnswers.add("2 Percent");
        currAnswers.add("10 Percent");
        currAnswers.add("30 Percent"); // 3 correct
        answerNums.add(3);
        answers.add(currAnswers);
        images.add(R.drawable.game_bus_pic);
    }
*/

}
