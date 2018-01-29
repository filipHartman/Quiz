package view;

import java.util.Scanner;

public class View {
    protected Scanner scanner = new Scanner(System.in);
    private String ASCII_CLEAR_CONSOLE_CODE = "\033[H\033[2J";

    public String getUserInput(String request) {
        System.out.print(request);
        return scanner.nextLine();
    }

    public void displayText(String text) {
        System.out.println(text);
    }


    public void closeScanner() {
        scanner.close();
    }

    public void pauseGame () {
        int pauseTime = 1000;
        try
        {
            Thread.sleep(pauseTime);
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void clearConsole () {
        displayText(ASCII_CLEAR_CONSOLE_CODE);
    }

    public void waitForEnter() {
         getUserInput("Press enter to continue...");
    }
}
