package com.example.habittracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class HabitProgressActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private HabitProgressAdapter mAdapter;
    private TextView mEmptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_progress);

        // Set up the RecyclerView
        mRecyclerView = findViewById(R.id.habit_progress_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mEmptyTextView = findViewById(R.id.empty_text_view);

        // Get the habits from the database
        List<Habit> habits = HabitDatabase.getInstance(this).habitDao().getHabits();

        // Set up the adapter
        if (habits != null && habits.size() > 0) {
            mAdapter = new HabitProgressAdapter(habits);
            mRecyclerView.setAdapter(mAdapter);
            mEmptyTextView.setText("");
        } else {
            mEmptyTextView.setText(getString(R.string.no_habits_created));
        }
    }
}