package com.example.languagelearningpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExerciseListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        TextView titleListExercises = findViewById(R.id.titleListExercises);

        Intent intent = getIntent();
        String selectedLanguage = "";

        String currEmail = "";
        String currUser = "";
        String cardType = "";

        if (intent != null){

            selectedLanguage = intent.getStringExtra("selectedLanguage");
            currEmail = intent.getStringExtra("currEmail");
            currUser = intent.getStringExtra("currUser");
            cardType = intent.getStringExtra("cardType");

        }

        titleListExercises.setText(selectedLanguage + " Exercises");

        ImageButton backButton = (ImageButton)findViewById(R.id.backB);

        String finalCardType1 = cardType;
        String finalCurrUser1 = currUser;
        String finalCurrEmail1 = currEmail;
        String finalSelectedLanguage1 = selectedLanguage;
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ExerciseListActivity.this, LanguageSelectionActivity.class);
                intent.putExtra("selectedLanguage", finalSelectedLanguage1);
                intent.putExtra("currEmail", finalCurrEmail1);
                intent.putExtra("currUser", finalCurrUser1);
                intent.putExtra("cardType", finalCardType1);
                startActivity(intent);

            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

// Create a list of Lesson objects
//        List<Lesson> lessonList = new ArrayList<>();
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise("Exercise 1", "1"));
        exerciseList.add(new Exercise("Exercise 2", "2"));
        exerciseList.add(new Exercise("Exercise 3", "3"));
        exerciseList.add(new Exercise("Exercise 4", "4"));
        exerciseList.add(new Exercise("Exercise 5", "5"));
        exerciseList.add(new Exercise("Exercise 6", "6"));
        exerciseList.add(new Exercise("Exercise 7", "7"));
        exerciseList.add(new Exercise("Exercise 8", "8"));
        exerciseList.add(new Exercise("Exercise 9", "9"));
        exerciseList.add(new Exercise("Exercise 10", "10"));
// Add more lessons as needed

// Initialize the adapter with the list of lessons
        ExerciseListAdapter adapter = new ExerciseListAdapter(exerciseList);

// Set the adapter for the RecyclerView
        recyclerView.setAdapter(adapter);

// Set item click listeners to start individual lessons
        String finalSelectedLanguage = selectedLanguage;
        String finalCardType = cardType;
        String finalCurrEmail = currEmail;
        String finalCurrUser = currUser;
        adapter.setOnItemClickListener(new ExerciseListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Exercise selectedExercise = exerciseList.get(position);
                Intent intent = new Intent(ExerciseListActivity.this, CurrentExercise.class);
                intent.putExtra("selectedLanguage", finalSelectedLanguage);
                intent.putExtra("exerciseName", selectedExercise.getTitle());
                intent.putExtra("exerciseDescription", selectedExercise.getDescription());
                intent.putExtra("currEmail", finalCurrEmail);
                intent.putExtra("currUser", finalCurrUser);
                intent.putExtra("cardType", finalCardType);
                startActivity(intent);
            }
        });
    }
}


