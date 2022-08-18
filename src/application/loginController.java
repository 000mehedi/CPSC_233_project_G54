package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class loginController {
	private Stage stage;
	private Scene scene;
	
	
	@FXML
	private Label loginNoticeLabel;
	
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField accNumberField;
	
	/**
	 * This method invokes the log in method in the Bank class
	 * @param event
	 */
	@FXML
	public void logIn(ActionEvent event) throws FileNotFoundException, IOException {
    
		 	Bank myObject = new Bank();
		 	myObject.login(stage, scene, loginNoticeLabel, event, nameField, accNumberField);
    }
}
    



