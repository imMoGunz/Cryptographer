import java.util.Map;

public class Cipher {


    public String encryptText() {
        StringBuilder encryptedText = new StringBuilder();
        Map<Character, Character> map = MapBuilder.buildCaesarCipherMap(Language.getEnAlphabet(), (char) InputHelper.getKey());
        String textToEncrypt = InputHelper.getText();

        for (int i = 0; i < textToEncrypt.length(); i++) {
            char c = textToEncrypt.charAt(i);
            encryptedText.append(map.containsKey(c) ? map.get(c) : c);
        }

        return encryptedText.toString();
    }



}

