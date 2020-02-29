package ulearn.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MainCont {
	// main tabs
	public TabPane mainTabs = new TabPane();
	public Tab chatTabStudent = new Tab(), classStudentTab = new Tab(), calTab = new Tab(), storageTab = new Tab(),
			settingsTab = new Tab(), classTeacherTab = new Tab(), chatTabTeacher = new Tab(), homeTab = new Tab(),
			gradeStudentTab = new Tab(), gradeTeacherTab = new Tab(), toolTab = new Tab();

	// google stuff
	public WebView wvGCal = new WebView(), wvDrive = new WebView();
	public Tab adminToolTab;
	public Tab eduToolTab;

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

	@FXML void hideStudentItems() {
		mainTabs.getTabs().remove(chatTabStudent);
		mainTabs.getTabs().remove(classStudentTab);
		mainTabs.getTabs().remove(gradeStudentTab);


	}

	@FXML void hideTeacherItems() {
		mainTabs.getTabs().remove(chatTabTeacher);
		mainTabs.getTabs().remove(classTeacherTab);
		mainTabs.getTabs().remove(gradeTeacherTab);
		mainTabs.getTabs().remove(toolTab);
	}

}
