package com.example.fitnesstrackerproject.ui;

//package com.example.fitnesstrackingapp.ui;



import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitnesstrackerproject.R;
import com.example.fitnesstrackerproject.data.Workout;
import com.example.fitnesstrackerproject.data.WorkoutDataSource;
import java.util.List;

public class recordactivity extends AppCompatActivity {

    private TextView textViewProgress;
    private WorkoutDataSource workoutDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        textViewProgress = findViewById(R.id.text_view_progress);

        workoutDataSource = new WorkoutDataSource(this);
        workoutDataSource.open();

        displayRecord();
    }

    private void displayRecord() {
        List<Workout> workouts = workoutDataSource.getAllWorkouts(); // use instance method to fetch workouts
        StringBuilder workoutText = new StringBuilder();

        for (Workout workout : workouts) {
            workoutText.append("Date: ").append(workout.getdate()) // call methods on the workout object
                    .append("\nExercise: ").append(workout.getExercise())
                    .append("\nDuration: ").append(workout.getDuration())
                    .append("\nCalories Burned: ").append(workout.getCaloriesBurned())
                    .append("\n\n");
        }

        textViewProgress.setText(workoutText.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        workoutDataSource.close();
    }
}
