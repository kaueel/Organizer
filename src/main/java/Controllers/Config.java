package Controllers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Config {

    public static String getPropertyValue(String propertyName){
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(
                    "./config.json"));

            JSONObject jsonObject = (JSONObject) obj;

            return (String) jsonObject.get("propertyName");

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
