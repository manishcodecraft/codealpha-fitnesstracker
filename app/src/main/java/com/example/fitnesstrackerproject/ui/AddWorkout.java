package com.example.fitnesstrackerproject.ui;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnesstrackerproject.R;
import com.example.fitnesstrackerproject.data.Workout;
import com.example.fitnesstrackerproject.data.WorkoutDataSource;

import java.time.ZoneId;

public class AddWorkout extends AppCompatActivity {

    private EditText dateworkout;
    private EditText editTextExercise;
    private EditText editTextDuration;
    private EditText editTextCaloriesBurned;
    private WorkoutDataSource workoutDataSource;
    private String date;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addexercise);

        dateworkout=findViewById(R.id.dateworkout);
        editTextExercise = findViewById(R.id.edit_text_exercise);
        editTextDuration = findViewById(R.id.edit_text_duration);
        editTextCaloriesBurned = findViewById(R.id.edit_text_calories_burned);
        Button buttonSaveWorkout = findViewById(R.id.button_save_workout);

        workoutDataSource = new WorkoutDataSource(this);
        workoutDataSource.open();

        buttonSaveWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveWorkout();
            }
        });
    }

    private void saveWorkout() {
        String exercise = editTextExercise.getText().toString();
        int duration = Integer.parseInt(editTextDuration.getText().toString());
        int caloriesBurned = Integer.parseInt(editTextCaloriesBurned.getText().toString());

        Workout workout = new Workout(date,exercise, duration, caloriesBurned);
        workoutDataSource.insertWorkout(workout);

        Toast.makeText(this, "Workout saved", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        workoutDataSource.close();
    }
}
