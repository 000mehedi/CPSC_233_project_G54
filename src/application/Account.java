// ABSTRACT CLASS
//https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
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

public abstract class Account{
	
	protected String accountType;
	protected int accountNumber;
	protected String name;
	
	protected double chequingAccountBalance;
	protected double savingsAccountBalance;
	
	// Constructor with no parameters
	public Account() {}
	
	/**
	 * Constructor with parameters
	 * @param givenName
	 * @param givenAccNumber
	 */
	
	public Account(String givenName, int givenAccNumber) 
	{
		
		this.name = givenName;
		
		this.accountNumber = givenAccNumber;
		
		chequingAccountBalance = 0;
		
		savingsAccountBalance = 0;	
	}
	
	/**
	 * This method is used to transfer funds 
	 * from Chequing Account to Savings Account, and vice versa
	 * @param amountField - the amount of money to be transferred
	 * @param fromDropdown - the account from which the money has to be transferred
	 * @param toDropdown - the account to which the money will be transferred
	 * @param noticeLabel1 - displays the current balance of chequing account and any other notifications
	 * @param noticeLabel2 - displays the current balance of savings account
	 */
	
	public void transfer(TextField amountField, ChoiceBox<String> fromDropdown, ChoiceBox<String> toDropdown, Label noticeLabel1, Label noticeLabel2 ) throws IOException {

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
  	        
	        	String savAccountline = myReader.nextLine();
	        	String sav = savAccountline;
   	        	String accTypeLine = myReader.nextLine();
	        	String accType = accTypeLine;

	        	savAccountline = savAccountline.replace("\n", "").replace("\r", "");
  	        String[] arrOfSAccount = savAccountline.split(":", 2);
  	        for (String a : arrOfSAccount)
  	            System.out.println(a);   	
  	  		
  	    	int counterDecPoint = 0;
  	    	boolean isValid = true;

  	    	for (char c: amountField.getText().toCharArray()) {
  	    		
  	    		// if any character is not digit or dot, set flag to false :  it is not a number
  	    		if ((!Character.isDigit(c)) && (c!='.')) 
  	    		{
  	    			isValid = false;	
  	    			noticeLabel1.setText("Amount may only contain numbers.");
  	    			noticeLabel2.setText("");
  	    		}
  	    		
  	    		// check for multiple decimal points , e.g.: 13.3.3
  				if ((c== '.') && counterDecPoint == 0) 
  				{
  					counterDecPoint += 1;
  				}
  				else if ((c== '.') && counterDecPoint > 0) 
  				{
  					isValid = false;	
  					noticeLabel1.setText("Amount may only contain numbers and a single decimal.");
  					noticeLabel2.setText("");
  				}
  	    		
  				
  				// if decimal is the last digit , e.g. : 13.
  				if((c== '.') && (c == amountField.getText().toCharArray()[amountField.getText().toCharArray().length - 1]) )
  				{
  					isValid = false;	
  					noticeLabel1.setText("Don't include any decimals or non-digit characters at the end.");
  					noticeLabel2.setText("");
  				}
  	    	}
  	    	

  	        if("Chequing".equals(fromDropdown.getValue()) && "Savings".equals(toDropdown.getValue()))
  	        {	
  	        	
  	        	if ((isValid == true) && Double.parseDouble(amountField.getText()) > 0 )
  	        	{
  	        		if ((Double.parseDouble(arrOfCAccount[1]) - Double.parseDouble(amountField.getText()))>0)
  	        		{
		  	        	noticeLabel2.setText("");	
		  	        	double newCheqTotal = Double.parseDouble(arrOfCAccount[1]) - Double.parseDouble(amountField.getText());
		  	        	cheq = "Chequing Account: " + Double.toString(newCheqTotal);
		  	        	noticeLabel1.setText(cheq);
		  	        	
		  	        	double newSavTotal = Double.parseDouble(arrOfSAccount[1]) + Double.parseDouble(amountField.getText());
		  	        	sav = "Savings Account Balance: " + Double.toString(newSavTotal);
		  	        	noticeLabel2.setText(sav);
	  	            }        	
	  	            else
	  	            {
	      	        	noticeLabel1.setText("Not enough money in Chequing Account.");
	      	        	noticeLabel2.setText("");

	  	            }
  	        	}
  	        	else
  	        	{
  	        		noticeLabel1.setText("Enter a valid positive amount.");
  	        		noticeLabel2.setText("");
  	        	}
  	        }	
      	   else {
      		   
      	        }
  	        
  	        
  	        if("Chequing".equals(toDropdown.getValue()) && "Savings".equals(fromDropdown.getValue()))
  	        {	
  	        	if ((Integer.parseInt(amountField.getText()) > 0 && isValid == true))
  	        	{
  	        		if ((Double.parseDouble(arrOfSAccount[1]) - Double.parseDouble(amountField.getText()))>0)
  	        		{
		  	        	noticeLabel2.setText("");
		  	        	double newCheqTotal = Double.parseDouble(arrOfCAccount[1]) + Double.parseDouble(amountField.getText());
		  	        	cheq = "Chequing Account: " + Double.toString(newCheqTotal);
		  	        	noticeLabel1.setText(cheq);
		  	        	
		  	        	double newSavTotal = Double.parseDouble(arrOfSAccount[1]) - Double.parseDouble(amountField.getText());
		  	        	sav = "Savings Account: " + Double.toString(newSavTotal);
		  	        	noticeLabel2.setText(sav);	        	
	  	            }        	
	  	           else
	  	           {
	      	        	noticeLabel1.setText("Not enough money in Savings Account.");
	      	        	noticeLabel2.setText("");

	  	           }
  	        	}
  	        	else
  	        	{
  	        		noticeLabel1.setText("Enter a valid positive amount.");
  	        		noticeLabel2.setText("");
  	        	}
  	        }	
      	   else {

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
  	      
  	    } catch (FileNotFoundException e) {
  	      System.out.println("An error occurred.");
  	      e.printStackTrace();
  	    }
	}
    	
	public double getChequingAccountBalance() 
	{
		return this.chequingAccountBalance;
		
	}
	public double getSavingsAccountBalance() 
	{
		return this.savingsAccountBalance;
	}
	public int getAccountNumber() 
	{
		return this.accountNumber;
	}
	public String getName() 
	{
		return this.name;
	}
	
	public String getType() 
	{
		return this.accountType;
	}
	
	public void setChequingBalance(double cheqBalance)
	{
		this.chequingAccountBalance = cheqBalance;
	}
	public void setSavingBalance(double savBalance)
	{
		this.savingsAccountBalance = savBalance;
	}
	public void setName(String aName) 
	{	
		
		this.name = aName;
	}
	public void setAcc(int anAccNo) 
	{	
		
		this.accountNumber = anAccNo;
	}
	
	public abstract void deposit(TextField amoField, ChoiceBox<String> accountChoiceBox,Label noticeLabel) throws IOException ;

	public void withdraw(TextField withdrawField, Label noticeLabel) throws IOException {	
	}




	
}