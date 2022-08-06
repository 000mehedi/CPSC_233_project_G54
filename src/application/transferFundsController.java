package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class transferFundsController implements Initializable   {

    @FXML
    private ChoiceBox<String> toDropdown;
    
    private String[] accounts = {"Chequing" , "Savings"};

    @FXML
    private ChoiceBox<String> fromDropdown;

	@Override
	public void initialize(URL location, ResourceBundle resources)   {
		toDropdown.getItems().addAll(accounts);
		fromDropdown.getItems().addAll(accounts);
		String from = fromDropdown.getValue();
		
	
		
		}
	
	

		
	}
	
	
	
	


