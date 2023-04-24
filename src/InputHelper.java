import java.util.Map;
import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

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
                    System.out.println(OutputHelper.getInvalidIntInput(min, max));
                }
            } catch (NumberFormatException e) {
                System.out.println(OutputHelper.getInvalidIntInput(min, max));
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
                System.out.println(OutputHelper.getTextIsEmpty());
            } else if (isInvalidText(text, language.getRegex())) {
                System.out.println(OutputHelper.getInvalidTextInput());
            }
        } while (text.isEmpty() || isInvalidText(text, language.getRegex()));
        return text;
    }

    public static Language getValidLanguage(Map<String, Language> languageMap) {
        Scanner scanner = new Scanner(System.in);
        String languageChoice = "";

        while (!languageMap.containsKey(languageChoice)) {
            System.out.println(OutputHelper.getLanguageOptions(languageMap));
            languageChoice = scanner.nextLine().trim();

            if (!languageMap.containsKey(languageChoice)) {
                System.out.println(OutputHelper.getInvalidIntInput(1, languageMap.size()));
            }
        }

        return languageMap.get(languageChoice);
    }

    public static String getInputChoice(){
        int min = 1;
        int max = 3;
        String prompt = OutputHelper.getInputChoices();
        int choice = getIntInput(prompt, min, max);
        return Integer.toString(choice);
    }

    public static String getUserTxtFilePath() {
        System.out.println(OutputHelper.getUserTextFilePathPrompt());
        String filePath = scanner.nextLine().trim();
        while (!FileHelper.isValidTextFile(filePath)) {
            System.out.println("The specified file path is invalid. Please try again:");
            filePath = scanner.nextLine().trim();
        }
        return filePath;
    }

    public static String getDecryptionChoice() {
        int min = 1;
        int max = 2;
        String prompt = OutputHelper.getDecryptionChoices();
        int choice = getIntInput(prompt, min, max);
        return Integer.toString(choice);
    }

    public static void closeScanner() {
        scanner.close();
    }
}