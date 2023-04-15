import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce {



    public static void bruteForce(Cipher cipher, String cipherText, List<String> commonWords, List<String> uncommonLetterCombinations) {
        String bestGuess = "";
        int bestScore = Integer.MIN_VALUE;

        for (int key = InputHelper.KEY_MIN; key <= InputHelper.KEY_MAX; key++) {
            cipher.setKey(key);
            String decryptedText = cipher.decryptText(cipherText);
            int score = scoreDecryptedText(decryptedText, commonWords, uncommonLetterCombinations);

            if (score > bestScore) {
                bestScore = score;
                bestGuess = decryptedText;
            }
        }

        System.out.println("Best guess: " + bestGuess);
        System.out.println("Score: " + bestScore);
    }

    public static int scoreDecryptedText(String decryptedText, List<String> commonWords, List<String> uncommonLetterCombinations) {
        int score = 0;
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(decryptedText);
        while (matcher.find()) {
            String word = matcher.group();
            if (commonWords.contains(word)) {
                score += 3;
            } else if (uncommonLetterCombinations.stream().anyMatch(word::contains)) {
                score -= 2;
            }
        }
        return score;
    }
}

