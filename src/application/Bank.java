package application;

//https://www.w3schools.com/java/java_files_create.asp
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	            try {
	                FileWriter myWriter = new FileWriter("filename.txt");
	                myWriter.write("Account Number:" + anAccount.getAccountNumber() +"/n");
	                myWriter.write("Account Name:" + anAccount.getName() +"/n");
	                myWriter.write("Chequing Balance:" + anAccount.getChequingAccountBalance() +"/n");
	                myWriter.write("Savings Balance:" + anAccount.getSavingsAccountBalance() +"/n");
	                myWriter.write("/n");
	                
	                myWriter.close();
	              } catch (IOException e) {
	                System.out.println("An error occurred.");
	                e.printStackTrace();
	              }
	        } else {
	            try {
	                FileWriter myWriter = new FileWriter("filename.txt");
	                myWriter.write("Account Number:" + anAccount.getAccountNumber() +"/n");
	                myWriter.write("Account Name:" + anAccount.getName() +"/n");
	                myWriter.write("Chequing Balance:" + anAccount.getChequingAccountBalance() +"/n");
	                myWriter.write("Savings Balance:" + anAccount.getSavingsAccountBalance() +"/n");
	                myWriter.write("/n");
	                
	                myWriter.close();
	              } catch (IOException e) {
	                System.out.println("An error occurred.");
	                e.printStackTrace();
	              }
	        }
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	}
	
	
}
