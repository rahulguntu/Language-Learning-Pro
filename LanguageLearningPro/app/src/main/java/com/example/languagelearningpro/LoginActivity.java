package com.example.languagelearningpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perform user login logic here
                // You can get values from etEmail and etPassword
                // and validate them against stored credentials or a server
                // For now, let's assume the login is successful

                // Redirect to the HomeActivity after successful login
                Intent intent = new Intent(LoginActivity.this, LanguageSelectionActivity.class);
                startActivity(intent);
            }
        });
    }
}

