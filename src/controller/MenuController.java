package controller;

import view.MenuView;

public class MenuController {
    private MenuView menuView = new MenuView();

    public void startGame() {
        menuView.dispalyMenu();
        String option = menuView.getUserInput("\nChoose option: ");
    }

    public void handleUserOption(String option) {

    }

    public void displayHighscore() {

    }
}
