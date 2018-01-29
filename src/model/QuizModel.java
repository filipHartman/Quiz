package model;

import java.util.ArrayList;

public class QuizModel {
    private ArrayList<QuizModel> questions;

    public QuizModel(ArrayList<QuizModel> questions) {
        this.questions = questions;
    }

    public void setQuestions(ArrayList<QuizModel> questions) {
        this.questions = questions;
    }

    public ArrayList<QuizModel> getQuestions() {
        return questions;
    }
}
