package com.example.habittracker;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "habit_table")
public class Habit {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String description;
    private int frequency;

    public Habit(String title, String description, int frequency) {
        this.title = title;
        this.description = description;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}