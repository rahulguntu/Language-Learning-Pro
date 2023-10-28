package com.example.languagelearningpro;

public class Exercise {
    private String title;
    private String description;

    public Exercise(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getters and setters for title and description
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

