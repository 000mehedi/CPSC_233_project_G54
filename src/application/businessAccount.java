package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// more capacity on withdraws and deposits
public class businessAccount extends Account{

	public businessAccount() {}
	
	public businessAccount(String givenName, int givenAccNumber) {
		this.name = givenName;
		this.accountNumber = givenAccNumber;
		chequingAccountBalance = 0;
		savingsAccountBalance = 0;
		accountType = "Business";
	}
	
	@Override
	public void deposit(TextField amoField,  ChoiceBox<String> accountChoiceBox,Label noticeLabel) throws IOException {
		// TODO Auto-generated method stub
		
		try {
	  	      File myObj = new File("currentAccount.txt");
	  	      Scanner myReader = new Scanner(myObj);
	  	      System.out.println("Absolute path: " + myObj.getAbsolutePath());

	  	        String data = myReader.nextLine();
	  	        String name1 = data;
	  	        
	  	        data = myReader.nextLine();
	  	        String accNo1 = data;
	  	        
	  	        data = myReader.nextLine();
	  	        String cheq = data;
	  	        
	  	        data = data.replace("\n", "").replace("\r", "");

	  	        System.out.println(data);
	  	        String[] arrOfCAccount = cheq.split(":", 5);
	  	        for (String a : arrOfCAccount)
	  	            System.out.println(a);
	  	        // checking if the current row is emplty
	  	        System.out.println(accountChoiceBox.getValue());
	  	        if("Chequing Balance".equals(accountChoiceBox.getValue()))
	  	        {
	  	        	double newCheqTotal = Double.parseDouble(arrOfCAccount[1]) + Double.parseDouble(amoField.getText());
	  	        	cheq = "Chequing Balance:" + Double.toString(newCheqTotal);
	  	        	
	  	        }
	      	        else {
	      	        	noticeLabel.setText("");
	      	        	System.out.println("cheq not present");
	      	        }
	    	        	String savAccountline = myReader.nextLine();
	    	        	String sav = savAccountline;
	  	        	savAccountline = savAccountline.replace("\n", "").replace("\r", "");
	      	        String[] arrOfSAccount = savAccountline.split(":", 2);
	      	        for (String a : arrOfSAccount)
	      	            System.out.println(a);
	      	        if("Savings Balance".equals(accountChoiceBox.getValue()))
	      	        {
	      	        	double newSavTotal = Double.parseDouble(arrOfSAccount[1]) + Double.parseDouble(amoField.getText());
	      	        	sav = "Savings Balance:" + Double.toString(newSavTotal);
	      	        	
	      	        }
	      	        else {
	      	        	System.out.println("Sav not present");
	      	        }
	  	        
	      	        
	  	      
	  	      myReader.close();
	  	      
		            FileWriter myWriter = new FileWriter("currentAccount.txt");
		            BufferedWriter bw = new BufferedWriter(myWriter);
		            PrintWriter out = new PrintWriter(bw);
		            out.println(name1);
		            out.println(accNo1);
		            out.println(cheq);
		            out.println(sav);
		            
		            out.close();
		            bw.close();
		            myWriter.close();
	  	      
	  	    } catch (FileNotFoundException e) {
	  	      System.out.println("An error occurred.");
	  	      e.printStackTrace();
	  	    }
	  		  	
			  }  	


	@Override
	public void withdraw(TextField withdrawField, Label noticeLabel) throws IOException {
		// TODO Auto-generated method stub
		
    	try {
  	      File myObj = new File("currentAccount.txt");
  	      Scanner myReader = new Scanner(myObj);
  	      System.out.println("Absolute path: " + myObj.getAbsolutePath());

  	        String data = myReader.nextLine();
  	        String name1 = data;
  	        
  	        data = myReader.nextLine();
  	        String accNo1 = data;
  	        
  	        data = myReader.nextLine();
  	        String cheq = data;
  	        
  	        data = data.replace("\n", "").replace("\r", "");
  	        if(data.equals(""))
  	        {
  	        	data = myReader.nextLine();
      	        data = data.replace("\n", "").replace("\r", "");
  	        }
  	        System.out.println(data);
  	        String[] arrOfCAccount = data.split(":", 5);
  	        for (String a : arrOfCAccount)
  	            System.out.println(a);
  	        // checking if the current row is empty
  	        	noticeLabel.setText("");
  	        	double newCheqTotal = Double.parseDouble(arrOfCAccount[1]) - Double.parseDouble(withdrawField.getText());
  	        	cheq = "Chequing Account:" + Double.toString(newCheqTotal);
  	        	
  	        
    	        	String savAccountline = myReader.nextLine();
    	        	String sav = savAccountline;
  	        	savAccountline = savAccountline.replace("\n", "").replace("\r", "");
      	        String[] arrOfSAccount = savAccountline.split(":", 2);
      	        for (String a : arrOfSAccount)
      	            System.out.println(a);
      	        
  	      
  	      myReader.close();
  	      
	            FileWriter myWriter = new FileWriter("currentAccount.txt");
	            BufferedWriter bw = new BufferedWriter(myWriter);
	            PrintWriter out = new PrintWriter(bw);
	            out.println(name1);
	            out.println(accNo1);
	            out.println(cheq);
	            out.println(sav);
	            
	            out.close();
	            bw.close();
	            myWriter.close();
  	      
  	    } catch (FileNotFoundException e) {
  	      System.out.println("An error occurred.");
  	      e.printStackTrace();
  	    }
		
	}


}
