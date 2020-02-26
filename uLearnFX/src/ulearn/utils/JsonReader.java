package ulearn.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public JsonReader() {

    }

    public void readJson() {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        JSONParser jsonParser = new JSONParser();
        JSONObject jObj = null;
        try {
            jObj = (JSONObject) jsonParser.parse(new FileReader("database.json"));
        } catch (IOException | ParseException e) { e.printStackTrace(); }
        assert jObj != null;
        JSONArray userArr = (JSONArray) jObj.get("users");
        JSONArray classArr = (JSONArray) jObj.get("classes");
        for (Object o : userArr) {
            JSONObject tmp = (JSONObject) o;
            String name = (String) tmp.get("name");
            System.out.println("User's name: " + name);
        }
        for (Object o : classArr) {
            JSONObject tmp = (JSONObject) o;
            String name = (String) tmp.get("name");
            System.out.println("Class name: " + name);
        }
    }
}
