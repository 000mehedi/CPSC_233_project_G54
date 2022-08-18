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
	
	// Constructor with no parameters
	public businessAccount() {}
	
	
	/**
	 * Constructor with parameters
	 * @param givenName
	 * @param givenAccNumber
	 */
	public businessAccount(String givenName, int givenAccNumber) {
		this.name = givenName;
		this.accountNumber = givenAccNumber;
		chequingAccountBalance = 0;
		savingsAccountBalance = 0;
		accountType = "Business";
	}
	
	/**
	 * This method allows the user to deposit funds 
	 * into their Chequing or Savings account
	 * and checks for validity
	 * @param amoField - the amount of money to deposit
	 * @param accountChoiceBox - the account (Savings/Chequing) into which the money should be deposited into
	 * @param noticeLabel - to display any error/success messages
	 */
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
	  	      
	        	noticeLabel.setText("");
	        	
	        	boolean isValid = true;
	        	int counterDecPoint = 0;
	        	for (char c: amoField.getText().toCharArray()) {
	    		
	    		// if any character is not digit or dot, set flag to false :  it is not a number
	    		if ((!Character.isDigit(c)) && (c!='.')) {
	    			isValid = false;
	    			noticeLabel.setText("Amount may only contain numbers.");
	    		}
	      		// check for multiple decimal points , e.g.: 13.3.3
	  			if ((c== '.') && counterDecPoint == 0) 
	  			{
	  				counterDecPoint += 1;
	  			}
	  			else if ((c== '.') && counterDecPoint > 0) 
	  			{
	  				isValid = false;	
	  			    noticeLabel.setText("Amount may only contain numbers and a single decimal.");
	  			}
	      		
	  			
	  			// if decimal is the last digit , e.g. : 13.
	  			if((c== '.') && (c == amoField.getText().toCharArray()[amoField.getText().toCharArray().length - 1]) )
	  			{
	  				isValid = false;	
	  			    noticeLabel.setText("Don't include any decimals or non-digit characters at the end.");
	  			}
	      	}  	        
	  	        if (isValid = true) {
	  	        
	  	        if("Chequing Balance".equals(accountChoiceBox.getValue()))
	  	        {   double newCheqTotal;
	  	        	if (Double.parseDouble(amoField.getText()) > 0) {
	  	        	newCheqTotal = Double.parseDouble(arrOfCAccount[1]) + Double.parseDouble(amoField.getText());
	  	        	cheq = "Chequing Balance:" + Double.toString(newCheqTotal);
	  	        	noticeLabel.setText("Money deposited!");
	  	        	}
	  	        	else
	  	        	{
	  	        		noticeLabel.setText("Enter a valid amount.");
	  	        	}
	  	        }
	      	        else {
	      	        	noticeLabel.setText("");
	      	        	System.out.println("cheq not present");
	      	        }
	    	        	String savAccountline = myReader.nextLine();
	    	        	String sav = savAccountline;
	    	        	
	    	        	String accTypeLine = myReader.nextLine();
	    	        	String accType = accTypeLine;
	  	        	savAccountline = savAccountline.replace("\n", "").replace("\r", "");
	      	        String[] arrOfSAccount = savAccountline.split(":", 2);
	      	        for (String a : arrOfSAccount)
	      	            System.out.println(a);
	      	        
	      	      if("Savings Balance".equals(accountChoiceBox.getValue()))
	      	        {
	      	        	if (Double.parseDouble(amoField.getText()) > 0)
	      	        	{
	      	        	double newSavTotal = Double.parseDouble(arrOfSAccount[1]) + Double.parseDouble(amoField.getText());
	      	        	sav = "Savings Balance:" + Double.toString(newSavTotal);
	      	        	noticeLabel.setText("Money deposited!");
	      	        	}
	      	        	else
	      	        	{
	      	        		noticeLabel.setText("Enter a valid amount.");
	      	        	}
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
		            out.println(accType);
		            out.close();
		            bw.close();
		            myWriter.close();
	  	        }    
	  	    
		}
	  	       catch (FileNotFoundException e) {
	  	      System.out.println("An error occurred.");
	  	      e.printStackTrace();
	  	    }
	  		  	
			  }  		
	/**
	 * This method allows the user to withdraw money 
	 * from their Chequing account
	 * and checks for validity
	 * @param withdrawField - the amount of money to withdraw
	 * @param noticeLabel - to display any error/success messages
	 */
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
  	        	double newCheqTotal;
  	        	boolean isValid = true;
  	        	int counterDecPoint = 0;
  	        	for (char c: withdrawField.getText().toCharArray()) {
  	    		
  	    		// if any character is not digit or dot, set flag to false :  it is not a number
  	    		if ((!Character.isDigit(c)) && (c!='.')) {
  	    			isValid = false;
  	    			noticeLabel.setText("Amount may only contain numbers.");
  	    		}
  	      		// check for multiple decimal points , e.g.: 13.3.3
  	  			if ((c== '.') && counterDecPoint == 0) 
  	  			{
  	  				counterDecPoint += 1;
  	  			}
  	  			else if ((c== '.') && counterDecPoint > 0) 
  	  			{
  	  				isValid = false;	
  	  			    noticeLabel.setText("Amount may only contain numbers and a single decimal.");
  	  			}
  	      		
  	  			
  	  			// if decimal is the last digit , e.g. : 13.
  	  			if((c== '.') && (c == withdrawField.getText().toCharArray()[withdrawField.getText().toCharArray().length - 1]) )
  	  			{
  	  				isValid = false;	
  	  			    noticeLabel.setText("Don't include any decimals or non-digit characters at the end.");
  	  			}
  	      	}		
   			
  	    		if( isValid == true)
  	    		{  	        	
  	    			double origCheqTotal = Double.parseDouble(arrOfCAccount[1]);
  	        	    double amountToWithdraw = Double.parseDouble(withdrawField.getText());
	  	    			
	  	        	if((origCheqTotal - amountToWithdraw) >= 0)
	  	        	{
	  	  	        	newCheqTotal = origCheqTotal - amountToWithdraw;
	  	  	        	cheq = "Chequing Account:" + Double.toString(newCheqTotal);
	  	  	        	noticeLabel.setText("Money withdrawn!");
	  	        	}
	  	        	else 
	  	        	{
	  	        		noticeLabel.setText("Not enough money to withdraw.");
	  	        	}
  	    		}

    	        	String savAccountline = myReader.nextLine();
    	        	String sav = savAccountline;
    	        	
    	        	String accTypeLine = myReader.nextLine();
    	        	String accType = accTypeLine;
    	        	
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
	            out.println(accType);
	            out.close();
	            bw.close();
	            myWriter.close();
  	        	} 
      
  	      catch (FileNotFoundException e) 
  	      {
  	      System.out.println("An error occurred.");
  	      e.printStackTrace();
  	    }  	
    	
	}
	
}
