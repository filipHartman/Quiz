package controller;

import model.QuestionModel;
import view.MenuView;
import dao.Dao;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuController {
    private MenuView menuView = new MenuView();
    private Dao dao = new Dao();

    public void startGame() {
        menuView.displayMenu();
        String option = menuView.getUserInput("\nChoose option: ");
        handleUserOption(option);
        menuView.waitForEnter();
        menuView.closeScanner();
    }

    public void handleUserOption(String option) {

        switch(option) {
            case "2":
                createQuestion();
                break;
            case "3":
                createCategory();
                break;
        }
    }

    private void createCategory() {
       dao.connectToDatabase();
       ArrayList<String> types = dao.importQuestionTypes();
       for(String type : types) menuView.displayText(type);
    }

    private void createQuestion() {
        String questionType = menuView.getUserInput("Enter type of question: ");
        String questionContent = menuView.getUserInput("Enter content of question: ");

        HashMap<String, String> answers = new HashMap<String, String>();
        answers.put("A", menuView.getUserInput("Enter first available answer: "));
        answers.put("B", menuView.getUserInput("Enter second available answer: "));
        answers.put("C", menuView.getUserInput("Enter third available answer: "));
        answers.put("D", menuView.getUserInput("Enter fourth available answer: "));

        String correctAnswerIndex = menuView.getUserInput("Enter index of correct answer: ");

        QuestionModel question = new QuestionModel(questionType, questionContent, answers, correctAnswerIndex);
        menuView.displayText(question.getQuestionType());
        menuView.displayText(question.getQuestionContent());
    }

    public void displayHighscore() {

    }
}
