import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Language {

    protected String name;
    protected char[] alphabet;
    protected List<String> commonWords;
    protected List<String> uncommonLetterCombinations;
    protected String regex;

    public Language(String name, String alphabet, String[] commonWords, String[] uncommonLetterCombinations, String regex) {
        this.name = name;
        this.alphabet = alphabet.toCharArray();
        this.commonWords = List.of(commonWords);
        this.uncommonLetterCombinations = List.of(uncommonLetterCombinations);
        this.regex = regex;
    }

    // A static map to hold all the loaded Language objects, keyed by language name
    private static final Map<String, Language> LANGUAGES;

    // A static method to load all the languages from the JSON file and store them in the languages map
    static {
        try {
            LANGUAGES = FileHelper.loadLanguages("src/Languages.json");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load languages: ", e);
        }
    }
    public static Map<String, Language> getLanguageMap() {
        return LANGUAGES;
    }

    public String getName() {
        return name;
    }

    public char[] getAlphabet() {
        return alphabet;
    }

    public List<String> getCommonWords() {
        return commonWords;
    }

    public List<String> getUncommonLetterCombinations() {
        return uncommonLetterCombinations;
    }

    public String getRegex() {
        return regex;
    }
}