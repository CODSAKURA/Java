package circle;

import java.util.Scanner;

public class Circle {
	private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		System.out.print("Enter the radius of a circle:");
		double n = input.nextDouble();
		
		if(n<=0)
		{
			System.out.print("Error!");
		}
		else
		{
			System.out.printf("A = %.3f,  P = %.3f ", Math.PI*n*n, 2*Math.PI*n);
		}
		 
	}

}
