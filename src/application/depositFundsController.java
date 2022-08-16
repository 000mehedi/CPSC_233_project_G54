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

	private personalAccount perAcc;
	
	@FXML
	private ChoiceBox<String> accountChoiceBox;
	
	private String[] accountType = {"Chequing Balance", "Savings Balance"};

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		accountChoiceBox.getItems().addAll(accountType);
		
	}
    @FXML
    public void depositButton(ActionEvent event) throws FileNotFoundException, IOException {
    	
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
		
		perAcc.deposit(amoField, accountChoiceBox);
  	
    	
//    	try {
//    	      File myObj = new File("currentAccount.txt");
//    	      Scanner myReader = new Scanner(myObj);
//    	      System.out.println("Absolute path: " + myObj.getAbsolutePath());
//
//    	        String data = myReader.nextLine();
//    	        String name1 = data;
//    	        
//    	        data = myReader.nextLine();
//    	        String accNo1 = data;
//    	        
//    	        data = myReader.nextLine();
//    	        String cheq = data;
//    	        
//    	        data = data.replace("\n", "").replace("\r", "");
//
//    	        System.out.println(data);
//    	        String[] arrOfCAccount = cheq.split(":", 5);
//    	        for (String a : arrOfCAccount)
//    	            System.out.println(a);
//    	        // checking if the current row is emplty
//    	        System.out.println(accountChoiceBox.getValue());
//    	        if("Chequing Balance".equals(accountChoiceBox.getValue()))
//    	        {
//    	        	double newCheqTotal = Double.parseDouble(arrOfCAccount[1]) + Double.parseDouble(amoField.getText());
//    	        	cheq = "Chequing Balance:" + Double.toString(newCheqTotal);
//    	        	
//    	        }
//        	        else {
//        	        	System.out.println("cheq not present");
//        	        }
//      	        	String savAccountline = myReader.nextLine();
//      	        	String sav = savAccountline;
//    	        	savAccountline = savAccountline.replace("\n", "").replace("\r", "");
//        	        String[] arrOfSAccount = savAccountline.split(":", 2);
//        	        for (String a : arrOfSAccount)
//        	            System.out.println(a);
//        	        if("Savings Balance".equals(accountChoiceBox.getValue()))
//        	        {
//        	        	double newSavTotal = Double.parseDouble(arrOfSAccount[1]) + Double.parseDouble(amoField.getText());
//        	        	sav = "Savings Balance:" + Double.toString(newSavTotal);
//        	        	
//        	        }
//        	        else {
//        	        	System.out.println("Sav not present");
//        	        }
//    	        
//        	        
//    	      
//    	      myReader.close();
//    	      
//	            FileWriter myWriter = new FileWriter("currentAccount.txt");
//	            BufferedWriter bw = new BufferedWriter(myWriter);
//	            PrintWriter out = new PrintWriter(bw);
//	            out.println(name1);
//	            out.println(accNo1);
//	            out.println(cheq);
//	            out.println(sav);
//	            
//	            out.close();
//	            bw.close();
//	            myWriter.close();
//    	      
//    	    } catch (FileNotFoundException e) {
//    	      System.out.println("An error occurred.");
//    	      e.printStackTrace();
//    	    }
    	
    	
		  }  	
}
