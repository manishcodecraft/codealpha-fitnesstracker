package com.example.fitnesstrackerproject.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnesstrackerproject.R;
import com.example.fitnesstrackerproject.data.Progress;
import com.example.fitnesstrackerproject.data.ProgressDataSource;

import java.util.List;

public class ViewProgressActivity extends AppCompatActivity {
    private TextView textViewProgress;
    private ProgressDataSource progressDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_progress);

        textViewProgress = findViewById(R.id.text_view_progress);

        progressDataSource = new ProgressDataSource(this);
        progressDataSource.open();

        displayProgress();
    }

    private void displayProgress() {
        List<Progress> progressList = progressDataSource.getAllProgress();
        StringBuilder progressText = new StringBuilder();

        for (Progress progress : progressList) {
            progressText.append("Weight: ").append(progress.getWeight()).append(" kg")
                    .append("\nHeight: ").append(progress.getHeight()).append(" cm")
                    .append("\n\n");
        }

        textViewProgress.setText(progressText.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        progressDataSource.close();
    }
}
