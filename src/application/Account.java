// ABSTRACT CLASS

package application;

public abstract class Account{
	
	private int accountNumber;
	private String name;
	
	protected double chequingAccountBalance;
	protected double savingsAccountBalance;
	
	public Account() {}
	
	public Account(String givenName, int givenAccNumber) {
		this.name = givenName;
		this.accountNumber = givenAccNumber;
		chequingAccountBalance = 0;
		savingsAccountBalance = 0;
		
	}
	
	// GETTER
	public double getChequingAccountBalance() {
		return this.chequingAccountBalance;
		
	}
	public double getSavingsAccountBalance() {
		return this.savingsAccountBalance;
	}
	public int getAccountNumber() {
		return this.accountNumber;
	}
	public String getName() {
		return this.name;
	}
	
	public void setChequingBalance(double cheqBalance){
		this.chequingAccountBalance = cheqBalance;
	}
	public void setSavingBalance(double savBalance){
		this.savingsAccountBalance = savBalance;
	}
	
	
	public abstract void deposit(double chequingAccountBalance, double savingsAccountBalance);
	
	public abstract void withdraw(double chequingAccountBalance);
	
	public abstract void transfer(double chequingAccountBalance, double savingsAccountBalance);
		

	
}