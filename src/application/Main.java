package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
<<<<<<< HEAD
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1000,600);
=======
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/Main.fxml"));
	
			Scene scene = new Scene(root,800,800);
>>>>>>> mehedi-dev
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
 