package com.example.fitnesstrackerproject.data;


public class Progress {
    private int id;
    private float weight;
    private float height;

    public Progress(float weight, float height) {
        this.weight = weight;
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }
    // Getters and setters
    // ...
}
