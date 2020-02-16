package ulearn;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {
    // for login
    public Button loginBtn;
    public Label unameLabel, pwdLabel;
    public TextField unameBox;
    public PasswordField pwdBox;


    // for login_popup
    public Text uNameInfo, pwdInfo, dispUName, dispPwd;
    public Button goHomeBtn;
    public Tab chatTab = new Tab(), classTab = new Tab(), calTab = new Tab(), storageTab = new Tab(), settingsTab = new Tab();
    public TabPane mainTabs = new TabPane();
    public WebView gCalWebView = new WebView();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("layout/login.fxml"));
        primaryStage.setTitle("uLearn");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setResizable(true);
        primaryStage.show();
        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

    }

    public static void main(String[] args) {
        launch(args);
    }
}
