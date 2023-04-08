package com.example.habittracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class HabitTrackingActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private HabitAdapter mAdapter;
    private TextView mEmptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracking);

        // Set up the RecyclerView
        mRecyclerView = findViewById(R.id.habit_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mEmptyTextView = findViewById(R.id.empty_text_view);

        // Get the habits from the database
        List<Habit> habits = HabitDatabase.getInstance(this).habitDao().getHabits();

        // Set up the adapter
        if (habits != null && habits.size() > 0) {
            mAdapter = new HabitAdapter(habits);
            mRecyclerView.setAdapter(mAdapter);
            mEmptyTextView.setText("");
        } else {
            mEmptyTextView.setText(getString(R.string.no_habits_created));
        }

        // Set up the "Create New Habit" button
        Button createHabitButton = findViewById(R.id.create_habit_button);
        createHabitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HabitTrackingActivity.this, HabitCreationActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Refresh the list of habits when the activity is resumed
        List<Habit> habits = HabitDatabase.getInstance(this).habitDao().getHabits();
        mAdapter.setHabits(habits);

        // Show the empty text view if there are no habits
        if (habits == null || habits.size() == 0) {
            mEmptyTextView.setText(getString(R.string.no_habits_created));
        } else {
            mEmptyTextView.setText("");
        }
    }
}