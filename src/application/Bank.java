package application;

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
	}
	
	
}
