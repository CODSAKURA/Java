package reversewordmethod3;//reverse word by using one main function and Scanner

import java.util.Scanner;

public class reversewordmethod3 {
	private static Scanner input;
	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		System.out.print("Enter a word:");
		String str = input.next();
		
		System.out.print("Reversed word is:");
		
		
		if(str.length() >= 1)
		{
			String sb = "";
			for(int i = str.length()-1; i>=0;i--)
			{
				sb += str.charAt(i);
			}
			System.out.print(sb);
		}
		else
		{
			System.out.print("You need to provide the word to decode on the command line");
		}
	}
}
