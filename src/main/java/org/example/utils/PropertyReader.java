package org.example.utils;

import org.example.enums.Config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties;
    private static final String CONFIG_FILE_PATH = "src/main/java/org/example/config/base.properties";

    private static void loadProperties() {
        try (InputStream input = Files.newInputStream(Paths.get(CONFIG_FILE_PATH))) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String property) {
        loadProperties();
        return properties.getProperty(property);
    }

    public static String getProperty(Config property) {
        return getProperty(property.getValue());
    }

    public static boolean getPropertyBoolean(Config property) {
        return Boolean.getBoolean(getProperty(property));
    }

    public static int getPropertyInt(Config property) {
        return Integer.parseInt(getProperty(property));
    }

    public static void setProperty(Config property, String value) {
        try {
            //create a object for class OutputStream
            OutputStream output = Files.newOutputStream(Paths.get(CONFIG_FILE_PATH));
            //Load properties file and set firefox
            properties.setProperty(property.getValue(), value);
            //store values i properties file
            properties.store(output, "Update property");
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }
}
