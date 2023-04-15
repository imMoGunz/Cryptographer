

public class Main {
    public static void main(String[] args) {
        System.out.println(OutputHelper.printWelcomeMessage());
        Language language = InputHelper.getValidLanguage(Language.getLanguageMap());

        Cipher cipher = new Cipher(MapBuilder.buildCaesarCipherMap(language.getAlphabet(), InputHelper.getKey()), language.getAlphabet());
        Cipher reverseCipher = cipher.getReverseCipher();

        String textToEncrypt = InputHelper.getValidText(OutputHelper.getEncryptPrompt(), language);
        String encryptedText = cipher.encryptText(textToEncrypt);
        System.out.println(OutputHelper.printEncryptedText(encryptedText));


        String textToDecrypt = cipher.decryptText(InputHelper.getValidText(OutputHelper.getDecryptPrompt(), language));
        System.out.println(OutputHelper.printDecryptedText(textToDecrypt));

        BruteForce.bruteForce(reverseCipher, encryptedText, language.getCommonWords(), language.getUncommonLetterCombinations());

        System.out.println(OutputHelper.printGoodbyeMessage());
        InputHelper.closeScanner();
    }
}
