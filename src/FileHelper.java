import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class FileHelper {

    private static final String LANGUAGE_FILE_PATH = "src/Files/Languages.json";
    private static final String DEFAULT_TXT_FILE_PATH = "src/Files/textToEncrypt.txt";

    public static String getLanguageFilePath() {
        return LANGUAGE_FILE_PATH;
    }

    public static String getDefaultTxtFilePath() {
        return DEFAULT_TXT_FILE_PATH;
    }

    public static boolean isValidTextFile(String filePath) {
        return new File(filePath).isFile() && filePath.endsWith(".txt");
    }

    public static String readFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }

    // A public static method to write encrypted text to a file
    public static void writeFile(String filePath, String encryptedText) throws IOException {
        Files.writeString(Path.of(filePath), encryptedText);
    }

    // A public static method to load a JSON file containing Language objects into a List
    public static List<Language> loadLanguages(String filePath) throws IOException {
        // Read the file content as string
        String fileContent = Files.readString(Path.of(filePath));

        // Create a Gson object with a custom deserializer for the Language class
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Language.class, new LanguageDeserializer())
                .create();

        // Use TypeToken to deserialize the JSON content into a list of Language objects
        Type listType = new TypeToken<List<Language>>() {
        }.getType();

        // Return the completed list
        return gson.fromJson(fileContent, listType);
    }

    // An inner class to deserialize the Language JSON objects
    private static class LanguageDeserializer implements JsonDeserializer<Language> {
        @Override
        public Language deserialize(com.google.gson.JsonElement json, java.lang.reflect.Type typeOfT, com.google.gson.JsonDeserializationContext context) throws com.google.gson.JsonParseException {
            // Get the JSON object as a list
            JsonObject jsonObject = json.getAsJsonObject();

            // Extract the required fields from the list
            String name = jsonObject.get("name").getAsString();
            String alphabet = jsonObject.get("alphabet").getAsString();
            String[] commonWords = context.deserialize(jsonObject.get("commonWords"), String[].class);
            String[] uncommonLetterCombos = context.deserialize(jsonObject.get("uncommonLetterCombos"), String[].class);
            String regex = jsonObject.get("regex").getAsString();

            return new Language(name, alphabet, commonWords, uncommonLetterCombos, regex);

        }
    }
}