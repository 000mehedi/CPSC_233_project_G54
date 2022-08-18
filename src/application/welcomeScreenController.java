package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class welcomeScreenController {
	private Stage stage;
	private Scene scene;
	
	/**
	 * This method loads the greeting screen 
	 * and provides the user with an 'Open Account' button 
	 * to get started on creating a new account
	 * @param event
	 */
    @FXML
    public void createNewAccount(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream("src/screens/screen2.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
	/**
	 * This method loads the log in screen
	 * so that the user can log in using their account name and number
	 * @param event
	 */
    @FXML
    void goToLoginPage(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
    	VBox root = loader.load(new FileInputStream("src/screens/loginScreen.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();    	

    }
}
