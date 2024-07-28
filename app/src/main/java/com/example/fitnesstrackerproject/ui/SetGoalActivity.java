package com.example.fitnesstrackerproject.ui;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnesstrackerproject.R;

public class SetGoalActivity extends AppCompatActivity {
    private EditText goaltext;
    private Button buttonsaveGoal;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setgoal);

       goaltext = findViewById(R.id.goaltext);
        Button buttonSaveGoal = findViewById(R.id.button_save_goal);

        buttonSaveGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveGoal();
            }
        });
    }

    private void saveGoal() {
        String goal = goaltext.getText().toString();
        // Save the goal to shared preferences, database, or any storage as needed
        Toast.makeText(this, "Goal saved", Toast.LENGTH_SHORT).show();
        finish();
    }
}
