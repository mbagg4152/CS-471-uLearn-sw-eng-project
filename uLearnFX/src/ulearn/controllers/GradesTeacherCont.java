package ulearn.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class GradesTeacherCont {
    public Button subGradeBtn = new Button();
    public Button subBtn;


    @FXML private void newGrade(ActionEvent event) throws IOException {
        event.consume();
        Parent par = FXMLLoader.load(getClass().getResource("../layout/grade_add_dialog.fxml"));
        setupOnClick(par, subGradeBtn, 600, 350, true);
    }

    @FXML private void backToGrades(ActionEvent event) throws IOException {
        event.consume();
        Parent par = FXMLLoader.load(getClass().getResource("../layout/main_screen.fxml"));
        setupOnClick(par, subBtn, 600, 350, true);
    }

    void setupOnClick(Parent par, Button btn, int width, int height, boolean resize) throws IOException {
        Stage stage = (Stage) btn.getScene().getWindow();
        Scene scene = new Scene(par, width, height);
        stage.setScene(scene);
        stage.setResizable(resize);
        stage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 4);
    }

}
