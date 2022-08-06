// ABSTRACT CLASS

package application;

public abstract class Account{
	
	private int chequingAccountNumber;
	private int savingsAccountNumber;
	
	protected double chequingAccountBalance;
	protected double savingsAccountBalance;
	
	public Account() {}
	
	public Account(int chequingAccountNumber,int savingsAccountNumber) {
		this.chequingAccountNumber = chequingAccountNumber;
		this.savingsAccountNumber = savingsAccountNumber;
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
	public int getChequingAccountNumber() {
		return this.chequingAccountNumber;
	}
	public int getSavingsAccountNumber() {
		return this.savingsAccountNumber;
	}
	
	
	public abstract void depositFundsController(double chequingAccountBalance, double savingsAccountBalance);
	
	public abstract void withdrawFundsController(double chequingAccountBalance);
	
	public abstract void transferFundsContoller(double chequingAccountBalance, double savingsAccountbalance);
	
	public abstract void myAccountsController(int chequingAccountNumber, int savingsAccountNumber, double chequingAccountBalance, double savingsAccountBalance);
		
	public abstract void quitController();
	
}