package com.example.languagelearningpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

public class CurrentLessonActivity extends AppCompatActivity {

    public TranslatorOptions options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_lesson);

        ImageButton backButton = findViewById(R.id.backB);
        ImageButton logOutButton = findViewById(R.id.logOutBTN);



        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LoginActivity.class);
                v.getContext().startActivity(goToLoginActivity);
            }
        });

        TextView lessonNameTv = findViewById(R.id.lessonNameTV);
        TextView lessonTitleTv = findViewById(R.id.lessonTitleTV);
        TextView lessonDescriptionTV = findViewById(R.id.lessonDescriptionTV);

        Intent intent = getIntent();
        String selectedLanguage = "";
        String lessonName = "";
        String lessonTitle = "";
        String lessonDescription = "";
        String currEmail = "";
        String currUser = "";
        String cardType = "";

        if (intent != null){

            selectedLanguage = intent.getStringExtra("selectedLanguage");
            lessonName = intent.getStringExtra("lessonName");
            lessonTitle = intent.getStringExtra("lessonTitle");
            lessonDescription = intent.getStringExtra("lessonDescription");

            currEmail = intent.getStringExtra("currEmail");
            currUser = intent.getStringExtra("currUser");
            cardType = intent.getStringExtra("cardType");

        }

        lessonNameTv.setText(lessonName);

        String finalSelectedLanguage = selectedLanguage;
        String finalCardType = cardType;
        String finalCurrUser = currUser;
        String finalCurrEmail = currEmail;

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(CurrentLessonActivity.this, LessonListActivity.class);
                goToLoginActivity.putExtra("selectedLanguage", finalSelectedLanguage);
                goToLoginActivity.putExtra("currEmail", finalCurrEmail);
                goToLoginActivity.putExtra("currUser", finalCurrUser);
                goToLoginActivity.putExtra("cardType", finalCardType);
                startActivity(goToLoginActivity);

            }
        });

        if (selectedLanguage.equals("English")){

            options =
                    new TranslatorOptions.Builder()
                            .setSourceLanguage(TranslateLanguage.ENGLISH)
                            .setTargetLanguage(TranslateLanguage.ENGLISH)
                            .build();


        }else if (selectedLanguage.equals("Spanish")){

            options =
                    new TranslatorOptions.Builder()
                            .setSourceLanguage(TranslateLanguage.ENGLISH)
                            .setTargetLanguage(TranslateLanguage.SPANISH)
                            .build();

        }else if (selectedLanguage.equals("French")){

            options =
                    new TranslatorOptions.Builder()
                            .setSourceLanguage(TranslateLanguage.ENGLISH)
                            .setTargetLanguage(TranslateLanguage.FRENCH)
                            .build();

        }else if (selectedLanguage.equals("German")){

            options =
                    new TranslatorOptions.Builder()
                            .setSourceLanguage(TranslateLanguage.ENGLISH)
                            .setTargetLanguage(TranslateLanguage.FRENCH)
                            .build();

        }else if (selectedLanguage.equals("Chinese")){

            options =
                    new TranslatorOptions.Builder()
                            .setSourceLanguage(TranslateLanguage.ENGLISH)
                            .setTargetLanguage(TranslateLanguage.CHINESE)
                            .build();

        }else if (selectedLanguage.equals("Arabic")){

            options =
                    new TranslatorOptions.Builder()
                            .setSourceLanguage(TranslateLanguage.ENGLISH)
                            .setTargetLanguage(TranslateLanguage.ARABIC)
                            .build();

        }else if (selectedLanguage.equals("Hindi")){

            options =
                    new TranslatorOptions.Builder()
                            .setSourceLanguage(TranslateLanguage.ENGLISH)
                            .setTargetLanguage(TranslateLanguage.HINDI)
                            .build();

        }else if (selectedLanguage.equals("Bengali")){

            options =
                    new TranslatorOptions.Builder()
                            .setSourceLanguage(TranslateLanguage.ENGLISH)
                            .setTargetLanguage(TranslateLanguage.BENGALI)
                            .build();

        }else if (selectedLanguage.equals("Portuguese")){

            options =
                    new TranslatorOptions.Builder()
                            .setSourceLanguage(TranslateLanguage.ENGLISH)
                            .setTargetLanguage(TranslateLanguage.PORTUGUESE)
                            .build();

        }else if (selectedLanguage.equals("Japanese")){

            options =
                    new TranslatorOptions.Builder()
                            .setSourceLanguage(TranslateLanguage.ENGLISH)
                            .setTargetLanguage(TranslateLanguage.JAPANESE)
                            .build();

        }else if (selectedLanguage.equals("Turkish")){

            options =
                    new TranslatorOptions.Builder()
                            .setSourceLanguage(TranslateLanguage.ENGLISH)
                            .setTargetLanguage(TranslateLanguage.TURKISH)
                            .build();
        }else if (selectedLanguage.equals("Telugu")){

            options =
                    new TranslatorOptions.Builder()
                            .setSourceLanguage(TranslateLanguage.ENGLISH)
                            .setTargetLanguage(TranslateLanguage.TELUGU)
                            .build();

        }


        final Translator englishToAnyLangTranslator =
                Translation.getClient(options);


        DownloadConditions conditions = new DownloadConditions.Builder()
                .requireWifi()
                .build();
        englishToAnyLangTranslator.downloadModelIfNeeded(conditions).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

        englishToAnyLangTranslator.translate(lessonDescription).addOnSuccessListener(new OnSuccessListener<String>() {
            @Override
            public void onSuccess(String s) {
                lessonDescriptionTV.setText(s);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                lessonDescriptionTV.setText(e.toString());
            }
        });

        englishToAnyLangTranslator.translate(lessonTitle).addOnSuccessListener(new OnSuccessListener<String>() {
            @Override
            public void onSuccess(String s) {
                lessonTitleTv.setText(s);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                lessonTitleTv.setText(e.toString());
            }
        });
//        lessonDescriptionTV.setText(finalString);
    }
}