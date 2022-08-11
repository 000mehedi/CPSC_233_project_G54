package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class createNewAccountController {
	private Stage stage;
	private Scene scene;
	   @FXML
	    private Button createSavingsAccount;

	    @FXML
	    private Button createChequingAccount;

	    @FXML
	    private Label title;


    @FXML
    public void createAccount(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream("src/screens/openAccount.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    	

    }



}
