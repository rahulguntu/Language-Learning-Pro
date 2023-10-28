package com.example.languagelearningpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnSignUp = findViewById(R.id.btnSignUp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the LoginActivity when "Log In" is clicked
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the RegistrationActivity when "Sign Up" is clicked
                Intent intent = new Intent(WelcomeActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}

