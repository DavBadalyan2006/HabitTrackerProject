package com.example.habittracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start the HabitCreationActivity when the "Create Habit" button is clicked
        Button createHabitButton = findViewById(R.id.create_habit_button);
        createHabitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HabitCreationActivity.class);
                startActivity(intent);
            }
        });

        // Start the HabitTrackingActivity when the "Track Habits" button is clicked
        Button trackHabitsButton = findViewById(R.id.track_habits_button);
        trackHabitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HabitTrackingActivity.class);
                startActivity(intent);
            }
        });
    }
}