// ABSTRACT CLASS
//https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
package application;

import java.io.IOException;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public abstract class Account{
	
	protected String accountType;
	protected int accountNumber;
	protected String name;
	
	protected double chequingAccountBalance;
	protected double savingsAccountBalance;
	
	public Account() {}
	
	public Account(String givenName, int givenAccNumber) 
	{
		
		this.name = givenName;
		
		this.accountNumber = givenAccNumber;
		
		chequingAccountBalance = 0;
		
		savingsAccountBalance = 0;
		
	}
	

	// GETTER
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

	

	
	public abstract void transfer(double chequingAccountBalance, double savingsAccountBalance);

	public abstract void deposit(TextField amoField, ChoiceBox<String> accountChoiceBox) throws IOException 	;

	public void withdraw(TextField withdrawField) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void transfer(TextField amountField, ChoiceBox<String> fromDropdown, ChoiceBox<String> toDropdown)
			throws IOException {
		// TODO Auto-generated method stub
		
	}	
	
		

	
}