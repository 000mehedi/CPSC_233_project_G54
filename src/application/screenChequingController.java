package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class screenChequingController {

    @FXML
    void generateAccountNumber(ActionEvent event) {
    	Random random = new Random();
    	int chequingAccountNumber = random.nextInt(10000); 
    	

    }

}
