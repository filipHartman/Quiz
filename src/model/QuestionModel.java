package model;

import java.util.HashMap;

public class QuestionModel {
    private String questionType;
    private String questionContent;
    private HashMap<char, String> answers;
    private char correctAnswerIndex;

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

    public HashMap<char, String> getAnswers() {
        return answers;
    }

    public void setAnswers(HashMap<char, String> answers) {
        this.answers = answers;
    }

    public char getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(char correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }
}
