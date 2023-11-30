package Ex12;

public class SavingsAccount extends BankAccount {
	private double interestRate = 0.05;
	
	public SavingsAccount(String num, int bal ) {super(num,bal);}
	
	public SavingsAccount(String num, int bal, double rate) 
	{
		super(num,bal);
		
		if(rate <= 0.0)
		{
			throw new IllegalArgumentException("Invalid Interest rate");
		}

		this.interestRate = rate;
	}
	
	public double getInterestRate()
	{
		return interestRate;
	}
	
	public void setInterestRate(Double rate) 
	{
		if(rate <= 0.0)
		{
			throw new IllegalArgumentException("Invalid Interest rate");
		}
	}
	
	public void applyInterest()
	{
		this.deposit((int)(this.getBalance()*interestRate));
	}
	
	@Override
	public boolean withdraw(int amount) {
		if(this.getBalance()< 0 || this.getBalance()-amount < 0 )
		{
			return false;
		}
		return true;
	}
	
}
