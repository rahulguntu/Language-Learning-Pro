package com.example.languagelearningpro;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletedExerciseActivity extends AppCompatActivity {

    public Handler handler;

    public Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_exercise);

        Intent intent = getIntent();
        String currEmail = "";
        String currUser = "";
        String cardType = "";

        if (intent != null){

            currEmail = intent.getStringExtra("currEmail");
            currUser = intent.getStringExtra("currUser");
            cardType = intent.getStringExtra("cardType");


        }

        final RelativeLayout relativeLayout;

        relativeLayout = findViewById(R.id.congratsLayout);

        final int[] counter = {0};
        handler = new Handler();
        String finalCardType = cardType;
        String finalCurrUser = currUser;
        String finalCurrEmail = currEmail;
        runnable = new Runnable() {
            @Override
            public void run() {


                handler.postDelayed(this, 1500L);// 1 second delay

                if (counter[0] %2 == 0){

                    relativeLayout.setBackgroundResource(R.color.white);

                    if (counter[0] == 6) {

                        Intent intent = new Intent(CompletedExerciseActivity.this, UserLandingActivity.class);
                        intent.putExtra("currEmail", finalCurrEmail);
                        intent.putExtra("currUser", finalCurrUser);
                        intent.putExtra("cardType", finalCardType);
                        startActivity(intent);

                        handler.removeCallbacks(runnable);
                        finish();
                    }

                }else if (counter[0] %2 == 1){

                    relativeLayout.setBackgroundResource(R.color.textPurple);

                    if (counter[0] == 6) {

                        Intent intent = new Intent(CompletedExerciseActivity.this, UserLandingActivity.class);
                        intent.putExtra("currEmail", finalCurrEmail);
                        intent.putExtra("currUser", finalCurrUser);
                        intent.putExtra("cardType", finalCardType);
                        startActivity(intent);

                        handler.removeCallbacks(runnable);
                        finish();
                    }

                }

                counter[0] = counter[0] + 1;

            }



        };



        handler.post(runnable);
    }
}
