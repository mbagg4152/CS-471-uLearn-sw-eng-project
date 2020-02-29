package ulearn.controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.*;
import ulearn.utils.JsonReader;
import ulearn.utils.UTypeHolder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class MainCont {
	final String T_STU = "student";
	final String T_ADM = "admin";
	final String T_EDU = "educator";
	final int INIT_HT = 300;
	final int INIT_WD = 275;

	// main tabs
	public TabPane mainTabsAdmin = new TabPane();
	public TabPane mainTabsAll = new TabPane();
	public TabPane mainTabsEdu = new TabPane();
	public TabPane mainTabsStudent = new TabPane();
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
		String loginPath = "../layout/login.fxml";
		Window current = null;
		if (mainTabsAdmin.isFocused() && mainTabsAdmin != null) {
			current = mainTabsAdmin.getScene().getWindow();
		} else if (mainTabsEdu.isFocused() && mainTabsEdu != null) {
			current = mainTabsEdu.getScene().getWindow();
		} else if (mainTabsStudent.isFocused() && mainTabsStudent != null) {
			current = mainTabsStudent.getScene().getWindow();
		} else if (mainTabsAll.isFocused() && mainTabsAll != null) {
			current = mainTabsAll.getScene().getWindow();
		}
		backToLogin(loginPath, current, INIT_HT, INIT_WD);

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
