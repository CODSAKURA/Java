package Ex9;

public class BankAccount {

	private String accountNumber;
	private int balance;

	
	public BankAccount(String num) 
	{
		if(num == "")
		{
			throw new IllegalArgumentException();
		}
		this.accountNumber = num; balance = 0;
	}
	
	public BankAccount(String num, int bal) 
	{
		if(num == "" || bal < 0)
		{
			throw new IllegalArgumentException();
		}
		this.accountNumber = num ; 
		this.balance = bal;
	}
	
	
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
		throw new IllegalArgumentException("Invalid amount");
	}
	
	public boolean withdraw(int amount) {
		if(amount > 0 && amount <= balance) {
			balance = balance - amount;
			return true;
		}
		throw new IllegalArgumentException("Invalid amount");
	}
	
	public String toString()
	{
		return("Account number:" + accountNumber + "  " + "Account Balance:" + balance);
	}
}
