import java.io.IOException;

public class Controller {
    private static final String CIPHER_TEXT_PATH = "src/Files/ciphertext.txt";

    public void run() throws IOException {
        //System.out.println(OutputHelper.getWelcomeMessage());

        Language language = InputHelper.getValidLanguage(Language.getLanguageList());
        char[] alphabet = language.getAlphabet();
        int key = Cipher.getKey(alphabet);

        Cipher cipher = new Cipher(MapBuilder.buildCaesarCipherMap(alphabet, key), alphabet);
        Cipher reverseCipher = cipher.getReverseCipher();

        String plainText = handleInputChoice(language);
        String cipherText = cipher.encryptText(plainText);

        FileHelper.writeFile(CIPHER_TEXT_PATH, cipherText);

        handleDecryptionChoice(cipher, reverseCipher, cipherText, language);
    }

    public static String handleInputChoice(Language language) throws IOException {
        String inputChoice = InputHelper.getInputChoice();
        String plainText = "";
        switch (inputChoice) {
            case "1" -> plainText = FileHelper.readFile(FileHelper.getDefaultTxtFilePath());
            case "2" -> plainText = FileHelper.readFile(InputHelper.getUserTxtFilePath());
            case "3" -> plainText = InputHelper.getValidText(OutputHelper.getEncryptPrompt(), language);
        }
        return plainText;
    }

    public static void handleDecryptionChoice(Cipher cipher, Cipher reverseCipher, String encryptedText, Language language) {
        String decryptionChoice = InputHelper.getDecryptionChoice();
        switch (decryptionChoice) {
            case "1" -> {
                String textToDecrypt = cipher.decryptText(encryptedText);
                System.out.println(OutputHelper.getDecryptedText(textToDecrypt));
            }
            case "2" ->
                    BruteForce.initiateBruteForce(reverseCipher, encryptedText, language.getCommonWords(), language.getUncommonLetterCombos());
        }
    }

    public void exit() {
        System.out.println(OutputHelper.getGoodbyeMessage());
        InputHelper.closeScanner();
    }
}