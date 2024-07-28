package com.example.fitnesstrackerproject.data;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProgressDataSource {
    private SQLiteDatabase database;
    private Databasehelper dbHelper;
    private String[] allColumns = {
            Databasehelper.COLUMN_ID,
            Databasehelper.COLUMN_WEIGHT,
            Databasehelper.COLUMN_HEIGHT
    };

    public ProgressDataSource(Context context) {
        dbHelper = new Databasehelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void insertProgress(Progress progress) {
        ContentValues values = new ContentValues();
        values.put(Databasehelper.COLUMN_WEIGHT, progress.getWeight());
        values.put(Databasehelper.COLUMN_HEIGHT, progress.getHeight());
        database.insert(Databasehelper.TABLE_PROGRESS, null, values);
    }

    public List<Progress> getAllProgress() {
        List<Progress> progressList = new ArrayList<>();
        Cursor cursor = database.query(Databasehelper.TABLE_PROGRESS, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Progress progress = cursorToProgress(cursor);
            progressList.add(progress);
            cursor.moveToNext();
        }
        cursor.close();
        return progressList;
    }

    private Progress cursorToProgress(Cursor cursor) {
        return new Progress(
                cursor.getFloat(1),
                cursor.getFloat(2)
        );
    }
}
