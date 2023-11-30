package MyAnswer;

/*  This program simulates rolling a pair of dice.
The number that comes up on each die is output,
followed by the total of the two dice.
*/

import textio.TextIO;

public class Main {

	public static void main(String[] args) throws InterruptedException 
	{
		/*Obtain user input yes or no*/
		TextIO.putln("Are you want to roll a dice twice?");
		TextIO.put("Your answer:");
		boolean input = TextIO.getlnBoolean();	//Getting The User input

		if(input == true)
		{
			/*Waitting time for rolling*/
			System.out.println("Rolling.......");
			Thread.sleep(1000);
			
			/*First roll*/
			int first = (int)(Math.random()*6) + 1;	
			System.out.println("The first die comes up " + first);
			
			/*Second roll*/
			int second = (int)(Math.random()*6) + 1;
			System.out.println("The second die comes up " + second);
			
			/*Add total roll numbers*/
			int total = first + second;
			System.out.println("Your total roll is " + total);
		}
		else
		{
			System.out.print("OK,Goodbye!");
		}
		
	}	//end main()

}	//end class
