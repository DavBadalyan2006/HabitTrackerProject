package com.example.habittracker;

import android.provider.BaseColumns;

public final class HabitContract {

    private HabitContract() {}

    public static class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "habits";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_FREQUENCY = "frequency";
        public static final String COLUMN_START_DATE = "start_date";
        public static final String COLUMN_TARGET_DATE = "target_date";
    }

}