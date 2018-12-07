package com.application.mymothernature;

import com.example.ericshi.mymothernature.R;

import java.util.ArrayList;

public class AddQuestions {

    public ArrayList<Questions> questionList; // list of Question Objects;

    public AddQuestions() {
        questionList = new ArrayList<Questions>();
        addQuestion1();
        addQuestion2();
        addQuestion3();
        addQuestion4();
        addQuestion5();
    }


    private void addQuestion1() {
        Questions q1 = new Questions();
        q1.question = ("How much plastic waste do humans waste each year?");
        q1.answerList.add("10 million tons");
        q1.answerList.add("80 million tons");
        q1.answerList.add("300 million tons"); // 3 correct
        q1.answerNum = 3;
        q1.image = (R.drawable.game_plastic_waste);
        questionList.add(q1);

    }

    private void addQuestion2() {
        Questions q2 = new Questions();
        q2.question = ("How many miles of car emissions is equivalent to eating 1 portion of steak?");
        q2.answerList.add("0.5 miles");
        q2.answerList.add("1 mile");
        q2.answerList.add("3 miles"); // 3 correct
        q2.answerNum = 3;
        q2.image = R.drawable.game_cow_pic;
        questionList.add(q2);
    }


    private void addQuestion3() {
        Questions q3 = new Questions();
        q3.question =("How many pounds of of annual CO2 emissions does a person create from deciding to not take the bus on a 20 mile commute?");
        q3.answerList.add("630 pounds");
        q3.answerList.add("4800 pounds"); // 2 correct
        q3.answerList.add("11000 pounds");
        q3.answerNum = 2;
        q3.image =(R.drawable.game_bus_pic);
        questionList.add(q3);
    }

    private void addQuestion4() {
        Questions q4 = new Questions();
        q4.question =("The average American throws away 185 pounds of plastic/year. How any marine animals are killed by plastic bags anually?");
        q4.answerList.add("20,000");
        q4.answerList.add("60,000");
        q4.answerList.add("100,000"); // 3 correct
        q4.answerNum = 3;
        q4.image =(R.drawable.game_pic_plastic_fish);
        questionList.add(q4);
    }

    private void addQuestion5() {
        Questions q5 = new Questions();
        q5.question =("How much does transportation emissions contribute to greenhouse gas emissions(GHG) in the United States?");
        q5.answerList.add("2 Percent");
        q5.answerList.add("10 Percent");
        q5.answerList.add("30 Percent"); // 3 correct
        q5.answerNum = 3;
        q5.image =(R.drawable.game_traffic_pic);
        questionList.add(q5);
    }

}
