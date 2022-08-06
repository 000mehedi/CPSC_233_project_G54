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


public class mainController {
	private Stage stage;
	private Scene scene;

    @FXML
    public void createNewAccount(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream("src/screens/screen2.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
		
    }

    @FXML
    void depositFunds(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	VBox root = loader.load(new FileInputStream("src/screens/depositFunds.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();

    }

    @FXML
    void withdrawFunds(ActionEvent event) throws IOException {

    	FXMLLoader loader = new FXMLLoader();
    	VBox root = loader.load(new FileInputStream("src/screens/screen4.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();    	
    }

    @FXML
    void myAccounts(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
    	VBox root = loader.load(new FileInputStream("src/screens/myAccounts.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();    	

    }
    
    @FXML
    void transferFunds (ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
    	VBox root = loader.load(new FileInputStream("src/screens/transferFunds.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();    	

    }

    @FXML
    void quit(ActionEvent event) {

    }

}
