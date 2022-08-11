package application;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class openAccountController {
	
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
    	
    	Map<String, Integer> m = new HashMap<>(); 
    	
    	String accountName =  savingsAccountName.getText();
    	
    	m.put(accountName, savingAccountNumber); 
    	
		for(Map.Entry<String, Integer> entry : m.entrySet() ) {
			
			String name = entry.getKey();
			Integer accountNumber = entry.getValue();
			System.out.println("Name: " + name + "\tElement: " + accountNumber);
		  }  	
		
    }
    


}
