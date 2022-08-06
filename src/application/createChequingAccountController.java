package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class createChequingAccountController extends Account {
	
	@FXML
	private Label chequingAccNumLabel;

    @FXML
    void generateAccountNumber(ActionEvent event) {

    	
    	Random random = new Random();
    	int chequingAccountNumber = random.nextInt(10000); 
    	
    	chequingAccNumLabel.setText(String.format(" Account Number : %.0f", chequingAccountNumber ));

    }

	@Override
	public void depositFundsController(double chequingAccountBalance, double savingsAccountBalance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawFundsController(double chequingAccountBalance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferFundsContoller(double chequingAccountBalance, double savingsAccountbalance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myAccountsController(int chequingAccountNumber, int savingsAccountNumber, double chequingAccountBalance,
			double savingsAccountBalance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitController() {
		// TODO Auto-generated method stub
		
	}

}
