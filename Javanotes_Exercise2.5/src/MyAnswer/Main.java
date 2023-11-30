package MyAnswer;

import textio.TextIO;

public class Main {

	public static void main(String[] args) throws InterruptedException 
	{
		TextIO.put("The number of eggs you have:");
		int input = TextIO.getlnInt();	//Getting the user input

		int gross = input / 144;	//Calculating the gross
		int dozen = (input - gross * 144) / 12;		//Calculating the dozen
		int left = input - gross * 144 - dozen * 12;	//Calculating the left
		
		System.out.println("Calculating......");
		Thread.sleep(1000);		//Sleep for a while act as process
		
		System.out.println("Your number of eggs is " + 
									gross + " gross, " + dozen 
											+ " dozen, and " + left);
		
		
	}

}
