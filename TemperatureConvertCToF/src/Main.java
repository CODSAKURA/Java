

import java.util.Scanner;

class Main {
	private static Scanner input;
	public static void main(String[] args) {
		 input = new Scanner(System.in);
		 
		 System.out.print("Enter Celsius temperature:");
		 double n = input.nextDouble();
		 
		 System.out.printf(n +"\u00b0C = %.1f\u00b0F", ((n*1.8)+32));
	}

}
