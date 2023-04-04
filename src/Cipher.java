import java.util.Map;

public class Cipher {

    Map<Character, Character> map;
    char[] allowedChars;

    public Cipher(char[] allowedChars, int key) {
        this.allowedChars = allowedChars;
        map = MapBuilder.buildCaesarCipherMap(allowedChars, key);
    }

    public void setKey(int newKey){
        if (newKey >= InputHelper.KEY_MIN && newKey <= InputHelper.KEY_MAX) {
            this.map = MapBuilder.buildCaesarCipherMap(allowedChars, newKey);
        } else {
            System.out.println(InputHelper.INVALID_INPUT);
        }
    }

    public String encryptText(String textToEncrypt) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < textToEncrypt.length(); i++) {
            char c = textToEncrypt.charAt(i);
            encryptedText.append(map.getOrDefault(c, c));
        }

        return encryptedText.toString();
    }

    public String decryptText(String textToDecrypt) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < textToDecrypt.length(); i++) {
            char c = textToDecrypt.charAt(i);
            char decryptedChar = c;
            for (Map.Entry<Character, Character> entry : map.entrySet()) {
                if (entry.getValue().equals(c)) {
                    decryptedChar = entry.getKey();
                    break;
                }
            }
            decryptedText.append(decryptedChar);
        }
        return decryptedText.toString();
    }
}

