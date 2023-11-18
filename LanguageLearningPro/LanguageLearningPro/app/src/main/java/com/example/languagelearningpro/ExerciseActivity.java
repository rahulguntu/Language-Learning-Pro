package com.example.languagelearningpro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ExerciseActivity extends AppCompatActivity {

    private TextView tvExerciseContent;
    private RadioGroup radioGroup;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        tvExerciseContent = findViewById(R.id.tvExerciseContent);
        radioGroup = findViewById(R.id.radioGroup);
        btnSubmit = findViewById(R.id.btnSubmit);

       
        // Populate exercise content and answer choices based on the selected exercise

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the selected answer and check correctness
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

                if (selectedRadioButton != null) {
                    String selectedAnswer = selectedRadioButton.getText().toString();

                    // Check correctness and provide feedback
                }
            }
        });
    }
}

