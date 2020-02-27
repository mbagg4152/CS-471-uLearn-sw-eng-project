package ulearn.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
	JSONObject jObj;

	public JsonReader() {

	}

	public void setJObj(JSONObject jo) {
		this.jObj = jo;
	}

	public JSONObject getJObj() {
		return jObj;
	}

	public void readJson() {
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		JSONParser jsonParser = new JSONParser();
		jObj = null;
		try {
			jObj = (JSONObject) jsonParser.parse(new FileReader("database.json"));
		} catch (IOException | ParseException e) { e.printStackTrace(); }
		assert jObj != null;
		setJObj(jObj);
		String someId = getSingleItem("classes", "classId", "c125", "name");
		System.out.println("got value " + someId + " from using id c125");

	}

	// pass in value that is known to get array index and using it to get another item
	// ex: given an id get a class name
	String getSingleItem(String itemType, String knownKey, String knownValue, String lookFor) {
		JSONArray userArr = (JSONArray) jObj.get(itemType);
		int index = 0, counter = 0;
		if (userArr != null) {
			for (Object ob : userArr) {
				JSONObject tmp = (JSONObject) ob;
				String tmpVal = (String) tmp.get(knownKey);
				if (tmpVal.equals(knownValue)) {
					index = counter;
					break;
				}
				counter++;
			}
			JSONObject current = (JSONObject) userArr.get(index);
			return (String) current.get(lookFor);
		}
		return "error";
	}

	public void getItemList() {}

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
