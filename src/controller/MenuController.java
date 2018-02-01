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
        menuView.clearConsole();
        switch(option) {
            case "1":
                startQuiz();
                break;
            case "2":
                createQuestion();
                break;
            case "3":
                createQuestionType();
                break;
        }
    }

    private void startQuiz() {
        dao.connectToDatabase();
        ArrayList<QuestionModel> randomQuestionsForQuiz = getRandomQuestions();
        for (QuestionModel question : randomQuestionsForQuiz) {
            System.out.println(question.getQuestionContent());
        }
    }

    private ArrayList<QuestionModel> getRandomQuestions() {
        ArrayList<QuestionModel> allQuestions = dao.importAllQuestionsFromDb();

        ArrayList<Integer> randomQuestionIds = generateRandomIds(allQuestions);
        ArrayList<QuestionModel> randomQuestionsForQuiz = new ArrayList<>();
        for(int id: randomQuestionIds) {
            QuestionModel question = allQuestions.get(id);
            randomQuestionsForQuiz.add(question);
        }
        return randomQuestionsForQuiz;
    }

    private ArrayList<Integer> generateRandomIds(ArrayList<QuestionModel> allQuestions) {
        ArrayList<Integer> drawnIds = new ArrayList<>();
        int numberOfQuestions = allQuestions.size();
        int numberOfDraws = 3;
        for (int i = 0; i < numberOfDraws; i++) {
            int id = (int)(Math.random() * numberOfQuestions);
            while(drawnIds.contains(id)){
                id = (int)(Math.random() * numberOfQuestions);
            }
            drawnIds.add(id);
        }
        return drawnIds;
    }

    private void createQuestionType() {
        dao.connectToDatabase();

        String typeName = menuView.getUserInput("Enter name of new question type: ");
        dao.exportNewTypeToDb(typeName);
        HashMap<Integer, String> types = dao.importQuestionTypes();
        for(Integer typeId : types.keySet()) System.out.printf("%d. %s\n", typeId, types.get(typeId));
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
