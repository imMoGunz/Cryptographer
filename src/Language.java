import java.util.Arrays;

public class Language {
    private static final char[] EN_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !,.:-?\"'".toCharArray();

    //Allows for additional languages to be implemented.


    public static char[] getEnAlphabet() {
        return Arrays.copyOf(EN_ALPHABET, EN_ALPHABET.length);
    }





    public class LanguageRules {
        
    }
}
