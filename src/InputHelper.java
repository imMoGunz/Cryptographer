import java.util.Scanner;

public class InputHelper {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int KEY_MIN = 1;
    private static final int KEY_MAX = 9;
    private static final String ENG_REGEX = "^[A-Za-z\\d+\\s!,.:?\"'-]+$";
    public static final String ENCRYPT_PROMPT = "Enter text to encrypt:";
    public static final String DECRYPT_PROMPT = "Enter text to decrypt:";
    public static final String INVALID_INPUT = "Invalid input. Please enter a number between " + KEY_MIN + "-" + KEY_MAX + ".\n";

//    public static void setKey(int newKey){
//        if (newKey >= KEY_MIN && newKey <= KEY_MAX) {
//            key = newKey;
//        } else {
//            System.out.println(INVALID_INPUT);
//        }
//    }

    public static int getKey() {
        int key = 0;
        boolean validInput = false;
        do {
            System.out.println("Enter a key (" + KEY_MIN + "-" + KEY_MAX + "):");
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
        while (text.isEmpty() || !text.matches(ENG_REGEX)) {
            if (text.isEmpty()) {
                System.out.println("Error: text cannot be empty.");
            } else if (!text.matches(ENG_REGEX)) {
                System.out.println("Error: text contains invalid characters.");
            }
            text = SCANNER.nextLine();
        }
        return text;

    }
}
