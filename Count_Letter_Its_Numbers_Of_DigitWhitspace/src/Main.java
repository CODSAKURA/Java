

import java.util.Scanner;


public class Main {
	private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		System.out.print("Enter a line of text:");
		String n = input.nextLine();
		
		System.out.println(n.length() + " characters" );
		
		int len = n.length();
		String temp = new String(n);
		int j = 0;
		int k = 0;
		int e = 0;
		for (int i = 0; i < len ; i++)
		{
			char c = temp.charAt(i);		
			if(Character.isDigit(c))
			{
				j += 1;
			}
			if(Character.isLetter(c))
			{
				k += 1;
			}
			e += 1;
		}
		System.out.println( k + " letters" );
		System.out.println( j + " digits" );
		System.out.println((e-(j+k)) + " whitespaces");
		
			 
	}

}
