import java.util.Map;
import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);
    public static final int KEY_MIN = 1;
    public static final int KEY_MAX = 9;
    private static final String KEY_RANGE = KEY_MIN + "-" + KEY_MAX;


    public static int getIntInput(String prompt, int min, int max) {
        int input = 0;
        boolean validInput = false;
        do {
            System.out.println(prompt);
            String inputString = scanner.nextLine().trim();
            try {
                input = Integer.parseInt(inputString);
                if (input >= min && input <= max) {
                    validInput = true;
                } else {
                    System.out.println(OutputHelper.printInvalidIntInput());
                }
            } catch (NumberFormatException e) {
                System.out.println(OutputHelper.printInvalidIntInput());
            }
        } while (!validInput);
        return input;
    }

    public static boolean isInvalidText(String text, String regex) {
        return !text.matches(regex);
    }

    public static String getValidText(String prompt, Language language) {
        String text;
        do {
            System.out.println(prompt);
            text = scanner.nextLine().trim();
            if (text.isEmpty()) {
                System.out.println(OutputHelper.printTextIsEmpty());
            } else if (isInvalidText(text, language.getRegex())) {
                System.out.println(OutputHelper.printInvalidTextInput());
            }
        } while (text.isEmpty() || isInvalidText(text, language.getRegex()));
        return text;
    }

    public static Language getValidLanguage(Map<String, Language> languageMap) {
        Scanner scanner = new Scanner(System.in);
        String languageChoice = "";

        while (!languageMap.containsKey(languageChoice)) {
            System.out.println(OutputHelper.printLanguageOptions(languageMap));
            languageChoice = scanner.nextLine().trim();

            if (!languageMap.containsKey(languageChoice)) {
                System.out.println(OutputHelper.printInvalidLanguageInput());
            }
        }

        return languageMap.get(languageChoice);
    }


    public static String getKeyRange() {
        return KEY_RANGE;
    }

    public static int getKey() {

        return getIntInput("Enter a key (" + getKeyRange() + "):", KEY_MIN, KEY_MAX);
    }

    public static void closeScanner() {
        scanner.close();
    }
}