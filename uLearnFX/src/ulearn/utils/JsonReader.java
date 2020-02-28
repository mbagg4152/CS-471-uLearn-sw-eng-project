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

	public void readJson() {
		System.out.println("Working Directory = " + System.getProperty("user.dir")); // for debug purposes
		JSONParser jsonParser = new JSONParser(); // reads json file
		jObj = null;
		try {
			jObj = (JSONObject) jsonParser.parse(new FileReader("database.json")); // try to parse json
		} catch (IOException | ParseException e) { e.printStackTrace(); }
		assert jObj != null;
		setJObj(jObj);
		String someId = getSingleItem("classes", "classId", "c125", "name"); // get some other value using a known value
		System.out.println("got value " + someId + " from using id c125");
		printContents("users", "name", "classList"); // print users & their classes

	}

	// give object type and list name to print out list
	public void printContents(String objType, String key, String listName) {
		JSONArray arr = (JSONArray) jObj.get(objType);
		for (Object outerOb : arr) {
			JSONObject tmp = (JSONObject) outerOb;
			System.out.print("Label: " + ((String) tmp.get(key)) + " --> ");
			if (objType.equals("users")) {
				String type = (String) tmp.get("userType");
				if (!type.equals("admin")) {
					System.out.print(" contents: ");
					JSONArray jArr = (JSONArray) tmp.get(listName);
					for (Object t : jArr) {
						System.out.print(" " + t);
					}
				} else {
					System.out.print("no sub list");
				}
			} else {
				System.out.println(" contents: ");
				JSONArray jArr = (JSONArray) tmp.get(listName);
				for (Object innerOb : jArr) {
					System.out.print(" " + innerOb);
				}
			}

			System.out.println();
		}
	}

	// pass in value that is known to get array index and using it to get another item. ex: given an id get a class name
	public String getSingleItem(String itemType, String knownKey, String knownValue, String lookFor) {
		JSONArray userArr = (JSONArray) jObj.get(itemType);
		int index = -1, counter = 0;
		if (userArr != null) {
			for (Object ob : userArr) {
				String tmpVal = (String) ((JSONObject) ob).get(knownKey);

				if (tmpVal.equals(knownValue)) {
					index = counter;
					break;
				}
				counter++;
			}
			if (index >= 0) {
				JSONObject current = (JSONObject) userArr.get(index);
				return (String) current.get(lookFor);
			}
		}
		return null;
	}

	// to be used to get lists from something, like get list of classes from user or get list of students in classes
	public void getItemList() {}

	// either to confirm something is in a list or used to get other contents of a list, TBD
	public void getSingleItemFromList() {}

	public void setJObj(JSONObject jo) { this.jObj = jo; }

	public JSONObject getJObj() { return jObj; }

}
