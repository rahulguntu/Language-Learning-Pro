package com.example.languagelearningpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

public class UserLandingActivity extends AppCompatActivity {

    public ProgressBar pgsBar;
    public CardView lessonsCard, exercisesCard, progressCard;

    public int averageProgress = 0;

    public TranslatorOptions options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_landing);

        Intent intent = getIntent();
        String currEmail = "";
        String currUserID = "";
        if (intent != null){

            currEmail = intent.getStringExtra("currEmail");
            currUserID = intent.getStringExtra("user");

        }

        TextView currentUserTV = findViewById(R.id.currentUserTV);

        currentUserTV.setText(currEmail);

        ImageButton backButton = (ImageButton)findViewById(R.id.backB);
        ImageButton logOutButton = findViewById(R.id.logOutBTN);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LoginActivity.class);
                v.getContext().startActivity(goToLoginActivity);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LoginActivity.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

        for (int i = 1; i < 13; i++){

            if (i == 9){

                options =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.ENGLISH)
                                .build();


            }else if (i == 2){

                options =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.SPANISH)
                                .build();

            }else if (i == 3){

                options =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.FRENCH)
                                .build();

            }else if (i == 4){

                options =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.FRENCH)
                                .build();

            }else if (i == 5){

                options =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.CHINESE)
                                .build();

            }else if (i == 6){

                options =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.ARABIC)
                                .build();

            }else if (i == 7){

                options =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.HINDI)
                                .build();

            }else if (i == 8){

                options =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.BENGALI)
                                .build();

            }else if (i == 9){

                options =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.PORTUGUESE)
                                .build();

            }else if (i == 10){

                options =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.JAPANESE)
                                .build();

            }else if (i == 11){

                options =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.TURKISH)
                                .build();
            }else if (i == 12){

                options =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.TELUGU)
                                .build();

            }else {

                options =
                        new TranslatorOptions.Builder()
                                .setSourceLanguage(TranslateLanguage.ENGLISH)
                                .setTargetLanguage(TranslateLanguage.ENGLISH)
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

            englishToAnyLangTranslator.translate("I belong here.").addOnSuccessListener(new OnSuccessListener<String>() {
                @Override
                public void onSuccess(String s) {

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        }

        averageProgress = 80;

        pgsBar = findViewById(R.id.progressBar);

//        averageProgress = pgsBar.getProgress();
        pgsBar.setProgress(averageProgress);


        lessonsCard = findViewById(R.id.lessonsCardView);
        exercisesCard = findViewById(R.id.exercisesCardView);
        progressCard = findViewById(R.id.progressCardView);

        String finalCurrUserID = currUserID;
        String finalCurrEmail = currEmail;
        lessonsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cardType = "lessons";
                Intent goToLanguageSelectionActivity = new Intent(v.getContext(), LanguageSelectionActivity.class);
                goToLanguageSelectionActivity.putExtra("currEmail", finalCurrEmail);
                goToLanguageSelectionActivity.putExtra("currUser", finalCurrUserID);
                goToLanguageSelectionActivity.putExtra("cardType", cardType);
                v.getContext().startActivity(goToLanguageSelectionActivity);
            }
        });

        exercisesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cardType = "exercises";
                Intent goToLanguageSelectionActivity = new Intent(v.getContext(), LanguageSelectionActivity.class);
                goToLanguageSelectionActivity.putExtra("currEmail", finalCurrEmail);
                goToLanguageSelectionActivity.putExtra("currUser", finalCurrUserID);
                goToLanguageSelectionActivity.putExtra("cardType", cardType);
                v.getContext().startActivity(goToLanguageSelectionActivity);
            }
        });



//        progressCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent goToLanguageSelectionActivity = new Intent(v.getContext(), ProgressDashboardActivity.class);
//                goToLanguageSelectionActivity.putExtra("currEmail", finalCurrEmail);
//                goToLanguageSelectionActivity.putExtra("currUser", finalCurrUserID);
//                v.getContext().startActivity(goToLanguageSelectionActivity);
//            }
//        });

    }


    public void getLanguageTranslator(){



    }
}