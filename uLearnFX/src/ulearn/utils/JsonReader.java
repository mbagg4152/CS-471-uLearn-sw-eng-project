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
//        JSONArray userArr = (JSONArray) jObj.get("users");
//        JSONArray classArr = (JSONArray) jObj.get("classes");
//        for (Object o : userArr) {
//            JSONObject tmp = (JSONObject) o;
//            JSONArray jArr = (JSONArray) tmp.get("classList");
//            String name = (String) tmp.get("name");
//            System.out.println("User's name: " + name);
//            for (Object t : jArr) {
//                JSONObject tmpInner = (JSONObject) t;
//                System.out.print(" class id: " + tmpInner.toString());
//            }
//
//
//        }
//        for (Object o : classArr) {
//            JSONObject tmp = (JSONObject) o;
//            String name = (String) tmp.get("name");
//            System.out.println("Class name: " + name);
//        }
        printContents(jObj, "users", "name", "classList", "user's name:", "has class with id:");
        printContents(jObj, "classes", "name", "students", "class name:", "student id:");

    }

    public void printContents(JSONObject jObj, String objectLabel, String arrKey, String listName, String outerLabel, String innerLabel) {
        JSONArray userArr = (JSONArray) jObj.get(objectLabel);
        for (Object obj : userArr) {
            JSONObject tmp = (JSONObject) obj;
            String name = (String) tmp.get(arrKey);

            System.out.print(outerLabel + " " + name + ". ");
            if (objectLabel.equals("users")) {
                String type = (String) tmp.get("userType");

                if (!type.equals("admin")) {
                    JSONArray jArr = (JSONArray) tmp.get(listName);
                    for (Object t : jArr) {
                        System.out.print(" " + innerLabel + " " + t);
                    }

                }
            } else {
                JSONArray jArr = (JSONArray) tmp.get(listName);
                for (Object t : jArr) {
                    System.out.print(" " + innerLabel + " " + t);
                }

            }
            System.out.println("");
        }
    }


}
