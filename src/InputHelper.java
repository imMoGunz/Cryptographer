import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);
    private static int keyMin = 1;
    private static int keyMax = 9;

    public static int getKey() {
        int key = 0;
        boolean validInput = false;
        do {
            System.out.println("Enter a key (" + keyMin + "-" + keyMax + "):");
            try {
            key = scanner.nextInt();
            validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer between " + keyMin + "-" + keyMax + ".");
                scanner.next();
            }
        } while (!validInput || key < keyMin || key > keyMax);
        return key;
    }

    public static String getText() {
        System.out.println("Enter text to encrypt:");
        String text = scanner.nextLine();
        while (text.isEmpty() || !text.matches("^[A-Za-z0-9\\s!,.:?\"'-]+$")) {
            text = scanner.nextLine().toUpperCase();
            if (text.isEmpty()) {
                System.out.println("Error: text cannot be empty.");
            } else if (!text.matches("^[A-Za-z0-9\\s!,.:?\"'-]+$")) {
                System.out.println("Error: text contains invalid characters.");
                text = "";
            }
        }
        return text;

    }
}
