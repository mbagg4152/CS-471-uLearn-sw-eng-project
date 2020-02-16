package ulearn.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class InitCont {
    // for login
    public Button loginBtn = new Button();
    public Label unameLabel = new Label(), pwdLabel = new Label();
    public TextField unameBox = new TextField();
    public PasswordField pwdBox = new PasswordField();

    // for login_popup
    public Text uNameInfo = new Text(), pwdInfo = new Text(), dispUName = new Text(), dispPwd = new Text();
    public Button goHomeBtn = new Button();

    @FXML private void loginBtnAction(ActionEvent event) throws IOException {
        event.consume();
        String path = "../layout/login_popup.fxml";
        setupOnClick(path, loginBtn, 300, 140, false);
    }

    @FXML private void mainScreen(ActionEvent event) throws IOException {
        event.consume();
        String path = "../layout/main_screen.fxml";
        setupOnClick(path, goHomeBtn, 600, 350, true);
    }

    void setupOnClick(String layout, Button btn, int width, int height, boolean resize) throws IOException {
        Parent par = FXMLLoader.load(getClass().getResource(layout));
        Stage stage = (Stage) btn.getScene().getWindow();
        Scene scene = new Scene(par, width, height);
        scene.setFill(null);
        stage.setScene(scene);
        stage.setResizable(resize);
        stage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 4);
    }
}
