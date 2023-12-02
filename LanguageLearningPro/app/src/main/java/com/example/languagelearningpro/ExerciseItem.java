package com.example.languagelearningpro;

public class ExerciseItem {
    private String exerciseName;

    private String questionPartA;

    private String questionPartB;

    private String answerOne;

    private String answerTwo;

    private String answerThree;

    private String answerFour;

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getQuestionPartA() {
        return questionPartA;
    }

    public void setQuestionPartA(String questionPartA) {
        this.questionPartA = questionPartA;
    }

    public String getQuestionPartB() {
        return questionPartB;
    }

    public void setQuestionPartB(String questionPartB) {
        this.questionPartB = questionPartB;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo;
    }

    public String getAnswerThree() {
        return answerThree;
    }

    public void setAnswerThree(String answerThree) {
        this.answerThree = answerThree;
    }

    public String getAnswerFour() {
        return answerFour;
    }

    public void setAnswerFour(String answerFour) {
        this.answerFour = answerFour;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String correctAnswer;

    private int id;


    public ExerciseItem(String id, String exerciseName,
                      String questionPartA,String questionPartB,
                      String answerOne, String answerTwo, String answerThree, String answerFour,
                        String correctAnswer)
    {
        this.id = Integer.parseInt(id);
        this.exerciseName = exerciseName;
        this.questionPartA = questionPartA;
        this.questionPartB = questionPartB;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.answerThree = answerThree;
        this.answerFour = answerFour;
        this.correctAnswer = correctAnswer;



    }
}
