package com.example.habittracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HabitCreationActivity extends AppCompatActivity {

    private HabitDao habitDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_creation);

        // Initialize the habitDao
        habitDao = HabitDatabase.getInstance(this).habitDao();

        // Get references to the EditText and Button views
        final EditText habitNameEditText = findViewById(R.id.habit_name_edit_text);
        Button createHabitButton = findViewById(R.id.create_habit_button);

        // Set an OnClickListener for the createHabitButton
        createHabitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the habit name from the EditText view
                String habitName = habitNameEditText.getText().toString();

                // Check if the habit name is not empty
                if (!habitName.isEmpty()) {
                    // Create a new Habit object and insert it into the database
                    Habit habit = new Habit(habitName);
                    habitDao.insertHabit(habit);

                    // Show a toast message to indicate that the habit was created
                    Toast.makeText(HabitCreationActivity.this, "Habit created successfully", Toast.LENGTH_SHORT).show();

                    // Finish the activity
                    finish();
                } else {
                    // Show an error toast message if the habit name is empty
                    Toast.makeText(HabitCreationActivity.this, "Please enter a habit name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}