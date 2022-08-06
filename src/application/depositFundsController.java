package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class depositFundsController  {

    @FXML
    private TextField amount;

    @FXML
    private Label label;

    @FXML
    private ChoiceBox<String> accountChoicebox;
    accountChoicebox.getItems().add("Apples");
    
  
    

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    void getAmount(ActionEvent event) {

    }

    @FXML
    void doneDeposit(ActionEvent event) {

    }

	

}
