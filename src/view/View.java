package view;

import java.util.Scanner;

public class View {
    protected Scanner scanner = new Scanner(System.in);

    public String getUserInput(String request) {
        System.out.print(request);
        return scanner.next();
    }

    public void displayText(String text) {
        System.out.println(text);
    }


    public void closeScanner() {
        scanner.close();
    }
}
