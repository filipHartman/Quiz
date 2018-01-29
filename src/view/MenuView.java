package view;

import java.util.HashMap;


public class MenuView extends View{

    private HashMap<Integer, String> mainMenu = createMainMenu();

    private HashMap<Integer,String> createMainMenu() {
        HashMap<Integer,String> mainMenu = new HashMap<Integer, String>();
        mainMenu.put(1, "Start game");
        mainMenu.put(2, "Create question");
        mainMenu.put(3, "Display highscore");
        return mainMenu;
    }

    public void dispalyMenu() {
        displayText("---QUIZMANIA---");
        for (Integer index : mainMenu.keySet()) {
            System.out.printf("%d. %s\n", index, mainMenu.get(index));
        }
        System.out.println("0. Exit");
    }
}
