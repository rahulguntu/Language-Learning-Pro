package com.example.languagelearningpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CurrentExercise extends AppCompatActivity {

    public Handler handler;

    public Runnable runnable;

    public TextView timerTV;

    public int selectedId;
    public List<ExerciseItem>  exerciseList;

    public Button nextQuizBTN;

    public RadioGroup radioGroup;

    public RadioButton radioButton;

    public TranslatorOptions options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_exercise);

        radioGroup = findViewById(R.id.answersSection);
        RadioButton answerOneBTN = findViewById(R.id.answerOneBTN);
        RadioButton answerTwoBTN = findViewById(R.id.answerTwoBTN);
        RadioButton answerThreeBTN = findViewById(R.id.answerThreeBTN);
        RadioButton answerFourBTN = findViewById(R.id.answerFourBTN);

        nextQuizBTN = findViewById(R.id.nextQuizBTN);

        ImageButton backButton = findViewById(R.id.backB);
        ImageButton logOutButton = findViewById(R.id.logOutBTN);

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LoginActivity.class);
                v.getContext().startActivity(goToLoginActivity);
            }
        });

        TextView exerciseNameTV = findViewById(R.id.exerciseNameTV);
        TextView questionTv = findViewById(R.id.questionTv);
        timerTV = findViewById(R.id.timerTV);

        Intent intent = getIntent();
        String selectedLanguage = "";
        String exerciseName = "";
        String exerciseDescription = "";
        String currEmail = "";
        String currUser = "";
        String cardType = "";

        if (intent != null){

            selectedLanguage = intent.getStringExtra("selectedLanguage");
            exerciseName = intent.getStringExtra("exerciseName");
            exerciseDescription = intent.getStringExtra("lessonDescription");
            currEmail = intent.getStringExtra("currEmail");
            currUser = intent.getStringExtra("currUser");
            cardType = intent.getStringExtra("cardType");


        }


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


        exerciseList = new ArrayList<>();

        if (exerciseName.equals("Exercise 1")) {

            exerciseList = fillExerciseList(exerciseList);

        }else if (exerciseName.equals("Exercise 2")) {

            exerciseList = fillExercise2List(exerciseList);

        }else if (exerciseName.equals("Exercise 3")) {

            exerciseList = fillExercise3List(exerciseList);

        }else if (exerciseName.equals("Exercise 4")) {

            exerciseList = fillExercise4List(exerciseList);

        }else if (exerciseName.equals("Exercise 5")) {

            exerciseList = fillExercise5List(exerciseList);

        }else if (exerciseName.equals("Exercise 6")) {

            exerciseList = fillExercise6List(exerciseList);

        }else if (exerciseName.equals("Exercise 7")) {

            exerciseList = fillExercise7List(exerciseList);

        }else if (exerciseName.equals("Exercise 8")) {

            exerciseList = fillExercise8List(exerciseList);

        }else if (exerciseName.equals("Exercise 9")) {

            exerciseList = fillExercise9List(exerciseList);

        }else if (exerciseName.equals("Exercise 10")) {

            exerciseList = fillExercise10List(exerciseList);

        }

        if (!(exerciseList.isEmpty())) {

            String  quiz = ("Q1. " + exerciseList.get(0).getQuestionPartA() + " ______ " + exerciseList.get(0).getQuestionPartB());

            String answerA = exerciseList.get(0).getAnswerOne();
            String answerB = exerciseList.get(0).getAnswerTwo();
            String answerC = exerciseList.get(0).getAnswerThree();
            String answerD = exerciseList.get(0).getAnswerFour();
            String trueAnswer = exerciseList.get(0).getCorrectAnswer();


            englishToAnyLangTranslator.translate(quiz).addOnSuccessListener(new OnSuccessListener<String>() {
                @Override
                public void onSuccess(String s) {
                    questionTv.setText(s);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    questionTv.setText("An error occurred while loading question.");
                }
            });

            englishToAnyLangTranslator.translate(answerA).addOnSuccessListener(new OnSuccessListener<String>() {
                @Override
                public void onSuccess(String s) {
                    answerOneBTN.setText(s);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    answerOneBTN.setText("An error occurred while loading answer.");
                }
            });

            englishToAnyLangTranslator.translate(answerB).addOnSuccessListener(new OnSuccessListener<String>() {
                @Override
                public void onSuccess(String s) {
                    answerTwoBTN.setText(s);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    answerTwoBTN.setText("An error occurred while loading answer.");
                }
            });

            englishToAnyLangTranslator.translate(answerC).addOnSuccessListener(new OnSuccessListener<String>() {
                @Override
                public void onSuccess(String s) {
                    answerThreeBTN.setText(s);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    answerThreeBTN.setText("An error occurred while loading answer.");
                }
            });

            englishToAnyLangTranslator.translate(answerD).addOnSuccessListener(new OnSuccessListener<String>() {
                @Override
                public void onSuccess(String s) {
                    answerFourBTN.setText(s);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    answerFourBTN.setText("An error occurred while loading answer.");
                }
            });
        }else{

            questionTv.setText("Q1. Unavailable");
            answerOneBTN.setText("Unavailable");
            answerTwoBTN.setText("Unavailable");
            answerThreeBTN.setText("Unavailable");
            answerFourBTN.setText("Unavailable");
            timerTV.setText("00:00");

        }

        String finalSelectedLanguage = selectedLanguage;
        String finalExerciseDescription = exerciseDescription;
        String finalExerciseName = exerciseName;
        String finalCardType = cardType;
        String finalCurrUser = currUser;
        String finalCurrEmail = currEmail;
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!(exerciseList.isEmpty()))
                    exerciseList.removeAll(exerciseList);

                Intent goToLoginActivity = new Intent(CurrentExercise.this, ExerciseListActivity.class);
                goToLoginActivity.putExtra("selectedLanguage", finalSelectedLanguage);
                goToLoginActivity.putExtra("exerciseName", finalExerciseName);
                goToLoginActivity.putExtra("exerciseDescription", finalExerciseDescription);
                goToLoginActivity.putExtra("currEmail", finalCurrEmail);
                goToLoginActivity.putExtra("currUser", finalCurrUser);
                goToLoginActivity.putExtra("cardType", finalCardType);

                startActivity(goToLoginActivity);
                if (!(runnable == null))
                    handler.removeCallbacks(runnable);
                finish();

            }
        });

        if (!(exerciseList.isEmpty())) {
            handler = new Handler();


            timerTV.setText("00:00");


            final int[] finalI = {1};
            finalI[0] = 0;
            final int[] exerciseControllers = {0};
            exerciseControllers[0] = 1;
            final int[] scoreTot = new int[1];
            runnable = new Runnable() {
                @Override
                public void run() {


                    handler.postDelayed(this, 1000L);// 1 second delay

                    nextQuizBTN.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (exerciseControllers[0] == 10) {

                                Intent goToLoginActivity = new Intent(CurrentExercise.this, CompletedExerciseActivity.class);
                                goToLoginActivity.putExtra("selectedLanguage", finalSelectedLanguage);
                                goToLoginActivity.putExtra("exerciseName", finalExerciseName);
                                goToLoginActivity.putExtra("exerciseDescription", finalExerciseDescription);
                                startActivity(goToLoginActivity);
                                if (!(runnable == null))
                                    handler.removeCallbacks(runnable);
                                finish();
                            } else {

                                finalI[0] = 0;

                                String exerciseControllersString = String.valueOf(exerciseControllers[0] + 1);
                                timerTV.setTextColor(Color.BLACK);
                                timerTV.setText("00:60");
                                String quiz = "Q" + exerciseControllersString + ". "
                                        + exerciseList.get(exerciseControllers[0]).getQuestionPartA() + " ______ "
                                        + exerciseList.get(exerciseControllers[0]).getQuestionPartB();


                                String answerA = exerciseList.get(exerciseControllers[0]).getAnswerOne();
                                String answerB = exerciseList.get(exerciseControllers[0]).getAnswerTwo();
                                String answerC = exerciseList.get(exerciseControllers[0]).getAnswerThree();
                                String answerD = exerciseList.get(exerciseControllers[0]).getAnswerFour();
                                String trueAnswer = exerciseList.get(exerciseControllers[0]).getCorrectAnswer();


                                englishToAnyLangTranslator.translate(quiz).addOnSuccessListener(new OnSuccessListener<String>() {
                                    @Override
                                    public void onSuccess(String s) {
                                        questionTv.setText(s);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        questionTv.setText("An error occurred while loading question.");
                                    }
                                });

                                englishToAnyLangTranslator.translate(answerA).addOnSuccessListener(new OnSuccessListener<String>() {
                                    @Override
                                    public void onSuccess(String s) {
                                        answerOneBTN.setText(s);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        answerOneBTN.setText("An error occurred while loading answer.");
                                    }
                                });

                                englishToAnyLangTranslator.translate(answerB).addOnSuccessListener(new OnSuccessListener<String>() {
                                    @Override
                                    public void onSuccess(String s) {
                                        answerTwoBTN.setText(s);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        answerTwoBTN.setText("An error occurred while loading answer.");
                                    }
                                });

                                englishToAnyLangTranslator.translate(answerC).addOnSuccessListener(new OnSuccessListener<String>() {
                                    @Override
                                    public void onSuccess(String s) {
                                        answerThreeBTN.setText(s);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        answerThreeBTN.setText("An error occurred while loading answer.");
                                    }
                                });

                                englishToAnyLangTranslator.translate(answerD).addOnSuccessListener(new OnSuccessListener<String>() {
                                    @Override
                                    public void onSuccess(String s) {
                                        answerFourBTN.setText(s);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        answerFourBTN.setText("An error occurred while loading answer.");
                                    }
                                });



                                exerciseControllers[0] = exerciseControllers[0] + 1;

                                scoreTot[0] = scoreTot[0] + 10;
//
//                        // find the radiobutton by returned id


                                if (!(radioGroup.getCheckedRadioButtonId() == -1)) {
                                    selectedId = radioGroup.getCheckedRadioButtonId();
                                    radioButton = (RadioButton) findViewById(selectedId);
                                    radioButton.setChecked(false);
                                }


                            }
                        }
                    });

                    finalI[0] = finalI[0] + 1;
                    String finalIString = String.valueOf(finalI[0]);
                    // do something
                    if (finalI[0] == 45) {

                        timerTV.setTextColor(Color.RED);
                        String finalLIString = String.valueOf(60 - finalI[0]);
                        timerTV.setText("00:" + finalLIString);


                    } else if (finalI[0] == 60) {

                        if (exerciseControllers[0] == 10 && finalI[0] == 60) {

                            Intent goToLoginActivity = new Intent(CurrentExercise.this, CompletedExerciseActivity.class);
                            goToLoginActivity.putExtra("selectedLanguage", finalSelectedLanguage);
                            goToLoginActivity.putExtra("exerciseName", finalExerciseName);
                            goToLoginActivity.putExtra("exerciseDescription", finalExerciseDescription);
                            startActivity(goToLoginActivity);
                            handler.removeCallbacks(runnable);
                            finish();
                        }

                        finalI[0] = 0;

                        timerTV.setTextColor(Color.BLACK);
                        String exerciseControllersString = String.valueOf(exerciseControllers[0] + 1);
                        timerTV.setText("00:60");
                        String quiz = "Q" + exerciseControllersString + ". "
                                + exerciseList.get(exerciseControllers[0]).getQuestionPartA() + " ______ "
                                + exerciseList.get(exerciseControllers[0]).getQuestionPartB();


                        String answerA = exerciseList.get(exerciseControllers[0]).getAnswerOne();
                        String answerB = exerciseList.get(exerciseControllers[0]).getAnswerTwo();
                        String answerC = exerciseList.get(exerciseControllers[0]).getAnswerThree();
                        String answerD = exerciseList.get(exerciseControllers[0]).getAnswerFour();
                        String trueAnswer = exerciseList.get(exerciseControllers[0]).getCorrectAnswer();

                        englishToAnyLangTranslator.translate(quiz).addOnSuccessListener(new OnSuccessListener<String>() {
                            @Override
                            public void onSuccess(String s) {
                                questionTv.setText(s);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                questionTv.setText("An error occurred while loading question.");
                            }
                        });

                        englishToAnyLangTranslator.translate(answerA).addOnSuccessListener(new OnSuccessListener<String>() {
                            @Override
                            public void onSuccess(String s) {
                                answerOneBTN.setText(s);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                answerOneBTN.setText("An error occurred while loading answer.");
                            }
                        });

                        englishToAnyLangTranslator.translate(answerB).addOnSuccessListener(new OnSuccessListener<String>() {
                            @Override
                            public void onSuccess(String s) {
                                answerTwoBTN.setText(s);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                answerTwoBTN.setText("An error occurred while loading answer.");
                            }
                        });

                        englishToAnyLangTranslator.translate(answerC).addOnSuccessListener(new OnSuccessListener<String>() {
                            @Override
                            public void onSuccess(String s) {
                                answerThreeBTN.setText(s);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                answerThreeBTN.setText("An error occurred while loading answer.");
                            }
                        });

                        englishToAnyLangTranslator.translate(answerD).addOnSuccessListener(new OnSuccessListener<String>() {
                            @Override
                            public void onSuccess(String s) {
                                answerFourBTN.setText(s);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                answerFourBTN.setText("An error occurred while loading answer.");
                            }
                        });

                        exerciseControllers[0] = exerciseControllers[0] + 1;
//
//                        // find the radiobutton by returned id
                        if (!(radioGroup.getCheckedRadioButtonId() == -1)) {
                            selectedId = radioGroup.getCheckedRadioButtonId();
                            radioButton = (RadioButton) findViewById(selectedId);
                            radioButton.setChecked(false);
                        }

                    } else if (finalI[0] > 50) {

                        String finalLIString = String.valueOf(60 - finalI[0]);

                        timerTV.setText("00:0" + finalLIString);

                    } else {

                        String finalLIString = String.valueOf(60 - finalI[0]);
                        timerTV.setText("00:" + finalLIString);
                    }
                }


            };


            handler.post(runnable);

        }

        exerciseNameTV.setText(finalExerciseName);

    }


    public List<ExerciseItem> fillExerciseList(List<ExerciseItem> exerciseList){

        exerciseList.add(new ExerciseItem("1", "Exercise 1", "I spoke to ",
                ".", "she",
                "He", "Her", "We", "Her"));
        exerciseList.add(new ExerciseItem("2", "Exercise 1", "Where",
                "you come from?", "do", "are",
                "we", "them", "do"));
        exerciseList.add(new ExerciseItem("3", "Exercise 1", "What time does she",
                "up?", "gotten", "got",
                "gets", "get", "get"));
        exerciseList.add(new ExerciseItem("4", "Exercise 1", "Where",
                "he live?", "does", "do",
                "was", "is", "does"));
        exerciseList.add(new ExerciseItem("5", "Exercise 1", "I am not ",
                "this film.", "liking", "enjoying",
                "fantasizing", "driving", "enjoying"));
        exerciseList.add(new ExerciseItem("6", "Exercise 1", "I am seeing her",
                "three o'clock.", "in", "at",
                "on", "within", "at"));
        exerciseList.add(new ExerciseItem("7", "Exercise 1", "Easter is",
                "March this year", "on", "at",
                "in", "within", "in"));
        exerciseList.add(new ExerciseItem("8", "Exercise 1", "She's",
                "work all day today.", "at", "in",
                "with", "on", "at"));
        exerciseList.add(new ExerciseItem("9", "Exercise 1", "I go",
                "by bus.", "to home", "with home",
                "at home", "home", "home"));
        exerciseList.add(new ExerciseItem("10", "Exercise 1", "It's the second road ",
                "the left.", "in", "at",
                "on", "with", "on"));
        return exerciseList;
    }


    public List<ExerciseItem> fillExercise2List(List<ExerciseItem> exerciseList){

        exerciseList.add(new ExerciseItem("1", "Exercise 2", "She works",
                "Saturday.", "at",
                "to", "in", "on", "on"));
        exerciseList.add(new ExerciseItem("2", "Exercise 2", "I stay at home",
                "the morning.", "at", "to",
                "in", "on", "in"));
        exerciseList.add(new ExerciseItem("3", "Exercise 2", "How do you get to work?",
                ".", "By car", "By car",
                "By the car", "On car", "By car"));
        exerciseList.add(new ExerciseItem("4", "Exercise 2", "Do you like classical music?",
                ".", "Yes, I likes", "Yes, I like",
                "Yes, I does", "Yes, I do", "Yes, I do"));
        exerciseList.add(new ExerciseItem("5", "Exercise 2", "Where is Mary? She",
                "over there.", "is stand", "enjoying",
                "stand", "standing", "is standing"));
        exerciseList.add(new ExerciseItem("6", "Exercise 2", "I am hungry.",
                "something to eat, please.", "I like", "I'd want",
                "I'd like", "I'm like", "I'd like"));
        exerciseList.add(new ExerciseItem("7", "Exercise 2", "He",
                "born in 1963 in America.", "had", "is",
                "was", "did", "was"));
        exerciseList.add(new ExerciseItem("8", "Exercise 2", "Switzerland is",
                "than Britain.", "as small", "smallest",
                "more small", "smaller", "smaller"));
        exerciseList.add(new ExerciseItem("9", "Exercise 2", "Motor racing is the",
                "sport in the world.", "most expensive", "more expensive",
                "expensivest", "as expensive", "most expensive"));
        exerciseList.add(new ExerciseItem("10", "Exercise 2", "He passed his English exam very ",
                ".", "easy", "easier",
                "good", "easily", "easily"));

        return  exerciseList;
    }

    public List<ExerciseItem> fillExercise3List(List<ExerciseItem> exerciseList){

        exerciseList.add(new ExerciseItem("1", "Exercise 3", "When",
                "you go to the USA? Last year.", "she",
                "did", "went", "have", "did"));
        exerciseList.add(new ExerciseItem("2", "Exercise 3", "Did she stay with friends?",
                ".", "No, she didn't", "No, she didn't stay",
                "No, she didn't stayed", "No, she stayed not", "No, she didn't"));
        exerciseList.add(new ExerciseItem("3", "Exercise 3", "She has never",
                "to New York.", "gone", "was",
                "been", "went", "been"));
        exerciseList.add(new ExerciseItem("4", "Exercise 3", "I haven't got any money. Never mind. ",
                " some from the bank.", "I'll get", "I'm getting",
                "I get", "I'd get", "I'll get"));
        exerciseList.add(new ExerciseItem("5", "Exercise 3", "",
                "you ever visited London?", "Did", "Do",
                "Were", "Have", "Have"));
        exerciseList.add(new ExerciseItem("6", "Exercise 3", "I haven't got",
                ".", "no money", "money",
                "any money", "some money", "any money."));
        exerciseList.add(new ExerciseItem("7", "Exercise 3", "",
                "orange juice in the fridge.", "on", "at",
                "in", "within", "in"));
        exerciseList.add(new ExerciseItem("8", "Exercise 3","He goes to work",
                ".", "by taxi", "on taxi",
                "with taxi", "in taxi", "by taxi"));
        exerciseList.add(new ExerciseItem("9", "Exercise 3", "We haven't got",
                "mineral water.", "a lot", "little",
                "too", "much", "much"));
        exerciseList.add(new ExerciseItem("10", "Exercise 3", "Mark ",
                "fly to London tomorrow.", "to going", "goes to",
                "is going to", "go to", "is going to"));

        return  exerciseList;
    }

    public List<ExerciseItem> fillExercise4List(List<ExerciseItem> exerciseList){

        exerciseList.add(new ExerciseItem("1", "Exercise 4", "I have class",
                ".", "on Mondays",
                "in Mondays", "at Mondays", "by Mondays", "on Mondays"));
        exerciseList.add(new ExerciseItem("2", "Exercise 4", "Michael is the manager, you need to speak to",
                ".", "it", "him",
                "her", "you", "him"));
        exerciseList.add(new ExerciseItem("3", "Exercise 4", "I wanted a purple bike but they only had",
                ".", "a one green", "one green",
                "a green one", "a green", "a green one"));
        exerciseList.add(new ExerciseItem("4", "Exercise 4", "He",
                " breakfast yesterday.", "hadn't", "no had",
                "didn't have got", "didn't have", "didn't have"));
        exerciseList.add(new ExerciseItem("5", "Exercise 4","I have to go to the bank ",
                "some money.", "for getting", "to get",
                "to getting", "for to get", "to get"));
        exerciseList.add(new ExerciseItem("6", "Exercise 4", "The room was empty. There",
                "there.", "wasn't nobody", "was anybody",
                "was nobody", "was somebody", "was nobody"));
        exerciseList.add(new ExerciseItem("7", "Exercise 4", "I've lost my keys. I can't find them",
                ".", "anywhere", "nowhere",
                "nothing", "somewhere", "anywhere"));
        exerciseList.add(new ExerciseItem("8", "Exercise 4", "We can't get there by 3:00 pm. There is",
                "time.", "few", "too little",
                "too little little", "too few", "too little"));
        exerciseList.add(new ExerciseItem("9", "Exercise 4", "He arrived",
                "Heathrow airport on Friday morning.", "in", "at",
                "on", "by", "at"));
        exerciseList.add(new ExerciseItem("10", "Exercise 4", "I haven't had lunch with my mother",
                "a year.", "on", "in",
                "during", "since", "in"));

        return  exerciseList;
    }

    public List<ExerciseItem> fillExercise5List(List<ExerciseItem> exerciseList){

        exerciseList.add(new ExerciseItem("1", "Exercise 5", "There",
                "spectators at the match.", "were no",
                "weren't no", "were any", "were not", "were no"));
        exerciseList.add(new ExerciseItem("2", "Exercise 5", "The kitchen can't be dirty he",
                ".", "is just clean it", "have just cleaned it",
                "just clean it", "has just cleaned it", "has just cleaned it"));
        exerciseList.add(new ExerciseItem("3", "Exercise 5", "He's looking forward",
                "that film.", "to see", "seeing",
                "see", "to seeing", "to seeing"));
        exerciseList.add(new ExerciseItem("4", "Exercise 5", "Don't start",
                "!", "to shouting", "shouting",
                "shout", "in shouting", "shouting"));
        exerciseList.add(new ExerciseItem("5", "Exercise 5", "He works at the theatre,",
                "?", "doesn't he", "does he",
                "isn't he", "didn't he", "doesn't he"));
        exerciseList.add(new ExerciseItem("6", "Exercise 5", "Simon",
                "in Madrid since 1982.", "lives", "is living",
                "does live", "has lived", "lives"));
        exerciseList.add(new ExerciseItem("7", "Exercise 5", "Has Mr. Brown arrived",
                "?", "ever", "still",
                "now", "yet", "yet"));
        exerciseList.add(new ExerciseItem("8", "Exercise 5", "If I won the lottery, I ",
                "a house in the country.", "would buy", "have bought",
                "will buy", "would have bought", "would have bought"));
        exerciseList.add(new ExerciseItem("9", "Exercise 5", "Peter is",
                "Jane to do it at this very moment.", "telling", "saying",
                "saying to", "telling to", "telling"));
        exerciseList.add(new ExerciseItem("10", "Exercise 5", "Have you sent that fax to Mr. Smyth? Yes, I've",
                "done that.", "still", "already",
                "yet", "yet", "already"));

        return  exerciseList;
    }

    public List<ExerciseItem> fillExercise6List(List<ExerciseItem> exerciseList){

        exerciseList.add(new ExerciseItem("1", "Exercise 6", "",
                "have you been waiting?", "How long",
                "What time", "How far", "When", "How long"));
        exerciseList.add(new ExerciseItem("2", "Exercise 6", "They weren't surprised and nor",
                "I.", "weren't", "wasn't",
                "were", "was", "was"));
        exerciseList.add(new ExerciseItem("3", "Exercise 6", "I invited Mary out for a meal, but unfortunately she",
                "dinner.", "had already got", "had already had",
                "have already had", "already had", "had already had"));
        exerciseList.add(new ExerciseItem("4", "Exercise 6", "This is the cat",
                "I saw.", "whom", "which",
                "what", "who", "which"));
        exerciseList.add(new ExerciseItem("5", "Exercise 6", "",
                "is it from Barcelona to Madrid?", "How far", "How long",
                "How much", "How many", "How far"));
        exerciseList.add(new ExerciseItem("6", "Exercise 6", "You can meet me ",
                " you like.", "whenever", "soon",
                "always", "whatever", "whenever"));
        exerciseList.add(new ExerciseItem("7", "Exercise 6", "I",
                "working at night nowadays.", "used to", "used",
                "am used to", "would", "am used to"));
        exerciseList.add(new ExerciseItem("8", "Exercise 6","I have to catch the 5:00 am train tomorrow, so I",
                "go to bed late.", "needn't", "haven't",
                "have to", "mustn't", "mustn't"));
        exerciseList.add(new ExerciseItem("9", "Exercise 6",  "She",
                " go to the dentist's yesterday", "must", "had to",
                "ought to", "should have", "had to"));
        exerciseList.add(new ExerciseItem("10", "Exercise 6", "That's the",
                "of my worries, it'll never happen.", "fewer", "less",
                "last", "least", "least"));

        return  exerciseList;
    }

    public List<ExerciseItem> fillExercise7List(List<ExerciseItem> exerciseList){

        exerciseList.add(new ExerciseItem("1", "Exercise 7", "I wouldn't mind",
                "tonight.", "to go out",
                "go out", "going out", "to going out", "going out"));
        exerciseList.add(new ExerciseItem("2", "Exercise 7", "The man",
                "in the corner is my boss.", "whose", "sitting",
                "sits", "is sitting", "sitting"));
        exerciseList.add(new ExerciseItem("3", "Exercise 7", "Those cases look heavy.",
                "carry one for you? That's very nice of you", "Will I", "Do I have",
                "Shall I", "Do it", "Shall I"));
        exerciseList.add(new ExerciseItem("4", "Exercise 7", "Don't forget",
                "those letters.", "to post", "posting",
                "to posting", "post", "to post"));
        exerciseList.add(new ExerciseItem("5", "Exercise 7", "Where have you put my keys? I clearly remember",
                "them on the table last night.", "to leave", "left",
                "did leave", "leaving", "leaving"));
        exerciseList.add(new ExerciseItem("6", "Exercise 7", "You look tired. You ",
                "go to bed.", "need", "have",
                "should have", "ought to", "ought to"));
        exerciseList.add(new ExerciseItem("7", "Exercise 7", "That was a great match. I'll never forget ",
                "Ronaldo score that goal.", "see", "to see",
                "seeing", "to seeing", "seeing"));
        exerciseList.add(new ExerciseItem("8", "Exercise 7", "I thought you",
                ".", "will come to the party", "were coming to the party",
                "come to the party.", "have come to the party", "were coming to the party"));
        exerciseList.add(new ExerciseItem("9", "Exercise 7", "They",
                "last night, but I'm not sure.", "may come", "might come",
                "should come", "may have come", "may have come"));
        exerciseList.add(new ExerciseItem("10", "Exercise 7", "We",
                "better hurry up or we'll be late.", "would", "should",
                "had", "ought", "should"));

        return  exerciseList;
    }

    public List<ExerciseItem> fillExercise8List(List<ExerciseItem> exerciseList){

        exerciseList.add(new ExerciseItem("1", "Exercise 8", "She worked hard yesterday and",
                "type all the letters.", "was able to",
                "can", "could", "would be", "was able to"));
        exerciseList.add(new ExerciseItem("2", "Exercise 8", "If I ",
                "you, I'd take the risk.", "am", "have been",
                "were", "them", "were"));
        exerciseList.add(new ExerciseItem("3", "Exercise 8", "I couldn't mend the laptop myself, so I",
                "at a shop.", "had it mended", "had it mend",
                "did it mend", "had mended", "had it mended"));
        exerciseList.add(new ExerciseItem("4", "Exercise 8", "I wish I ",
                "a car, I'm tired of catching the bus.", "have", "would have",
                "had", "had had", "had"));
        exerciseList.add(new ExerciseItem("5", "Exercise 8", "He ran so fast",
                "being followed by a ghost.", "as", "as if he were",
                "like", "driving", "as if he was"));
        exerciseList.add(new ExerciseItem("6", "Exercise 8", "",
                "but I realised what he had done.", "Little did he know", "Little known",
                "Little he knew", "Little knowing", "Little he knew"));
        exerciseList.add(new ExerciseItem("7", "Exercise 8",  "If you'd come to the theatre last night, you",
                "the play.", "would enjoy", "had enjoyed",
                "would have enjoyed", "will enjoy", "would have enjoyed"));
        exerciseList.add(new ExerciseItem("8", "Exercise 8", "I know he didn't thank you, but he ",
                "have done so.", "must", "may",
                "would", "should", "should"));
        exerciseList.add(new ExerciseItem("9", "Exercise 8", "They laughed a lot last night. The film",
                "very funny.", "should have been", "must have been",
                "was to be", "should be", "must have been"));
        exerciseList.add(new ExerciseItem("10", "Exercise 8", "He wrote the programme",
                ", he didn't need anybody's help.", "by his own", "on his own",
                "on himself", "by his ownership", "on his own"));

        return  exerciseList;
    }

    public List<ExerciseItem> fillExercise9List(List<ExerciseItem> exerciseList){

        exerciseList.add(new ExerciseItem("1", "Exercise 9", "Do you ",
                "chocolate milk?", "like",
                "likes", "be like", "liked", "like"));
        exerciseList.add(new ExerciseItem("2", "Exercise 9", "He",
                "not want to go to the movies", "do", "does",
                "is", "was", "does"));
        exerciseList.add(new ExerciseItem("3", "Exercise 9", "Sorry, Lisa",
                "not here at the moment.", "am", "is",
                "was", "be", "is"));
        exerciseList.add(new ExerciseItem("4", "Exercise 9", "Where",
                "he live?", "does", "do",
                "was", "is", "does"));
        exerciseList.add(new ExerciseItem("5", "Exercise 9", "It",
                "a beautiful day today.", "is", "are",
                "am", "was", "is"));
        exerciseList.add(new ExerciseItem("6", "Exercise 9", "Sorry, Lisa",
                "not here at the moment.", "am", "is",
                "be", "was", "is"));
        exerciseList.add(new ExerciseItem("7", "Exercise 9", "They're not here. They",
                "right now.", "go to school", "swim at the beach",
                "are on holiday", "will shopping", "are on holiday"));
        exerciseList.add(new ExerciseItem("8", "Exercise 9", "Robert",
                "not go to my school.", "is", "does",
                "are", "isn't", "does"));
        exerciseList.add(new ExerciseItem("9", "Exercise 9", "My parents",
                "in a two-bedroom apartment.", "live", "lives",
                "are live", "is live", "live"));
        exerciseList.add(new ExerciseItem("10", "Exercise 9", "We",
                "European.", "do be", "are",
                "do are", "with", "are"));

        return  exerciseList;
    }

    public List<ExerciseItem> fillExercise10List(List<ExerciseItem> exerciseList){

        exerciseList.add(new ExerciseItem("1", "Exercise 10", "",
                "thinking that he would win the lottery.", "There was no use",
                "It was no point", "It was no use", "There was no use", "Her"));

        exerciseList.add(new ExerciseItem("2", "Exercise 10", "If only I had had the courage to do this",
                ".", "years back", "for years",
                "since years", "in years", "years back"));
        exerciseList.add(new ExerciseItem("3", "Exercise 10", "Let's go to the theatre, ",
                "?", "don't we", "let us",
                "shall we", "will we", "shall we"));
        exerciseList.add(new ExerciseItem("4", "Exercise 10", "By this time tomorrow we",
                "the meeting.", "will have", "will have had",
                "are having", "will had had", "will have had"));
        exerciseList.add(new ExerciseItem("5", "Exercise 10", "We'll never be able to do it\" said the man to nobody",
                ".", "especially", "specially",
                "in particular", "himself", "in particular"));
        exerciseList.add(new ExerciseItem("6", "Exercise 10", "Simon",
                "in Madrid since 1982.", "lives", "is living",
                "does live", "has lived", "lives"));
        exerciseList.add(new ExerciseItem("7", "Exercise 10", "I",
                "working at night nowadays.", "used to", "used",
                "am used to", "would", "am used to"));
        exerciseList.add(new ExerciseItem("8", "Exercise 10", "I thought you",
                ".", "will come to the party", "were coming to the party",
                "come to the party.", "have come to the party", "were coming to the party"));
        exerciseList.add(new ExerciseItem("9", "Exercise 10", "I go",
                "by bus.", "to home", "with home",
                "at home", "home", "home"));
        exerciseList.add(new ExerciseItem("10", "Exercise 10", "It's the second road ",
                "the left.", "in", "at",
                "on", "with", "on"));

        exerciseList.add(new ExerciseItem("9", "Exercise 10", "They laughed a lot last night. The film",
                "very funny.", "should have been", "must have been",
                "was to be", "should be", "must have been"));

        exerciseList.add(new ExerciseItem("10", "Exercise 10", "We",
                "better hurry up or we'll be late.", "would", "should",
                "had", "ought", "should"));

        return  exerciseList;
    }

}
