package com.example.languagelearningpro;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgressDashboardActivity extends AppCompatActivity {

    private TextView tvProgressSummary, tvGoals;
    private ImageView progressChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dashboard);

        tvProgressSummary = findViewById(R.id.tvProgressSummary);
        tvGoals = findViewById(R.id.tvGoals);
        progressChart = findViewById(R.id.progressChart);

        // Populate progress summary, goals, and load progress chart
    }
}

