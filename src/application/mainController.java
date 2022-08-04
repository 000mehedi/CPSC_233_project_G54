package application;






import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainController {
	// Stage applicationStage;
	// private Scene scene;
	
	@FXML
	Button createNewAccount;

    @FXML
    public void createNewAccount() throws Exception {
    
    	VBox root = FXMLLoader.load(getClass().getResource("screen1.fxml"));
    	
    	Stage scene = (Stage) createNewAccount.getScene().getWindow();
    	scene.setScene(new Scene(root, 750, 500));
    	
    	
    	
    	
    	
    	
    
    	//VBox accountType = new VBox();
    	//Label accountLabel = new Label("Select Account Type");
    	//Button chequingAccountButton = new Button("Chequing Account");
    	//Button savingsAccountButton = new Button("Savings Account");
    	//accountType.getChildren().addAll(accountLabel,chequingAccountButton,savingsAccountButton);
    	
    	//Scene accountScene = new Scene(accountType);
    	//applicationStage.setScene(accountScene);
    	
    	
    	

    }

    @FXML
    void depositFunds(ActionEvent event){
    	

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