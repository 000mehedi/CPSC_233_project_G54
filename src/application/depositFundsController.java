package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class depositFundsController implements Initializable {
	
	
	@FXML
	private Label myLabel;
	
	@FXML
	private ChoiceBox<String> accountChoiceBox;
	
	private String[] accountType = {"Chequing Account", "Savings Account"};

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		accountChoiceBox.getItems().addAll(accountType);
		
	}
	
}
