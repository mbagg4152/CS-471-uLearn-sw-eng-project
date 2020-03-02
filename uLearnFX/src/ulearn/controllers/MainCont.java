package ulearn.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.*;

import java.io.IOException;

public class MainCont {
	final String T_STU = "student";
	final String T_ADM = "admin";
	final String T_EDU = "educator";
	final int LOGIN_WD = 300;
	final int LOGIN_HT = 275;

	// prefix mt = main tabs, the tab panes for each user type
	public TabPane mtAdmin = new TabPane();
	public TabPane mtAll = new TabPane();
	public TabPane mtEdu = new TabPane();
	public TabPane mtStudent = new TabPane();
	public Tab calTab = new Tab();
	public Tab storageTab = new Tab();

	// google stuff
	public WebView wvGCal = new WebView();
	public WebView wvDrive = new WebView();

	@FXML void tabEvents(Event ev) {
		ev.consume();
		if (calTab.isSelected()) {
			gCalendar();
		} else if (storageTab.isSelected()) {
			gDrive();
		}
	}

	void gCalendar() {
		WebEngine wEngine = wvGCal.getEngine();
		wEngine.load("https://calendar.google.com");
		wvGCal.setZoom(0.8);
	}

	void gDrive() {
		WebEngine we = wvDrive.getEngine();
		we.load("https://drive.google.com/drive");
		wvDrive.setZoom(0.8);
	}

	@FXML void logOut(Event ev) throws IOException {
		String loginPath = "../layout/gen/login.fxml";
		Window current = null;
		if (mtAdmin.isFocused()) {
			current = mtAdmin.getScene().getWindow();
		} else if (mtEdu.isFocused()) {
			current = mtEdu.getScene().getWindow();
		} else if (mtStudent.isFocused()) {
			current = mtStudent.getScene().getWindow();
		} else if (mtAll.isFocused()) {
			current = mtAll.getScene().getWindow();
		}
		backToLogin(loginPath, current, LOGIN_WD, LOGIN_HT);

	}

	void backToLogin(String layout, Window win, int width, int height) throws IOException {
		Parent par = FXMLLoader.load(getClass().getResource(layout));
		Stage stage = (Stage) win;
		Scene scene = new Scene(par, width, height);
		scene.setFill(null);
		stage.setScene(scene);
		stage.show();
	}
}
