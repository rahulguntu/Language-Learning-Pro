package com.example.languagelearningpro;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class LessonListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_list);

        TextView titleListLessons = findViewById(R.id.titleListLessons);

        Intent intent = getIntent();
        String emailFromReg = "";

        if (intent != null){

            emailFromReg = intent.getStringExtra("selectedLanguage");

        }

        titleListLessons.setText(emailFromReg + " Exercises");

        ImageButton backButton = (ImageButton)findViewById(R.id.backB);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LanguageSelectionActivity.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create a list of Exercise objects
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise("Exercise 1", "Description 1"));
        exerciseList.add(new Exercise("Exercise 2", "Description 2"));
        exerciseList.add(new Exercise("Exercise 3", "Description 3"));
        exerciseList.add(new Exercise("Exercise 4", "Description 4"));
        exerciseList.add(new Exercise("Exercise 5", "Description 5"));
        exerciseList.add(new Exercise("Exercise 6", "Description 6"));
        exerciseList.add(new Exercise("Exercise 7", "Description 7"));
        exerciseList.add(new Exercise("Exercise 8", "Description 8"));
// Add more exercises as needed

// Initialize the adapter with the list of exercises
        ExerciseListAdapter adapter = new ExerciseListAdapter(exerciseList);

// Set the adapter for the RecyclerView
        recyclerView.setAdapter(adapter);

// Set item click listeners to start individual exercises
        adapter.setOnItemClickListener(new ExerciseListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Start the selected exercise, e.g., ExerciseActivity
                Exercise selectedExercise = exerciseList.get(position);
                // Implement the code to start the exercise activity with the selected exercise
            }
        });

    }
}
