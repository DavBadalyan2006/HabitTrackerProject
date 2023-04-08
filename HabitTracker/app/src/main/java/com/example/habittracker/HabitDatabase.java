package com.example.habittracker;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.habittracker.Habit;

@Database(entities = {Habit.class}, version = 1)
public abstract class HabitDatabase extends RoomDatabase {

    private static volatile HabitDatabase INSTANCE;

    public abstract HabitDao habitDao();

    public static HabitDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (HabitDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    HabitDatabase.class, "habit_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}