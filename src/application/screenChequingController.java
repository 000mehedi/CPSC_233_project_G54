package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class screenChequingController {
	
	@FXML
	private Label chequingAccNumLabel;
	
    @FXML
    private TextField chequingAccountName;
    
    String yourName = chequingAccountName.getText();

    @FXML
    void generateAccountNumber(ActionEvent event) {
    	Random random = new Random();
    	int chequingAccountNumber = random.nextInt(10000); 
    	
    	chequingAccNumLabel.setText(String.format(" Account Number : %d", chequingAccountNumber ));

    }
    @FXML
    void doneChequingAccount(ActionEvent event) {
    	
    }

}
