import java.util.Scanner;

public class InputHelper {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final int KEY_MIN = 1;
    public static final int KEY_MAX = 9;
    private static final String KEY_RANGE = KEY_MIN + "-" + KEY_MAX;
    public static String regex;
    public static final String ENCRYPT_PROMPT = "Enter text to encrypt:";
    public static final String DECRYPT_PROMPT = "Enter text to decrypt:";
    public static final String INVALID_INPUT = "Invalid input. Please enter a number between " + KEY_RANGE + ".\n";


    public static int getKey() {
        int key = 0;
        boolean validInput = false;
        do {
            System.out.println("Enter a key (" + KEY_RANGE + "):");
            String input = SCANNER.nextLine().trim();
            if (!input.isEmpty() && input.matches("\\d+")) {
                key = Integer.parseInt(input);
                if (key >= KEY_MIN && key <= KEY_MAX) {
                    validInput = true;
                } else {
                    System.out.println(INVALID_INPUT);
                }
            } else {
                System.out.println(INVALID_INPUT);
            }
        } while (!validInput);
        return key;
    }

    public static String getText(String prompt) {
        System.out.println(prompt);
        String text = SCANNER.nextLine();
        while (text.isEmpty() || !text.matches(regex)) {
            if (text.isEmpty()) {
                System.out.println("Error: text cannot be empty.");
            } else if (!text.matches(regex)) {
                System.out.println("Error: text contains invalid characters.");
            }
            text = SCANNER.nextLine();
        }
        return text;

    }
}
