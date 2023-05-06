import java.util.List;
import java.util.Map;

public class OutputHelper {

    public static String getBruteForceResults(int bestKey, int bestScore, String bestGuess) {
        return "Best key: " + bestKey + " | Score: " + bestScore + " | Best guess: " + bestGuess;
    }

    public static String getDecryptedText(String decryptedText) {
        return "Decrypted text: " + decryptedText;
    }

    //public static String getDecryptPrompt() { return "Enter text to decrypt:"; }

    public static String getEncryptPrompt() {
        return "Enter text to encrypt:";
    }

    //public static String getEncryptedText(String encryptedText) { return "Encrypted text: " + encryptedText; }

    public static String getGoodbyeMessage() {
        return "\nGoodbye, and thank you for using imMoGunz's Cryptographer!";
    }

    public static String getInputChoices() {
        String inputMethods = "1: Sample Text file\n2: User Text file\n3: User input";
        return "Enter the number of desired input method:\n" + inputMethods;
    }

    public static String getInvalidIntInput(int min, int max) {
        return "Invalid input: enter a number between " + min + "-" + max + ".\n";
    }

    public static String getInvalidTextInput() {
        return "Invalid input: text contains invalid characters.\n";
    }

    public static String getKeyRange() {
        return "Enter a key (" + Cipher.getKeyRange() + "):";
    }

    public static String getLanguageFail() {
        return "Failed to load languages: ";
    }

    public static String getLanguageOptions(List<Language> languageList) {
        return "Please enter number of desired language:\n" + Language.getLanguageOptions(languageList);
    }

    public static String getTextIsEmpty() {
        return "Invalid input: text cannot be empty.\n";
    }

    public static String getUserTextFilePathPrompt() {
        return "Enter the path of the file you want to encrypt:";
    }

    public static String getWelcomeMessage() {
        return "\nHello, and welcome to imMoGunz's Cryptographer!\n";
    }

    public static String getDecryptionChoices() {
        String method1 = "1: Keyed Decryption";
        String method2 = "2: Brute Force";
        String decryptionMethods = method1 + "\n" + method2;
        return "Enter the number of desired decryption method:\n" + decryptionMethods;
    }
}