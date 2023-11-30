

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		System.out.print("Enter a value:");
		int n = input.nextInt();
		
		int i;
		BigInteger a = new BigInteger("1");

		
		for(i = 1; i <= n ; i++)
		{
			BigInteger b = BigInteger.valueOf(i);
			a = a.multiply(b);
		}
		System.out.print(a);
	}

}
