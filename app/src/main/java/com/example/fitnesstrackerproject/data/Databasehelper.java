package com.example.fitnesstrackerproject.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databasehelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "fitness.db";
    private static final int DATABASE_VERSION = 1;

    // Workout Table
    public static final String TABLE_WORKOUTS = "workouts";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_EXERCISE = "exercise";
    public static final String COLUMN_DURATION = "duration";
    public static final String COLUMN_CALORIES_BURNED = "calories_burned";

    // Progress Table
    public static final String TABLE_PROGRESS = "progress";
    public static final String COLUMN_WEIGHT = "weight";
    public static final String COLUMN_HEIGHT = "height";

    private static final String TABLE_WORKOUTS_CREATE =
            "CREATE TABLE " + TABLE_WORKOUTS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DATE + " TEXT, " +
                    COLUMN_EXERCISE + " TEXT, " +
                    COLUMN_DURATION + " INTEGER, " +
                    COLUMN_CALORIES_BURNED + " INTEGER" +
                    ");";

    private static final String TABLE_PROGRESS_CREATE =
            "CREATE TABLE " + TABLE_PROGRESS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_WEIGHT + " REAL, " +
                    COLUMN_HEIGHT + " REAL" +
                    ");";

    public Databasehelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_WORKOUTS_CREATE);
        db.execSQL(TABLE_PROGRESS_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROGRESS);
        onCreate(db);
    }
}
