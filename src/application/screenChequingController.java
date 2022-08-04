package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class screenChequingController {
	
	@FXML
	private Label chequingAccNumLabel;

    @FXML
    void generateAccountNumber(ActionEvent event) {

    	
    	Random random = new Random();
    	double chequingAccountNumber = random.nextInt(10000); 
    	
    	chequingAccNumLabel.setText(String.format(" Account Number : %.0f", chequingAccountNumber ));

    }

}
