import java.util.Arrays;

public class Language {
    private static final char[] ENG_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !,.:-?\"'$".toCharArray();
    public static final String ENG_REGEX = "^[A-Za-z\\d+\\s!,.:?\"'-]+$";
    private static final char[] ESP_ALPHABET = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789 !,.:-?\"'$".toCharArray();
    public static final String ESP_REGEX = "^[A-Za-z\\d+\\s!,.:?ñÑ\"'-]+$";



    public static char[] getAlphabet(String alphabetType) {
        switch (alphabetType) {
            case "eng" -> {
                InputHelper.regex = ENG_REGEX;
                return Arrays.copyOf(ENG_ALPHABET, ENG_ALPHABET.length);
            }
            case "esp" -> {
                InputHelper.regex = ESP_REGEX;
                return Arrays.copyOf(ESP_ALPHABET, ESP_ALPHABET.length);
            }
            default -> System.out.println("Invalid alphabet type: " + alphabetType);
        }
        return null;
    }

    public static class LanguageRules {
        
    }
}
