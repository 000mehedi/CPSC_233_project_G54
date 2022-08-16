package application;

import java.io.BufferedWriter;
//https://www.w3schools.com/java/java_files_create.asp
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
	
	
}
