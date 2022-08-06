package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class screenSavingController {
	
	@FXML
	private Label savingAccNumLabel;

    @FXML
    void generateAccountNumber(ActionEvent event) {
    	Random random = new Random();
    	int savingAccountNumber = random.nextInt(10000); 
    	
    	savingAccNumLabel.setText(String.format(" Account Number : %d", savingAccountNumber ));

    }

}
