import java.util.Map;

public class Cipher {

    private Map<Character, Character> cipherMap;
    private char[] allowedChars;

    public Cipher(Map<Character, Character> cipherMap, char[] allowedChars) {
        this.cipherMap = cipherMap;
        this.allowedChars = allowedChars.clone();
    }

    public void setKey(int newKey){
        if (newKey >= InputHelper.KEY_MIN && newKey <= InputHelper.KEY_MAX) {
            cipherMap = MapBuilder.buildCaesarCipherMap(allowedChars, newKey);
        } else {
            System.out.println(OutputHelper.printInvalidIntInput());
        }
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
        return new Cipher(reverseMap, allowedChars);
    }


    public char[] getAllowedChars() {
        return allowedChars;
    }
}

