import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class FileHelper {

    // A public static method to load a JSON file containing Language objects into a Map
    public static Map<String, Language> loadLanguages(String filePath) throws IOException {
        // Read the file content as string
        String fileContent = Files.readString(Path.of(filePath));

        // Create a Gson object with a custom deserializer for the Language class
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Language.class, new LanguageDeserializer())
                .create();

        // Use TypeToken to deserialize the JSON content into a map of Language objects
        Type mapType = new TypeToken<Map<String, Language>>(){}.getType();

        // Return the completed languageMap
        return gson.fromJson(fileContent, mapType);
    }

    // An inner class to deserialize the Language JSON objects
    private static class LanguageDeserializer implements JsonDeserializer<Language> {
        @Override
        public Language deserialize(com.google.gson.JsonElement json, java.lang.reflect.Type typeOfT, com.google.gson.JsonDeserializationContext context) throws com.google.gson.JsonParseException {
            // Get the JSON object as a map
            Map<String, Object> map = context.deserialize(json, Map.class);

            // Extract the required fields from the map
            String name = (String) map.get("name");
            String alphabet = (String) map.get("alphabet");
            String[] commonWords = context.deserialize(json.getAsJsonObject().get("commonWords"), String[].class);
            String[] uncommonLetterCombinations = context.deserialize(json.getAsJsonObject().get("uncommonLetterCombinations"), String[].class);
            String regex = (String) map.get("regex");

            // Create a new Language object with the retrieved fields
            Language language = new Language(name, alphabet, commonWords, uncommonLetterCombinations, regex);

            // Return the created Language object
            return language;
        }
    }
}
