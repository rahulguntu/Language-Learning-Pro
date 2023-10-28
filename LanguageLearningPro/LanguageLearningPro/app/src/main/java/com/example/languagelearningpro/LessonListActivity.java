package com.example.languagelearningpro;
import android.os.Bundle;
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

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create a list of Exercise objects
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise("Exercise 1", "Description 1"));
        exerciseList.add(new Exercise("Exercise 2", "Description 2"));
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
