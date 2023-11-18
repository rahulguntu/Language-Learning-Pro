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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        Intent intent = getIntent();

        if (intent != null){

            String emailFromReg = intent.getStringExtra("regEmail");
            etEmail.setText(emailFromReg);
        }

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

        TextView forgotPassTV = findViewById(R.id.forgotPassTV);

        forgotPassTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, ForgotPassword.class);
                startActivity(intent);
            }
        });


        ImageButton backButton = (ImageButton)findViewById(R.id.backB);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), WelcomeActivity.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

        Button btnLogin = findViewById(R.id.btnLogin);

        DBHandler dbHandler;
        ArrayList<User> userArrayList;
        dbHandler = new DBHandler(this);

        userArrayList = dbHandler.readUsers();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String regEmail = "";
                String regPassword = "";
                String passwordText = etPassword.getText().toString().toLowerCase();
                String emailText = etEmail.getText().toString().toLowerCase();

                for (int i=0; i<userArrayList.size(); i++){

                    regEmail = userArrayList.get(i).getEmail().toLowerCase();
                    regPassword = userArrayList.get(i).getPassword().toLowerCase();

                    if (regPassword.equals(passwordText)){

                        if (emailText.equals(regEmail)){

                            String user = userArrayList.get(i).getUserName();

                            Intent goToLoginIntent = new Intent(view.getContext(), LanguageSelectionActivity.class);
                            goToLoginIntent.putExtra("currEmail", regEmail);
                            goToLoginIntent.putExtra("currUser", user);
                            view.getContext().startActivity(goToLoginIntent);

                        }


                    }else {

                        if (i == userArrayList.size() -1){

                            Toast.makeText(view.getContext(), "The Login credentials don't exist!", Toast.LENGTH_LONG).show();
                            etEmail.setTextColor(Color.RED);
                            etPassword.setTextColor(Color.RED);
                        }
                    }
                }
            }
        });
    }
}

