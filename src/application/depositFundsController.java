package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class depositFundsController implements Initializable {
	
	private Stage stage;
	private Scene scene;
	
	/**
	 * This method loads the menu screen
	 * @param event
	 */
    @FXML
    public void backToAccountScreen(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream("src/screens/screen1.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();

    }
	
	@FXML
	private TextField amoField;
	
	@FXML
	private Label myLabel;
	@FXML
	private Label noticeLabel;
	private personalAccount perAcc;
	
	private businessAccount busAcc;
	
	@FXML
	private ChoiceBox<String> accountChoiceBox;
	
	private String[] accountType = {"Chequing Balance", "Savings Balance"};
	
	/**
	 * This method is to add all the choice options to the choicebox
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		accountChoiceBox.getItems().addAll(accountType);
		
	}
	
	/**
	 * This method finds which account we're working on 
	 * and calls the deposit method in Personal / Business class accordingly
	 * @param event
	 */
    @FXML
    public void depositButton(ActionEvent event) throws FileNotFoundException, IOException {
    	
    	String[] arrOfname1 = null;
    	String[] arrOfAccNo = null;
    	String[] arrOfCAccount = null;
		String[] arrOfSAccount = null;
		String[] arrOfAccType = null;
		try {
  	      File myObj = new File("currentAccount.txt");
  	      Scanner myReader = new Scanner(myObj);
  	      System.out.println("Absolute path: " + myObj.getAbsolutePath());

  	      	String data = myReader.nextLine();
  	        
  	        data = data.replace("\n", "").replace("\r", "");
  	      String name1 = data;
  	      arrOfname1 = name1.split(":", 5);
  	               
  	        data = myReader.nextLine();
  	      data = data.replace("\n", "").replace("\r", "");
  	    String accNo1 = data;
  	    arrOfAccNo = accNo1.split(":", 5);
  	        
  	        data = myReader.nextLine();
  	        
  	      data = data.replace("\n", "").replace("\r", "");
  	    String cheq = data;
  	    arrOfCAccount = cheq.split(":", 5);
  	      
         	String savAccountline = myReader.nextLine();
        	
      	savAccountline = savAccountline.replace("\n", "").replace("\r", "");
      	String sav = savAccountline;
      	arrOfSAccount = savAccountline.split(":", 2);
      	
	        data = myReader.nextLine();
	        
  	        
	      data = data.replace("\n", "").replace("\r", "");
	    String accType = data;
	    arrOfAccType = accType.split(":", 5);
	        
	        
  	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	        

		if("Personal".equals(arrOfAccType[1]))
		{
			perAcc = new personalAccount(arrOfname1[1], Integer.parseInt(arrOfAccNo[1]));
			perAcc.setChequingBalance(Double.parseDouble(arrOfCAccount[1]));
			perAcc.setSavingBalance(Double.parseDouble(arrOfSAccount[1]));
			
			perAcc.deposit(amoField, accountChoiceBox, noticeLabel);
		}

		
		if("Business".equals(arrOfAccType[1]))
		{
			busAcc = new businessAccount(arrOfname1[1], Integer.parseInt(arrOfAccNo[1]));
			busAcc.setChequingBalance(Double.parseDouble(arrOfCAccount[1]));
			busAcc.setSavingBalance(Double.parseDouble(arrOfSAccount[1]));
			
			busAcc.deposit(amoField, accountChoiceBox, noticeLabel);
		}
    	
    	
		  }  	
}
