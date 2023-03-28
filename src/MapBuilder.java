import java.util.HashMap;
import java.util.Map;

public class MapBuilder {

    public static Map<Character, Character> buildCaesarCipherMap(char[] languageArray, char key) {
        Map<Character, Character> caeserCipherMap = new HashMap<>();
        int length = languageArray.length;
        for (int i = 0; i < length; i++) {
            char c = languageArray[i];
            char encryptedChar = languageArray[(i + key) % length];
            caeserCipherMap.put(c, encryptedChar);
        }
        return caeserCipherMap;
    }
}
