package BankAccount;

public class Ex8 {
public static void main(String[] args) {
	BankAccount b1 = new BankAccount("ZhouDi");
	BankAccount b2 = new BankAccount("Nanase",100);
	
	System.out.println("Attempt: " + b1.withdraw(50));
	System.out.println("Balance: " + b1.getBalance());
	
	System.out.println("Attempt: " + b2.withdraw(50));
	System.out.println("Balance: " + b2.getBalance());
	}
}
