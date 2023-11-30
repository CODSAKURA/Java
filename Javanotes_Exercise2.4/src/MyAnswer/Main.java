package MyAnswer;

import textio.TextIO;

public class Main {

	public static void main(String[] args) throws InterruptedException 
	{
		TextIO.put("How many quarters do you have:");
		int quarters = TextIO.getlnInt();	// Getting the quarters
		
		TextIO.put("How many dimes do you have:");
		int dimes = TextIO.getlnInt();	//Getting the dimes
		
		TextIO.put("How many nickels do you have:");
		int nickels = TextIO.getlnInt();	//Getting the nickels
		
		TextIO.put("How many pennies do you have:");
		int pennies = TextIO.getlnInt();	//Getting the pennies
		
		int totalPennies = quarters * 25 + dimes * 10 + nickels * 5 + pennies;	// Getting the total cents
		
		double dollars = totalPennies / 100.0;	//Convert total cents to dollars
		
		System.out.println("Calculating......");
		Thread.sleep(1000);		//Sleep for a while act like calculating
		
		System.out.print("You have " + dollars + " in total");

	}

}
