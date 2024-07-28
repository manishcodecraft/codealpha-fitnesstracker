package com.example.fitnesstrackerproject.data;



public class Workout {
    private int id;
    private String date;
    private String exercise;
    private int duration;
    private int caloriesBurned;

    public Workout(String date, String exercise, int duration, int caloriesBurned) {
        this.date = date;
        this.exercise = exercise;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    public String getdate() {
        return date;
    }

    public String getExercise() {
        return exercise;
    }

    public  int getDuration() {
        return duration;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    // Getters and setters
    // ...
}
