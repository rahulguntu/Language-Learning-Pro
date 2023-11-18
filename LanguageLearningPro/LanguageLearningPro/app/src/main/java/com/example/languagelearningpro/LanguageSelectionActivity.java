package com.example.languagelearningpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LanguageSelectionActivity extends AppCompatActivity {

    private CheckBox chkEnglish, chkSpanish, chkFrench, chkGerman, chkChinese,
            chkArabic, chkHindi, chkBengali, chkPortuguese,
            chkJapanese, chkUrdu, chkTurkish;

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);

        radioGroup = findViewById(R.id.radioGroup);


        String selectedLang = "";
        Button btnContinue = findViewById(R.id.btnContinue);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // on below line we are getting radio button from our group.
                RadioButton radioButton = findViewById(checkedId);

                Toast.makeText(LanguageSelectionActivity.this, "You've selected " + radioButton.getText() + " language!", Toast.LENGTH_LONG).show();

                btnContinue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        // Pass the selected languages to the next screen (e.g., LessonListActivity)
                        Intent intent = new Intent(LanguageSelectionActivity.this, LessonListActivity.class);
                        intent.putExtra("selectedLanguage", radioButton.getText());
                        startActivity(intent);
                    }
                });

            }
        });

        ImageButton backButton = (ImageButton)findViewById(R.id.backB);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LoginActivity.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

//        chkEnglish = findViewById(R.id.chkEnglish);
//        chkSpanish = findViewById(R.id.chkSpanish);
//        chkFrench = findViewById(R.id.chkFrench);
//
//        chkGerman = findViewById(R.id.chkGerman);
//        chkChinese = findViewById(R.id.chkChinese);
//        chkArabic = findViewById(R.id.chkArabic);
//        chkHindi = findViewById(R.id.chkHindi);
//        chkBengali = findViewById(R.id.chkBengali);
//        chkPortuguese = findViewById(R.id.chkPortuguese);
//        chkJapanese = findViewById(R.id.chkJapanese);
//        chkUrdu = findViewById(R.id.chkUrdu);
//        chkTurkish = findViewById(R.id.chkTurkish);


    }
}

