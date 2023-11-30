package Money;

public class MoneyMain {

	public static void main(String[] args) {

		Money m1 = new Money(2, 50);

		Money m2 = new Money(0, 56);

		Money sum = m1.plus(m2);

		System.out.printf("Sum = %s%n", sum);

		}


}
