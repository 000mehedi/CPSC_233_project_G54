package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainController {
	Stage applicationStage;

    @FXML
    void createNewAccount(ActionEvent event) {
    	
    	VBox accountType = new VBox();
    	Label accountLabel = new Label("Select Account Type");
    	Button chequingAccountButton = new Button("Chequing Account");
    	Button savingsAccountButton = new Button("Savings Account");
    	accountType.getChildren().addAll(accountLabel,chequingAccountButton,savingsAccountButton);
    	
    	
    	
    	Scene accountScene = new Scene(accountType);
    	applicationStage.setScene(accountScene);
    	

    }

    @FXML
    void depositFunds(ActionEvent event) {

    }

    @FXML
    void withdrawFunds(ActionEvent event) {

    }

    @FXML
    void myAccounts(ActionEvent event) {

    }

    @FXML
    void quit(ActionEvent event) {

    }

}