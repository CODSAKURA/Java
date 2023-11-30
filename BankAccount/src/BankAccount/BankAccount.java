package BankAccount;

public class BankAccount {

		private String accountNumber;
		private int balance;

		
		public BankAccount(String num) 
		{
			this(num,0);
		}
		
		public BankAccount(String num, int bal) 
		{
			accountNumber = num ; 
			balance = bal;
		}
		
		
		public String getAccountNumber() 
		{
			return accountNumber;
		}
		
		public int getBalance() 
		{
			return balance;
		}

		// Examples of predicate methods (returning true or false)
		public boolean deposit(int amount) 
		{
			if(amount > 0) 
			{
				balance = amount + balance;
				return true;
			}
			return false;
		}
		
		public boolean withdraw(int amount) 
		{
			if(amount > 0 && amount <= balance) 
			{
				balance = balance - amount;
				return true;
			}
			return false;
		}
		
}

