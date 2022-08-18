package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Pattern;

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
	
	/**
	 * This method allows the user to go back to the main screen
	 * where they can log into their newly created account/ create another account
	 * @param event
	 */
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
	private Label accountNoticeLabel;
	
	@FXML
	private Label signUpLabel;
	
	@FXML
	private TextField savingsAccountName;
	
	int savingAccountNumber;
	
	/**
	 * This method generates a unique account number
	 * for every new account
	 * @param event
	 */
    @FXML
    public void generateAccountNumber(ActionEvent event) {
    	
    	if (Pattern.matches("[a-zA-Z]+", savingsAccountName.getText())) {
        	Random random = new Random();
        	savingAccountNumber = random.nextInt(10000); 
        	accountNoticeLabel.setText("");
        	savingAccNumLabel.setText(String.format(" Account Number : %d", savingAccountNumber ));
    	}
    	else {
    		savingAccNumLabel.setText("");
    	}
    }
    
	/**
	 * This method gets the username typed by the user
	 * and checks if it's valid or not for Personal Accounts
	 * @param event
	 */
    @FXML
    public void donePersonalAccount(ActionEvent event) {
    
    	String accountName = savingsAccountName.getText();
    	
       	
    	if (Pattern.matches("[a-zA-Z]+", accountName))    	
    	{	
    	accountNoticeLabel.setText("Sign up successful! Please remember your Acc No. for logging in.");	
    	personalAccount newPerAcc = new personalAccount(accountName, savingAccountNumber);
    	aBank.addAccount(newPerAcc);
        }
    	else
    	{	
    		accountNoticeLabel.setText("Name can only contain letters. Sign up will not be complete.");
   
    	}

    }
    
	/**
	 * This method gets the username typed by the user
	 * and checks if it's valid or not for Business Accounts
	 * @param event
	 */
    @FXML
    public void doneBusinessAccount(ActionEvent event) {
    
    	String accountName = savingsAccountName.getText();
    	
       	
    	if (Pattern.matches("[a-zA-Z]+", accountName))    	
    	{	
    	accountNoticeLabel.setText("Sign up successful! Please remember your Acc No. for logging in.");	
    	businessAccount newBusAcc = new businessAccount(accountName, savingAccountNumber);
    	aBank.addAccount(newBusAcc);
        }
    	else
    	{	
    		accountNoticeLabel.setText("Name can only contain letters. Sign up will not be complete.");
   
    	}
    }

}



