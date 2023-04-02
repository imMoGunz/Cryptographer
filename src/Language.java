import java.util.Arrays;

public class Language {
    private static final char[] ENG_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !,.:-?\"'$".toCharArray();

    //Allows for additional languages to be implemented.


    public static char[] getAlphabet() {

        return Arrays.copyOf(ENG_ALPHABET, ENG_ALPHABET.length);
    }





    public class LanguageRules {
        
    }
}
