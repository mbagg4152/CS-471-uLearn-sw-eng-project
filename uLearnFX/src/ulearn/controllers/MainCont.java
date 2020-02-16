package ulearn.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MainCont {
    // main tabs
    public TabPane mainTabs;
    public Tab chatTabStudent = new Tab(), classStudentTab = new Tab(), calTab = new Tab(), storageTab = new Tab(),
            settingsTab = new Tab(), classTeacherTab = new Tab(), chatTabTeacher = new Tab();


    // google stuff
    public WebView wvGCal = new WebView(), wvDrive = new WebView();

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

}
