package model;

import java.util.HashMap;

public class QuestionModel {
    private String questionType;
    private String questionContent;
    private HashMap<String, String> answers;
    private String correctAnswerIndex;

    public QuestionModel(String questionType, String questionContent, HashMap<String, String> answers, String correctAnswerIndex) {
        this.questionType = questionType;
        this.questionContent = questionContent;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public HashMap<String, String> getAnswers() {
        return answers;
    }

    public void setAnswers(HashMap<String, String> answers) {
        this.answers = answers;
    }

    public String getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(String correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }
}
