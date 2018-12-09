package com.application.mymothernature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ericshi.mymothernature.R;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class LoginActivity2 extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private FloatingTextButton login;
    private FloatingTextButton facebookLogin;
    private FloatingTextButton leaveButton;
    private TextView displayInfo;
    private int attempts = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        login = (FloatingTextButton)findViewById(R.id.regular_sign_in);
        facebookLogin = (FloatingTextButton)findViewById(R.id.facebook_sign_in);
        //leaveButton = (FloatingTextButton)findViewById(R.id.leave_button);
        displayInfo = (TextView)findViewById(R.id.displayInfo);

        displayInfo.setText("");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(email.getText().toString(), password.getText().toString());
            }
        });
        facebookLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(email.getText().toString(), password.getText().toString());
            }
        });
        /*
        leaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(email.getText().toString(), password.getText().toString());
            }
        });
        */
    }

    private void validate(String userName, String userPassword){
        if((userName.equals("name")) && (userPassword.equals("pass"))){
            Intent intent = new Intent(getApplicationContext(), ChooseCategoryActivity.class);
            startActivity(intent);
        }else{
            attempts--;

            displayInfo.setText("You have " + String.valueOf(attempts) + " attempts remaining. \nForgot Password?");

            if(attempts == 0){
                login.setEnabled(false);
            }
        }
    }

}