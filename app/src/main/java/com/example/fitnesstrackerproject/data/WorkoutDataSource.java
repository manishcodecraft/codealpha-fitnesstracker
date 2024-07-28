package com.example.fitnesstrackerproject.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fitnesstrackerproject.data.Databasehelper;

import java.util.ArrayList;
import java.util.List;

public class WorkoutDataSource {
    private SQLiteDatabase database;
    private Databasehelper dbHelper;
    private String[] allColumns = {
            Databasehelper.COLUMN_ID,
            Databasehelper.COLUMN_DATE,
            Databasehelper.COLUMN_EXERCISE,
            Databasehelper.COLUMN_DURATION,
            Databasehelper.COLUMN_CALORIES_BURNED
    };

    public WorkoutDataSource(Context context) {
        dbHelper = new Databasehelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void insertWorkout(Workout workout) {
        ContentValues values = new ContentValues();
        values.put(Databasehelper.COLUMN_DATE, workout.getdate());
        values.put(Databasehelper.COLUMN_EXERCISE, workout.getExercise());
        values.put(Databasehelper.COLUMN_DURATION, workout.getDuration());
        values.put(Databasehelper.COLUMN_CALORIES_BURNED, workout.getCaloriesBurned());
        database.insert(Databasehelper.TABLE_WORKOUTS, null, values);
    }

    public List<Workout> getAllWorkouts() {
        List<Workout> workouts = new ArrayList<>();
        Cursor cursor = database.query(Databasehelper.TABLE_WORKOUTS, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Workout workout = cursorToWorkout(cursor);
            workouts.add(workout);
            cursor.moveToNext();
        }
        cursor.close();
        return workouts;
    }

    private Workout cursorToWorkout(Cursor cursor) {
        return new Workout(
                cursor.getString(1),
                cursor.getString(2),
                cursor.getInt(3),
                cursor.getInt(4)
        );
    }
}
