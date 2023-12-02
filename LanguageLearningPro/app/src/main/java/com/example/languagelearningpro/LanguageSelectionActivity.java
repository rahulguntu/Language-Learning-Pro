package com.example.languagelearningpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LanguageSelectionActivity extends AppCompatActivity {

    public RadioGroup radioGroup;

    public RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);


        Intent intent = getIntent();
        String currEmail = "";
        String currUser = "";
        String cardType = "";
        if (intent != null){

            currEmail = intent.getStringExtra("currEmail");
            currUser = intent.getStringExtra("currUser");
            cardType = intent.getStringExtra("cardType");

        }

        radioGroup = findViewById(R.id.radioGroup);

        final String[] selectedLang = {""};

        Button btnContinue = findViewById(R.id.btnContinue);
        String finalCardType = cardType;
        String finalCurrUser = currUser;
        String finalCurrEmail = currEmail;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // on below line we are getting radio button from our group.
                radioButton = findViewById(checkedId);


                selectedLang[0] = radioButton.getText().toString();


            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (finalCardType.equals("exercises")){

                    // Pass the selected languages to the next screen (e.g., LessonListActivity)
                    Intent intent = new Intent(LanguageSelectionActivity.this, ExerciseListActivity.class);
                    intent.putExtra("selectedLanguage", selectedLang[0]);
                    radioButton.setChecked(false);
                    intent.putExtra("currEmail", finalCurrEmail);
                    intent.putExtra("currUser", finalCurrUser);
                    intent.putExtra("cardType", finalCardType);
                    startActivity(intent);
                    finish();
                } else if (finalCardType.equals("lessons")) {

                    Intent intent = new Intent(LanguageSelectionActivity.this, LessonListActivity.class);
                    intent.putExtra("selectedLanguage", selectedLang[0]);
                    radioButton.setChecked(false);
                    intent.putExtra("currEmail", finalCurrEmail);
                    intent.putExtra("currUser", finalCurrUser);
                    intent.putExtra("cardType", finalCardType);
                    startActivity(intent);
                    finish();

                }

            }
        });

        ImageButton backButton = (ImageButton)findViewById(R.id.backB);
        ImageButton logOutButton = findViewById(R.id.logOutBTN);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LoginActivity.class);
                v.getContext().startActivity(goToLoginActivity);
            }
        });

        String finalCurrUser1 = currUser;
        String finalCurrEmail1 = currEmail;
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(LanguageSelectionActivity.this, UserLandingActivity.class);
                goToLoginActivity.putExtra("currEmail", finalCurrEmail1);
                goToLoginActivity.putExtra("currUser", finalCurrUser1);
                startActivity(goToLoginActivity);

            }
        });





    }
}

