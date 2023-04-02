public class Main {


    public static void main(String[] args) {
        int encryptionKey = InputHelper.getKey();
        String textToEncrypt = InputHelper.getText(InputHelper.ENCRYPT_PROMPT);
        char[] engAlphabet = Language.getAlphabet();
        Cipher cipher = new Cipher(engAlphabet, encryptionKey);

        System.out.println("Encrypted text: " + cipher.encryptText(textToEncrypt));

//        int decryptionKey = InputHelper.setKey();
        String textToDecrypt = InputHelper.getText(InputHelper.DECRYPT_PROMPT);
        System.out.println("Decrypted text: " + cipher.decryptText(textToDecrypt));


    }
}