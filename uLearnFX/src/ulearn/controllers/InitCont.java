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
import ulearn.utils.JsonReader;

import javax.swing.*;
import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class InitCont {
	// for login
	public Label title = new Label();
	public Label unameLabel = new Label(), pwdLabel = new Label();
	public TextField unameBox = new TextField();
	public PasswordField pwdBox = new PasswordField();
	public Button loginBtn = new Button();

	// for login_popup
	public Label uNameInfo = new Label(), pwdInfo = new Label(), dispUName = new Label(), dispPwd = new Label();
	public Button goHomeBtn = new Button();

	@FXML private void loginBtnAction(ActionEvent event) throws IOException {
		event.consume();
		if (verifyUser(unameBox.getText(), pwdBox.getText())) {
			String path = "../layout/main_screen.fxml";
			setupOnClick(path, loginBtn, 600, 350, true);
		} else {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
		}
	}

	private Boolean verifyUser(String username, String password) {
		// Compare pass against username pass
		JsonReader database = new JsonReader();
		database.readJson();
		return password.equals(database.getSingleItem("users", "userId", username, "password"));
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
