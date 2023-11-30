

import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a value > 0: ");
		
		while (true) 
		{
			int value = input.nextInt();
			if (value > 0) 
			{
				break;
			}
			else 
			{
				System.out.print("Nope, try again: ");
			}
		}
		
		// Control transferred here after break
		System.out.print("Break jump here!!!");

	}

}
