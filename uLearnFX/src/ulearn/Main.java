package ulearn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ulearn.utils.JsonReader;

public class Main extends Application {
	final int INIT_WD = 300;
	final int INIT_HT = 275;

	@Override public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("layout/login.fxml"));
		primaryStage.setTitle("uLearn");
		primaryStage.setScene(new Scene(root, INIT_WD, INIT_HT));
		primaryStage.setResizable(true);
		primaryStage.show();
		System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
		readJson();

	}

	void readJson() {
		JsonReader jReader = new JsonReader();
		jReader.readJson();
	}

	public static void main(String[] args) { launch(args); }
}
