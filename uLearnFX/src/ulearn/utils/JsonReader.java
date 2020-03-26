package ulearn.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import static ulearn.utils.Const.*;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
	JSONObject jObj;

	public JsonReader() { }

	// defaults to user-db
	public void readJson() {
		JSONParser jsonParser = new JSONParser(); // reads json file
		jObj = null;
		try {
			jObj = (JSONObject) jsonParser.parse(new FileReader(pj_user_db)); // try to parse json
		} catch (IOException | ParseException e) { e.printStackTrace(); }
		assert jObj != null;
		setJObj(jObj);
	}

	// specify
	public void readJson(String path) {
		JSONParser jsonParser = new JSONParser(); // reads json file
		jObj = null;
		try {
			jObj = (JSONObject) jsonParser.parse(new FileReader(path)); // try to parse json
		} catch (IOException | ParseException e) { e.printStackTrace(); }
		assert jObj != null;
		setJObj(jObj);
	}

	// defaults to user-db
	public JSONArray getJsonArr(String arrName) {
		readJson();
		return (JSONArray) jObj.get(arrName);
	}

	// specify
	public JSONArray getJsonArr(String arrName, String path) {
		readJson(path);
		return (JSONArray) jObj.get(arrName);
	}

	// give object type and list name to print out list. defaults to user-db
	public void printContents(String objType, String key, String listName) {
		readJson();
		doPrintContents(objType, key, listName);
	}

	// specify db file
	public void printContents(String objType, String key, String listName, String path) {
		readJson(path);
		doPrintContents(objType, key, listName);
	}

	private void doPrintContents(String objType, String key, String listName) {
		JSONArray arr = (JSONArray) jObj.get(objType);
		for (Object outerOb : arr) {
			JSONObject tmp = (JSONObject) outerOb;
			System.out.print("Label: " + ((String) tmp.get(key)) + " --> ");
			if (objType.equals(uat_users)) {
				String type = (String) tmp.get(ul_usr_type);
				if (!type.equals(t_adm)) {
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
	// defaults to user-db
	public String getSingleItem(String itemType, String knownKey, String knownValue, String lookFor) {
		readJson();
		return doGetSingleItem(itemType, knownKey, knownValue, lookFor);
	}

	// specify db file
	public String getSingleItem(String itemType, String knownKey, String knownValue, String lookFor, String path) {
		readJson(path);
		return doGetSingleItem(itemType, knownKey, knownValue, lookFor);

	}

	public String doGetSingleItem(String itemType, String knownKey, String knownValue, String lookFor) {
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

	public void setJObj(JSONObject jo) { this.jObj = jo; }

	public JSONObject getJObj() { return jObj; }

}
