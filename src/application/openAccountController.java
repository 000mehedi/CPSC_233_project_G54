package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class openAccountController {
	
	private Bank aBank = new Bank();
	private Stage stage;
	private Scene scene;
	
    @FXML
    public void backToWelcomeScreen(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream("src/screens/mainScreen.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    	

    }
	
	@FXML
	private Label savingAccNumLabel;
	
	@FXML
	private Label signUpLabel;
	
	@FXML
	private TextField savingsAccountName;
	
	int savingAccountNumber;
	
    @FXML
    public void generateAccountNumber(ActionEvent event) {
    	Random random = new Random();
    	savingAccountNumber = random.nextInt(10000); 
    	
    	savingAccNumLabel.setText(String.format(" Account Number : %d", savingAccountNumber ));
    }
    
    @FXML
    public void doneSavingsAccount(ActionEvent event) {
    	
    	String accountName = savingsAccountName.getText();
    	businessAccount newBusAcc = new businessAccount(accountName, savingAccountNumber);
    	aBank.addAccount(newBusAcc);
    	}  	
		
		
}
    



