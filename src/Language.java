import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Language {

    protected String name;
    protected char[] alphabet;
    protected List<String> commonWords;
    protected List<String> uncommonLetterCombos;
    protected String regex;

    public Language(String name, String alphabet, String[] commonWords, String[] uncommonLetterCombos, String regex) {
        this.name = name;
        this.alphabet = alphabet.toCharArray();
        this.commonWords = List.of(commonWords);
        this.uncommonLetterCombos = List.of(uncommonLetterCombos);
        this.regex = regex;
    }

    // A static list to hold all the loaded Language objects
    private static final List<Language> LANGUAGES;

    // A static method to load all the languages from the JSON file and store them in the languages map
    static {
        try {
            LANGUAGES = FileHelper.loadLanguages(FileHelper.getLanguageFilePath());
        } catch (IOException e) {
            throw new RuntimeException(OutputHelper.getLanguageFail(), e);
        }
    }

    public static List<Language> getLanguageList() {
        return LANGUAGES;
    }

    // This method returns a string of language options.
    public static String getLanguageOptions(List<Language> languageList) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (Language language : languageList) {
            stringBuilder.append(i++).append(": ").append(language.getName());
            if (i <= languageList.size()) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
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

    public List<String> getUncommonLetterCombos() {
        return uncommonLetterCombos;
    }

    public String getRegex() {
        return regex;
    }
}