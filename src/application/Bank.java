package application;

import java.io.BufferedWriter;
//https://www.w3schools.com/java/java_files_create.asp
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Bank {


	private int bankNumber = 0;
	private ArrayList<Account> accountList= new ArrayList<Account>();

	public int getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(int givenBankNumber) {
		this.bankNumber = givenBankNumber;
	}

	public ArrayList<Account> getAccountList() {
		return accountList;
	}

	public void addAccount(Account anAccount) {
		accountList.add(anAccount);
		// also add the account to the database
	    try {
	        File myObj = new File("accountDatabase.txt");
	        if (myObj.createNewFile()) {
		            	System.out.println("File created: " + myObj.getName());
		            	
			            FileWriter myWriter = new FileWriter("accountDatabase.txt");
			            BufferedWriter bw = new BufferedWriter(myWriter);
			            PrintWriter out = new PrintWriter(bw);
			            
			            out.println("Account Name:" + anAccount.getName());
			            out.println("Account Number:" + anAccount.getAccountNumber());
			            out.println("Chequing Balance:" + anAccount.getChequingAccountBalance());
			            out.println("Savings Balance:" + anAccount.getSavingsAccountBalance());
			            out.println("Account Type:" + anAccount.getType());
			            
// add account type 
			            out.println();
			            
			            out.close();
			            bw.close();
			            myWriter.close();

	              
	        } else {
	        	System.out.println("File already exists.");

	        	// appending to the file
	            FileWriter myWriter = new FileWriter("accountDatabase.txt",true);
	            BufferedWriter bw = new BufferedWriter(myWriter);
	            PrintWriter out = new PrintWriter(bw);
	            out.println("Account Name:" + anAccount.getName());
	            out.println("Account Number:" + anAccount.getAccountNumber());
	            out.println("Chequing Balance:" + anAccount.getChequingAccountBalance());
	            out.println("Savings Balance:" + anAccount.getSavingsAccountBalance());
	            out.println("Account Type:" + anAccount.getType());
	            out.println();
	            
	            out.close();
	            bw.close();
	            myWriter.close();
	        }

          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
	      } 
	}
	
 
    public void login(Stage stage, Scene scene, Label loginNoticeLabel, ActionEvent event,TextField nameField, TextField accNumberField) throws FileNotFoundException, IOException {
    	
    	try {
    	      File myObj = new File("accountDatabase.txt");
    	      Scanner myReader = new Scanner(myObj);
    	      System.out.println("Absolute path: " + myObj.getAbsolutePath());
    	      while (myReader.hasNextLine()) {
    	        String data = myReader.nextLine();
    	        data = data.replace("\n", "").replace("\r", "");
    	        if(data.equals(""))
    	        {
      	        	if(myReader.hasNextLine())
      	        		data = myReader.nextLine();
      	        	else
      	        		break;
        	        data = data.replace("\n", "").replace("\r", "");
    	        }
    	        System.out.println(data);
    	        String[] arrOfName = data.split(":", 5);
    	        for (String a : arrOfName)
    	            System.out.println(a);
    	        // checking if the current row is emplty

    	        if(arrOfName[1].equals(nameField.getText()))
    	        {
    	        	String name1 = arrOfName[0] + ":" + arrOfName[1];
    	        	String accNumberLine = myReader.nextLine();
    	        	String accNo = accNumberLine; 
    	        	accNumberLine = accNumberLine.replace("\n", "").replace("\r", "");
        	        String[] arrOfNumber = accNumberLine.split(":", 2);
        	        for (String a : arrOfNumber)
        	            System.out.println(a);
        	        if(arrOfNumber[1].equals(accNumberField.getText()))
        	        {
        	        	String cheqAcc = myReader.nextLine();
        	        	
        	        	String savAcc = myReader.nextLine();
        	        	// write the details to a new file
        	    	    try {
        	    	        File myObj1 = new File("currentAccount.txt");
        	    	        myObj1.createNewFile();
	    		            	System.out.println("File created: " + myObj1.getName());
	    		            	
	    			            FileWriter myWriter = new FileWriter("currentAccount.txt");
	    			            BufferedWriter bw = new BufferedWriter(myWriter);
	    			            PrintWriter out = new PrintWriter(bw);
	    			            out.println(name1);
	    			            out.println(accNo);
	    			            out.println(cheqAcc);
	    			            out.println(savAcc);
	    			            
	    			            out.close();
	    			            bw.close();
	    			            myWriter.close();

        	    	              
        	    	        

        	              } catch (IOException e) {
        	                System.out.println("An error occurred.");
        	                e.printStackTrace();
        	    	      } 
        	        	
        	    		FXMLLoader loader = new FXMLLoader();
        	    		VBox root = loader.load(new FileInputStream("src/screens/screen1.fxml"));
        	        	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        	        	scene = new Scene(root);
        	        	stage.setScene(scene);
        	        	stage.show();
        	        	

        	        	break;
        	        }
        	        else {
        	        	loginNoticeLabel.setText("No account with this name/number exists.");
        	        	System.out.println("Number not present");
        	        }
    	        }
    	        else {
    	        	loginNoticeLabel.setText("No account with this name/number exists.");
    	        	System.out.println("Name not present");
    	        }
    	      }
    	      myReader.close();
    	    } catch (FileNotFoundException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
    	
    	
		  }  	
		
	
	
}
