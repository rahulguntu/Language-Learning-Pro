package com.example.languagelearningpro;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgressDashboardActivity extends AppCompatActivity {

    private TextView tvProgressSummary, tvGoals;
    private ImageView progressChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dashboard);

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

                Intent goToLoginActivity = new Intent(v.getContext(), UserLandingActivity.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

        // Populate progress summary, goals, and load progress chart
    }
}

