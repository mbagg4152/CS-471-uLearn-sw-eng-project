package ulearn.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ulearn.utils.*;
import static ulearn.utils.Const.*;

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
	public TextField delClassNameLbl;
	public Button delClassBtn;
	public TextField delClassIdLbl;
	public TextField txtNewClassName;
	public TextField txtNewClassId;
	public TextField txtNewClassEdu;
	public TextField txtNewClassSize;
	public Button newClassBtn;
	public TextField txtNewEduName;
	public ToggleGroup group;
	public TextField txtNewSeats;

	// read in entire json object & save as var, add user to user array & write
	// entire object back to file
	public void makeNewUser(ActionEvent event) {
		jr.readJson();
		JSONObject jo = jr.getJObj();
		JSONArray arr = jr.getJsonArr(lUser); // get copy of arr
		jo.remove(lUser); // only could get copy of arr. delete arr since it will be overwritten
		String gradDate = null;
		String newName = txtNewFirst.getText() + " " + txtNewLast.getText();
		String newPwd = txtNewPwd.getText();
		String newUuid = txtNewUuid.getText();
		String userType = tUndef;

		if (newGradDate.getValue() != null) gradDate = newGradDate.getValue().toString();

		if (adminBtn.isSelected()) {
			userType = tAdm;
		} else if (eduBtn.isSelected()) {
			userType = tEdu;
		} else if (studentBtn.isSelected()) userType = tStu;

		JSONObject newUser = new JSONObject();
		if (newUuid != null) newUser.put(lUid, newUuid);
		if (newName != null) newUser.put(lName, newName);
		if (newPwd != null) newUser.put(lPwd, newPwd);
		if (gradDate != null) newUser.put(lGrad, gradDate);
		newUser.put(lUType, userType);

		arr.add(newUser);
		jo.put(lUser, arr);

		//Write JSON file
		try (FileWriter file = new FileWriter(pUserDb)) {
			file.write(jo.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
