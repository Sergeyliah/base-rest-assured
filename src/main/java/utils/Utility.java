package utils;

import io.restassured.path.json.JsonPath;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Utility {

    public <T> ArrayList<T> getClients(JsonPath jp) {
        return jp.get();
    }

    public static Object fetchPropertyValue(String key) throws IOException {
        FileInputStream file = new FileInputStream("./src/main/resources/environment-config.properties");
        Properties property = new Properties();
        property.load(file);
        return property.get(key);
    }
}
