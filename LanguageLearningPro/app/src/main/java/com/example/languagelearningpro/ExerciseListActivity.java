package com.example.languagelearningpro;

import android.os.Bundle;
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

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

// Create a list of Lesson objects
        List<Lesson> lessonList = new ArrayList<>();
        lessonList.add(new Lesson("Lesson 1", "Description 1"));
        lessonList.add(new Lesson("Lesson 2", "Description 2"));
// Add more lessons as needed

// Initialize the adapter with the list of lessons
        LessonListAdapter adapter = new LessonListAdapter(lessonList);

// Set the adapter for the RecyclerView
        recyclerView.setAdapter(adapter);

// Set item click listeners to start individual lessons
        adapter.setOnItemClickListener(new LessonListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Start the selected lesson, e.g., LessonActivity
                Lesson selectedLesson = lessonList.get(position);
                // Implement the code to start the lesson activity with the selected lesson
            }
        });
    }
}


