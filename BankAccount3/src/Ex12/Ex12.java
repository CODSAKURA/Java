package Ex12;

public class Ex12 {

	public static void main(String[] args) {
		SavingsAccount a = new SavingsAccount("DiZhou",100,0.06);
		
		a.applyInterest();
		System.out.println(a.withdraw(100));
		System.out.println(a.withdraw(110));
	}

}
