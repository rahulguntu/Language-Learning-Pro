package com.example.languagelearningpro;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LessonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        // Retrieve Lesson data (e.g., from Intent or your data source)
        String lessonTitle = "Sample Lesson Title";
        String lessonContent = "This is a sample lesson content. Replace it with your actual lesson content.";

        // Initialize UI elements
        TextView titleTextView = findViewById(R.id.lessonTitle);
        TextView contentTextView = findViewById(R.id.lessonContent);

        // Set the lesson title and content to the TextViews
        titleTextView.setText(lessonTitle);
        contentTextView.setText(lessonContent);
    }
}

