package ulearn.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import static ulearn.utils.Const.*;
import ulearn.utils.JsonReader;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToolCont {
	public JsonReader jr = new JsonReader();
	public DatePicker newGradDate = new DatePicker();

	public TextField tfNewFName = new TextField(), tfNewLName = new TextField(), tfNewPwd = new TextField(), tfNewUuid =
			new TextField();
	public TextField tfNewClName = new TextField(), tfSeatCount = new TextField(), tfNewUcid = new TextField(),
			tfNewEduName = new TextField();

	public TextField[] tfNewUserArr = {tfNewFName, tfNewLName, tfNewPwd, tfNewUuid}, tfNewClassArr =
			{tfNewClName, tfSeatCount, tfNewUcid, tfNewEduName};

	public Button newUserBtn = new Button();

	public RadioButton adminBtn = new RadioButton(), eduBtn = new RadioButton(), studentBtn = new RadioButton();

	public ToggleGroup userTypeGroup = new ToggleGroup();

	public Button delAdmBtn = new Button(), delStuBtn = new Button(), delEduBtn = new Button();
	public ChoiceBox cbDelStu = new ChoiceBox(), cbDelEdu = new ChoiceBox(), cbDelAdm = new ChoiceBox();
	public ChoiceBox[] choices = {cbDelAdm, cbDelEdu, cbDelStu};

	// read in entire json object & save as var, add user to user array & write entire object back to file
	public void makeNewUser(ActionEvent event) {
		jr.readJson();
		JSONObject jo = jr.getJObj();
		JSONArray arr = jr.getJsonArr(uat_users); // get copy of arr
		jo.remove(uat_users); // only could get copy of arr. delete arr since it will be overwritten

		String gradDate = null, newName = tfNewFName.getText() + " " + tfNewLName.getText(), newPwd =
				tfNewPwd.getText(), newUuid = tfNewUuid.getText(), userType;

		if (newGradDate.getValue() != null) gradDate = newGradDate.getValue().toString();

		if (adminBtn.isSelected()) {
			userType = t_adm;
		} else if (eduBtn.isSelected()) {
			userType = t_edu;
		} else if (studentBtn.isSelected()) {
			userType = t_stu;
		} else { userType = ""; }

		JSONObject newUser = new JSONObject();
		if (isValid(newPwd) && (newPwd != null)) newUser.put(ul_pwd, newPwd);
		if (isValid(gradDate) && (gradDate != null)) newUser.put(ul_grad, gradDate);
		if (isValid(newName) && (newName != null)) newUser.put(l_name, newName);
		if (isValid(userType) && (userType != null)) newUser.put(ul_usr_type, userType);
		if (isValid(newUuid) && (newUuid != null)) newUser.put(ul_uid, newUuid);

		String[] texts = {newUuid, newName, newPwd, gradDate, userType};

		if ((allBad(texts)) || (!isValid(newUuid)) || (!isValid(newName))) {
			System.out.println("nothing to enter");
		} else {
			arr.add(newUser);
			jo.put(uat_users, arr);

			try (FileWriter file = new FileWriter(pj_user_db)) { //Write JSON file
				file.write(jo.toJSONString());
				file.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

			clearText(tfNewUserArr);
			newGradDate.setValue(LocalDate.now());

		}

	}

	public void makeNewClass(ActionEvent event) {
		jr.readJson(pj_class_db);
		JSONObject jo = jr.getJObj();
		JSONArray arr = jr.getJsonArr(cat_classes, pj_class_db); // get copy of arr
		jo.remove(cat_classes); // only could get copy of arr. delete arr since it will be overwritten

		String newName = tfNewClName.getText(), newSeats = tfSeatCount.getText(), newClassId = tfNewUcid.getText(),
				newEdu = tfNewEduName.getText();

		JSONObject newClass = new JSONObject();
		if (isValid(newSeats) && (newSeats != null)) newClass.put(cl_seats, newSeats);
		if (isValid(newEdu) && (newEdu != null)) newClass.put(cl_edu, newEdu);
		if (isValid(newName) && (newName != null)) newClass.put(l_name, newName);
		if (isValid(newClassId) && (newClassId != null)) newClass.put(cl_cid, newClassId);

		String[] texts = {newClassId, newName, newSeats, newEdu};

		if ((allBad(texts)) || (!isValid(newClassId))) {
			System.out.println("Nothing to add");
		} else {
			arr.add(newClass);
			jo.put(cat_classes, arr);
			try (FileWriter file = new FileWriter(pj_class_db)) { // Write JSON file
				file.write(jo.toJSONString());
				file.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			clearText(tfNewClassArr);
		}

	}

	public List<String> populateUserData(String tag) {
		jr.readJson();
		JSONObject jo = jr.getJObj();
		JSONArray arr = (JSONArray) jo.get(uat_users);

		List<String> admItems = new ArrayList<>();
		List<String> stuItems = new ArrayList<>();
		List<String> eduItems = new ArrayList<>();

		for (Object obj : arr.toArray()) {
			JSONObject jObj = (JSONObject) obj;
			String tmpUuid = (String) jObj.get(ul_uid), tmpType = (String) jObj.get(ul_usr_type), tmpName =
					(String) jObj.get(l_name);
			switch (tmpType) {
				case t_adm:
					admItems.add("Name: " + tmpName + " ID: " + tmpUuid);
					break;
				case t_edu:
					eduItems.add("Name: " + tmpName + " ID: " + tmpUuid);
					break;
				case t_stu:
					stuItems.add("Name: " + tmpName + " ID: " + tmpUuid);
					break;
			}
		}

		switch (tag) {
			case "A":
				return admItems;
			case "E":
				return eduItems;
			case "S":
				return stuItems;
		}

		return null;
	}

	public void clearText(TextField[] tfArr) { for (TextField tf : tfArr) tf.setText(""); }

	public Boolean isValid(String str) {
		String val = String.valueOf(str);
		return (val.length() > 0) && !(val.equals("null") && !(val.equals("")) && (!val.isEmpty()));
	}

	public Boolean allBad(String[] arr) {
		for (String str : arr) {
			if (!isValid(str)) return false;
		}

		return true;
	}

	public void getAdmins(ActionEvent event) {
		List<String> admList = populateUserData("A");
		cbDelStu.getItems().clear();
		cbDelAdm.getItems().addAll(admList);
		cbDelAdm.show();
	}

	public void getStudents(ActionEvent event) {
		List<String> stuList = populateUserData("S");
		cbDelStu.getItems().clear();
		cbDelStu.getItems().addAll(stuList);
		cbDelStu.show();
	}

	public void getEducators(ActionEvent event) {
		List<String> eduList = populateUserData("E");
		cbDelEdu.getItems().clear();
		cbDelEdu.getItems().addAll(eduList);
		cbDelEdu.show();
	}
}
