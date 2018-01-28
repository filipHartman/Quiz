package controller;

public class RootController {
    private MenuController menuController;
    public void runApp() {
        menuController = new MenuController();
        menuController.startGame();
    }
}
