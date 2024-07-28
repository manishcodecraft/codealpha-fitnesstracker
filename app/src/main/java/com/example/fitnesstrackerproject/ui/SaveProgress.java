package com.example.fitnesstrackerproject.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnesstrackerproject.R;
import com.example.fitnesstrackerproject.data.Progress;
import com.example.fitnesstrackerproject.data.ProgressDataSource;

public class SaveProgress extends AppCompatActivity {
    private EditText editTextWeight;
    private EditText editTextHeight;
    private ProgressDataSource progressDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_progress);

        editTextWeight = findViewById(R.id.edit_text_weight);
        editTextHeight = findViewById(R.id.edit_text_height);
        Button buttonSaveProgress = findViewById(R.id.button_save_progress);

        progressDataSource = new ProgressDataSource(this);
        progressDataSource.open();

        buttonSaveProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();
            }
        });
    }

    private void saveProgress() {
        float weight = Float.parseFloat(editTextWeight.getText().toString());
        float height = Float.parseFloat(editTextHeight.getText().toString());

        Progress progress = new Progress(weight, height);
        progressDataSource.insertProgress(progress);

        Toast.makeText(this, "Progress saved", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        progressDataSource.close();
    }
}
