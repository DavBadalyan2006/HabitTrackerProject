package com.example.habittracker;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HabitDao {

    @Insert
    void insert(Habit habit);

    @Update
    void update(Habit habit);

    @Delete
    void delete(Habit habit);

    @Query("DELETE FROM habit_table")
    void deleteAllHabits();

    @Query("SELECT * FROM habit_table ORDER BY title ASC")
    LiveData<List<Habit>> getAllHabits();

    @Query("SELECT * FROM habit_table WHERE id = :id")
    Habit getHabitById(int id);

}