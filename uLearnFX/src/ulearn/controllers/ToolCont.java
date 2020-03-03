package ulearn.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ulearn.utils.JsonReader;

import java.io.FileWriter;
import java.io.IOException;

public class ToolCont {
	public DatePicker newGradDate = new DatePicker();
	public TextField txtNewPwd = new TextField();
	public TextField txtNewLast = new TextField();
	public TextField txtNewUuid = new TextField();
	public TextField txtNewFirst = new TextField();
	public Button newUserBtn = new Button();
	public JsonReader jr = new JsonReader();
	public RadioButton adminBtn = new RadioButton();
	public RadioButton eduBtn = new RadioButton();
	public RadioButton studentBtn = new RadioButton();

	// read in entire json object & save as var, add user to user array & write
	// entire object back to file
	public void makeNewUser(ActionEvent event) {
		jr.readJson();
		JSONObject jo = jr.getJObj();
		//System.out.println(jo);
		JSONArray arr = jr.getJsonArr("users");
		jo.remove("users");
		String gradDate = newGradDate.getValue().toString();
		String newName = txtNewFirst.getText() + " " + txtNewLast.getText();
		String newPwd = txtNewPwd.getText();
		String newUuid = txtNewUuid.getText();

		String userType = "undefined";
		if (adminBtn.isSelected()) {
			userType = "admin";
		} else if (eduBtn.isSelected()) {
			userType = "educator";
		} else if (studentBtn.isSelected()) userType = "student";

		JSONObject newUser = new JSONObject();
		if (newUuid != null) newUser.put("userId", newUuid);
		if (newName != null) newUser.put("name", newName);
		if (newPwd != null) newUser.put("password", newPwd);
		if (gradDate != null) newUser.put("gradDate", gradDate);
		newUser.put("userType", userType);

		arr.add(newUser);
		jo.put("users", arr);
		System.out.println(arr);
		System.out.println();
		System.out.println(jo);

		//Write JSON file
		try (FileWriter file = new FileWriter("database.json")) {
			file.write(jo.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
