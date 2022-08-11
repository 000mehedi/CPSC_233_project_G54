package application;

// more capacity on withdraws and deposits
public class businessAccount extends Account{

	public businessAccount() {}
	
	public businessAccount(String givenName, int givenAccNumber) {
		this.name = givenName;
		this.accountNumber = givenAccNumber;
		chequingAccountBalance = 0;
		savingsAccountBalance = 0;
		
	}
	
	@Override
	public void deposit(double chequingAccountBalance, double savingsAccountBalance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(double chequingAccountBalance) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void transfer(double chequingAccountBalance, double savingsAccountBalance) {
		// TODO Auto-generated method stub
		
	}

}
