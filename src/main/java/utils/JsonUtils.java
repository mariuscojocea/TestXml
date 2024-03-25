package utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonUtils {


    private final static String FILES_JSON_PATH = "src/main/resources/json/files.json";

    private String getFilePathByKey(String key, String fileType) throws FileNotFoundException {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(new FileReader(FILES_JSON_PATH)).getAsJsonObject();
        JsonElement fileElement = jsonObject.get(key);
        return fileElement.getAsJsonObject().get(fileType).getAsString();
    }

    public String getXmlFilePath(String fileName) throws FileNotFoundException {
        return getFilePathByKey(fileName, "xmlFilePath");
    }

    public String getXsdFilePath(String fileName) throws FileNotFoundException {
        return getFilePathByKey(fileName, "xsdFilePath");
    }


}
