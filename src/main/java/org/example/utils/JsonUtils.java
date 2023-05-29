package org.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static org.assertj.core.util.Files.newFile;

public class JsonUtils {
    private final static Logger log = Logger.getLogger(JsonUtils.class);

    public void writeObjectToJsonFile(Object object, String pathToFile) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(newFile(pathToFile), object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonObject parseJsonFromFile(String pathToJsonFile) {
        try {
            return JsonParser.parseString(readFile(pathToJsonFile)).getAsJsonObject();
        } catch (Exception e) {
            throw new IllegalArgumentException("Json file can not be parsed");
        }
    }

    public static String readFile(String fileName) throws Exception {
        String json;
        try {
            json = IOUtils.toString(Files.newInputStream(Paths.get(fileName)), StandardCharsets.UTF_8);
            if (json.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            log.error("Json file is not found or empty: " + e.getMessage());
            throw new Exception("Json file is not found or empty: " + e.getMessage());
        }
        return json;
    }

    public static String convertToJson(Map<String, String> data) {
        ObjectMapper objectMapper = new ObjectMapper(); //using jackson lib - ask how we use this lib
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException exception) {
            log.error("Could not parse json data: ".concat(exception.getMessage()));
            throw new IllegalArgumentException("Could not parse json data: ".concat(exception.getMessage()));
        }
    }
}
