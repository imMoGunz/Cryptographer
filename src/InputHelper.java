import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getKey() {
        int key = 0;
        boolean validInput = false;
        do {
            System.out.println("Enter a key (1-9):");
            try {
            key = scanner.nextInt();
            validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer between 1-9.");
                scanner.next();
            }
        } while (!validInput || key < 1 || key > 9);
        return key;
    }

    public static String getText() {
        System.out.println("Enter text to encrypt:");
        String text = scanner.nextLine();
        while (text.isEmpty() || !text.matches("^[A-Za-z\\s.,!?']+$")) {
            text = scanner.nextLine();
            if (text.isEmpty()) {
                System.out.println("Error: text cannot be empty.");
            } else if (!text.matches("^[A-Za-z\\s.,!?']+$")) {
                System.out.println("Error: text contains invalid characters.");
                text = null;
            }
        }
        return text;
    }
}
