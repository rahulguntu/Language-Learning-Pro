package com.example.languagelearningpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.graphics.Color;

import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    private EditText etEmail;

    private TextView backLoginForgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        backLoginForgotPass = findViewById(R.id.backLoginForgotPass);

        backLoginForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LoginActivity.class);
                v.getContext().startActivity(goToLoginActivity);
            }
        });

        etEmail = findViewById(R.id.etEmailForgotPass);

        ImageButton backButton = (ImageButton)findViewById(R.id.backBFP);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LoginActivity.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });


        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String emailText = etEmail.getText().toString();
                if (!emailText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {

                    etEmail.setTextColor(Color.rgb(0, 128, 0));
                } else {
                    etEmail.setTextColor(Color.RED);
                }

            }
        });

        Button requestPassChangeLinkBTN = findViewById(R.id.btnRequestLink);

        requestPassChangeLinkBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailForgotPassTxt = etEmail.getText().toString();

                if (!emailForgotPassTxt.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailForgotPassTxt).matches()) {

                    Intent intent = new Intent(ForgotPassword.this, LoginActivity.class);
                    Toast.makeText(ForgotPassword.this, "Password Reset Link has been sent to "+emailForgotPassTxt, Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                } else {
                    Toast.makeText(ForgotPassword.this, "Sorry! Invalid Email!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
