package com.example.languagelearningpro;

public class LessonItem {

    private String lessonName;

    private String title;
    private String description;

    private int id;

    // creating getter and setter methods
    public String getLessonName() { return lessonName; }

    public void setLessonName(String lessonName)
    {
        this.lessonName = lessonName;
    }


    public String getTitle() { return title; }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription() { return description; }

    public void setDescription(String description)
    {
        this.description = description;
    }



    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public LessonItem(String id, String lessonName,
                String title,
                String description)
    {
        this.id = Integer.parseInt(id);
        this.lessonName = lessonName;
        this.title = title;
        this.description = description;


    }
}
