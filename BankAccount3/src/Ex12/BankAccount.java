package Ex12;

public class BankAccount {

	protected String accountNumber;
	protected int balance;

	
	public BankAccount(String num) {this.accountNumber = num; balance = 0;}
	public BankAccount(String num, int bal) {this.accountNumber = num ; this.balance = bal;}
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public boolean deposit(int amount) {
		if(amount > 0) 
		{
			balance = amount + balance;
			return true;
		}
		return false;
	}
	
	public boolean withdraw(int amount) {
		if(amount > 0 && amount <= balance) {
			balance = balance - amount;
			return true;
		}
		return false;
	}
}


