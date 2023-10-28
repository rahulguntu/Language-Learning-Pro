package com.example.languagelearningpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;

public class LanguageSelectionActivity extends AppCompatActivity {

    private CheckBox chkEnglish, chkSpanish, chkFrench;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);

        chkEnglish = findViewById(R.id.chkEnglish);
        chkSpanish = findViewById(R.id.chkSpanish);
        chkFrench = findViewById(R.id.chkFrench);

        Button btnContinue = findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the selected language(s) from checkboxes
                String selectedLanguages = "";
                if (chkEnglish.isChecked()) {
                    selectedLanguages += "English, ";
                }
                if (chkSpanish.isChecked()) {
                    selectedLanguages += "Spanish, ";
                }
                if (chkFrench.isChecked()) {
                    selectedLanguages += "French, ";
                }

                if (!selectedLanguages.isEmpty()) {
                    selectedLanguages = selectedLanguages.substring(0, selectedLanguages.length() - 2); // Remove the trailing comma and space
                }

                // Pass the selected languages to the next screen (e.g., LessonListActivity)
                Intent intent = new Intent(LanguageSelectionActivity.this, LessonListActivity.class);
                intent.putExtra("selectedLanguages", selectedLanguages);
                startActivity(intent);
            }
        });
    }
}

