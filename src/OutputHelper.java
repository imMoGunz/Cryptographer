import java.util.Map;

public class OutputHelper {
    public static String printWelcomeMessage() {

        return "Welcome to imMoGunz's Cryptographer!";
    }
    public static String printLanguageOptions(Map<String, Language> languageMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Please enter a number to choose a language:\n");
        int i = 1;
        for (Map.Entry<String, Language> entry : languageMap.entrySet()) {
            stringBuilder.append(i++).append(": ").append(entry.getValue().getName());
            if (i <= languageMap.size()) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }


    public static String getEncryptPrompt() {
        return "Enter text to encrypt:";
    }

    public static String getDecryptPrompt() {
        return "Enter text to decrypt:";
    }


    public static String printEncryptedText(String encryptedText) {
        return "Encrypted text: " + encryptedText;
    }

    public static String printDecryptedText(String decryptedText) {
        return "Decrypted text: " + decryptedText;
    }

    public static String printTextIsEmpty() {

        return "Invalid input: text cannot be empty.\n";
    }
    public static String printInvalidTextInput() {

        return "Invalid input: text contains invalid characters.\n";
    }

    public static String printInvalidIntInput() {
        return "Invalid input: enter a number between " + InputHelper.getKeyRange() + ".\n";
    }
    public static String printInvalidLanguageInput() {
        return "Invalid input: Please try again.\n";
    }

    public static String printGoodbyeMessage() {

        return "Thank you for using imMoGunz's Cryptographer!";
    }


}


