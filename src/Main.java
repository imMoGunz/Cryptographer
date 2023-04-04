public class Main {


    public static void main(String[] args) {
        Cipher cipher = new Cipher(Language.getAlphabet("eng"), InputHelper.getKey());
        String textToEncrypt = InputHelper.getText(InputHelper.ENCRYPT_PROMPT);

        System.out.println("Encrypted text: " + cipher.encryptText(textToEncrypt));
        String textToDecrypt = InputHelper.getText(InputHelper.DECRYPT_PROMPT);
        System.out.println("Decrypted text: " + cipher.decryptText(textToDecrypt));

        BruteForce.bruteForce(cipher, textToDecrypt);

    }
}