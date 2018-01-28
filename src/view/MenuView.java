package view;

import java.util.HashMap;
import java.util.Scanner;


public class MenuView {
    private Scanner scanner = new Scanner(System.in);
    private HashMap<Integer, String> mainMenu = createMainMenu();

    private HashMap<Integer,String> createMainMenu() {
        HashMap<Integer,String> mainMenu = new HashMap<Integer, String>();
        mainMenu.put(1, "Start game");
        mainMenu.put(2, "Create question");
        mainMenu.put(3, "Display highscore");
        mainMenu.put(0, "Exit");
        return mainMenu;
    }

    public void displayText(String text) {
        System.out.println(text);
    }

    public String getUserInput(String request) {
        System.out.print(request);
        return scanner.next();
    }

    public void dispalyMenu() {

    }
}
