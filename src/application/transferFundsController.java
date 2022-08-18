package application;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

public class transferFundsController implements Initializable   {
	
	
	private Stage stage;
	private Scene scene;
	
	/**
	 * This method allows the user to go to the menu screen
	 * where they can deposit/withdraw/transfer funds
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
	private TextField amountField;
	
	private personalAccount perAcc;
	
	@FXML
	private Label noticeLabel1;
	
	@FXML
	private Label noticeLabel2;
	
	
    @FXML
    private ChoiceBox<String> toDropdown;
    
    private String[] accounts = {"Chequing" , "Savings"};

    @FXML
    private ChoiceBox<String> fromDropdown;
    
	/**
	 * 
	 * @param givenName
	 * @param givenAccNumber
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)   {
		toDropdown.getItems().addAll(accounts);
		fromDropdown.getItems().addAll(accounts);
		}
	
	/**
	 * This method finds which account we're working on 
	 * and calls the transfer method in Account
	 * @param event
	 */
    @FXML
    public void transferButton(ActionEvent event) throws FileNotFoundException, IOException {
    	
    	String[] arrOfname1 = null;
    	String[] arrOfAccNo = null;
    	String[] arrOfCAccount = null;
		String[] arrOfSAccount = null;
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
	        
	        
  	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	        

		perAcc = new personalAccount(arrOfname1[1], Integer.parseInt(arrOfAccNo[1]));
		perAcc.setChequingBalance(Double.parseDouble(arrOfCAccount[1]));
		perAcc.setSavingBalance(Double.parseDouble(arrOfSAccount[1]));
		
		perAcc.transfer(amountField, fromDropdown, toDropdown, noticeLabel1, noticeLabel2);
		
		
}
}
	

