public class BruteForce {



    public static void bruteForce(Cipher cipher, String cipherText) {
        for (int key = InputHelper.KEY_MIN; key <=InputHelper.KEY_MAX; key++) {
            cipher.setKey(key);
            String decryptedText = cipher.decryptText(cipherText);
            System.out.printf("Key: %d | Decrypted text: %s%n", key, decryptedText);
        }
    }
}
