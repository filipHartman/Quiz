package view;

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
}
