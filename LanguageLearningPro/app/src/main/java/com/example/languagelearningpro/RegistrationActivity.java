package com.example.languagelearningpro;

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
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        DBHandler dbHandler;

        dbHandler = new DBHandler(this);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        etName.setTextColor(Color.BLACK);
        etEmail.setTextColor(Color.BLACK);
        etPassword.setTextColor(Color.BLACK);

        Button btnSignUp = findViewById(R.id.btnSignUp);


        ImageButton backButton = (ImageButton)findViewById(R.id.backB);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), WelcomeActivity.class);
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

        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String phoneText = etName.getText().toString();
                if (phoneText.length() > 1) {

                    etName.setTextColor(Color.rgb(0, 128, 0));

                } else {
                    etName.setTextColor(Color.RED);
                }
            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String passwordText = etPassword.getText().toString();
                if (passwordText.length() > 8) {

                    etPassword.setTextColor(Color.rgb(0, 128, 0));

                } else {
                    etPassword.setTextColor(Color.RED);
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullNameText = etName.getText().toString();
                String emailText = etEmail.getText().toString();
                String passwordText = etPassword.getText().toString();

                dbHandler.addNewUser(fullNameText, emailText, passwordText);

                if (fullNameText.length() > 1) {

                    if ( !emailText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {


                        String emailETText = etEmail.getText().toString();

                        if (passwordText.length() > 8) {

                            Toast.makeText(view.getContext(), "User added successfully.", Toast.LENGTH_SHORT).show();
                            Intent goToLoginIntent = new Intent(view.getContext(), LoginActivity.class);
                            goToLoginIntent.putExtra("regEmail", emailText);
                            view.getContext().startActivity(goToLoginIntent);

                        }else {
                            etPassword.setTextColor(Color.RED);
                            Toast.makeText(RegistrationActivity.this, "Password is too short! Password should be 8 or more characters long", Toast.LENGTH_LONG).show();
                        }



                    }else{

                        etEmail.setTextColor(Color.RED);
                        Toast.makeText(RegistrationActivity.this, "Invalid Email Address!", Toast.LENGTH_LONG).show();
                    }


                }else{

                    etName.setTextColor(Color.RED);

                    Toast.makeText(RegistrationActivity.this, "Name cannot be empty!", Toast.LENGTH_LONG).show();
                }



            }
        });
    }
}

