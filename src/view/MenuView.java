package view;

import model.QuestionModel;

import java.util.HashMap;


public class MenuView extends View{

    private HashMap<Integer, String> mainMenu = createMainMenu();

    private HashMap<Integer,String> createMainMenu() {
        HashMap<Integer,String> mainMenu = new HashMap<Integer, String>();
        mainMenu.put(1, "Start game");
        mainMenu.put(2, "Create question");
        mainMenu.put(3, "Create question type");
        mainMenu.put(4, "Display highscore");
        mainMenu.put(5, "Update question");
        mainMenu.put(6, "Delete question");
        return mainMenu;
    }

    public void displayMenu() {
        clearConsole();
        displayText("---QUIZMANIA---\n");
        for (Integer index : mainMenu.keySet()) {
            System.out.printf("%d. %s\n", index, mainMenu.get(index));
        }
        System.out.println("0. Exit");
    }

    public void displayQuestion(QuestionModel question) {
        String questionContent = question.getQuestionContent();
        HashMap<String, String> answers = question.getAnswers();
        String answersToDisplay = convertAnswerMapToString(answers);
        displayText(questionContent);
        displayText(answersToDisplay);
    }

    private String convertAnswerMapToString(HashMap<String, String> answers) {
        StringBuilder sb = new StringBuilder();
        for (String answer_index : answers.keySet()) {
            sb.append(String.format("%s) %s\n", answer_index, answers.get(answer_index)));
        }
        return sb.toString();
    }
}
