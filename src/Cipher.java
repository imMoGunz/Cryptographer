import java.util.Map;

public class Cipher {

    private static final int KEY_MIN = 1;
    private static int keyMax = 9;

    private Map<Character, Character> cipherMap;
    private final char[] ALLOWED_CHARS;

    public Cipher(Map<Character, Character> cipherMap, char[] ALLOWED_CHARS) {
        this.cipherMap = cipherMap;
        this.ALLOWED_CHARS = ALLOWED_CHARS.clone();
    }

    public static int getKeyMin() {
        return KEY_MIN;
    }

    public static int getKeyMax() {
        return keyMax;
    }

    public static void setKeyMax(int newKeyMax) {
        keyMax = newKeyMax - 1;

    }

    public void setKey(int newKey){
        if (newKey >= KEY_MIN && newKey <= keyMax) {
            cipherMap = MapBuilder.buildCaesarCipherMap(ALLOWED_CHARS, newKey);
        } else {
            System.out.println(OutputHelper.getInvalidIntInput(KEY_MIN, keyMax));
        }
           }
    public static int getKey(char[] alphabet) {
        Cipher.setKeyMax(alphabet.length);
        return InputHelper.getIntInput(OutputHelper.getKeyRange(), KEY_MIN, keyMax);
    }
    public static String getKeyRange() {
        return KEY_MIN + "-" + keyMax;
    }
    public String encryptText(String textToEncrypt) {
        char[] encryptedText = new char[textToEncrypt.length()];

        for (int i = 0; i < textToEncrypt.length(); i++) {
            char c = textToEncrypt.charAt(i);
            encryptedText[i] = cipherMap.getOrDefault(c, c);
        }

        return new String(encryptedText);
    }

public String decryptText(String textToDecrypt) {
    StringBuilder decryptedText = new StringBuilder();

    for (int i = 0; i < textToDecrypt.length(); i++) {
        char c = textToDecrypt.charAt(i);
        char decryptedChar = c;
        for (Map.Entry<Character, Character> entry : cipherMap.entrySet()) {
            if (entry.getValue().equals(c)) {
                decryptedChar = entry.getKey();
                break;
            }
        }
        decryptedText.append(decryptedChar);
    }
    return decryptedText.toString();
}
    public Cipher getReverseCipher() {
        Map<Character, Character> reverseMap = MapBuilder.buildReverseCaesarCipherMap(cipherMap);
        return new Cipher(reverseMap, ALLOWED_CHARS);
    }
}