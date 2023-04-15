import java.util.HashMap;
import java.util.Map;

public class MapBuilder {

    public static Map<Character, Character> buildCaesarCipherMap(char[] languageArray, int key) {
        Map<Character, Character> caeserCipherMap = new HashMap<>();
        int length = languageArray.length;
        for (int i = 0; i < length; i++) {
            char c = languageArray[i];
            char encryptedChar = languageArray[(i + key) % length];
            caeserCipherMap.put(c, encryptedChar);
        }
        return caeserCipherMap;
    }

    public static Map<Character, Character> buildReverseCaesarCipherMap(Map<Character, Character> cipherMap) {
        Map<Character, Character> reverseMap = new HashMap<>();
        for (Map.Entry<Character, Character> entry : cipherMap.entrySet()) {
            char plainChar = entry.getKey();
            char encryptedChar = entry.getValue();
            reverseMap.put(encryptedChar, plainChar);
        }
        return reverseMap;
    }


}
