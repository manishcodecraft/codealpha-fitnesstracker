package com.example.fitnesstrackerproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.fitnesstrackerproject.ui.AddWorkout;
import com.example.fitnesstrackerproject.ui.SaveProgress;
import com.example.fitnesstrackerproject.ui.ViewProgressActivity;
import com.example.fitnesstrackerproject.ui.SetGoalActivity;
import com.example.fitnesstrackerproject.ui.recordactivity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnesstrackerproject.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSetGoal = findViewById(R.id.setGoalsButton);
        Button buttonAddWorkout = findViewById(R.id.addWorkoutButton);
        Button buttonSaveProgress = findViewById(R.id.saveprogressButton);
        Button buttonViewProgress = findViewById(R.id.viewProgressButton);
        Button buttonRecordWorkout = findViewById(R.id.recordButton);

        buttonSetGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SetGoalActivity.class);
                startActivity(intent);
            }
        });

        buttonAddWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddWorkout.class);
                startActivity(intent);
            }
        });

        buttonSaveProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SaveProgress.class);
                startActivity(intent);
            }
        });

        buttonViewProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewProgressActivity.class);
                startActivity(intent);
            }
        });

        buttonRecordWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, recordactivity.class);
                startActivity(intent);
            }
        });
    }
}
