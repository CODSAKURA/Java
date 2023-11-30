package MyAnswer;
import textio.TextIO;

public class Main {

	public static void main(String[] args) 
	{
		TextIO.put("Positive Integer:");
		int input = TextIO.getlnInt();	//Getting the user input
		
		/*Check whether the user input a positive integer or not
		 * If yes, then end the loop;
		 * If not, reprint the message until the user give and integer value.
		 * */
		while(input <= 0)
		{
			System.out.print("POSITIVE!! Try Again:");
			input = TextIO.getlnInt();
		}
		
		/*In case, the user enter 1 then just print the message
		 * Otherwise, do the calculation
		 * */
		if(input == 1)
		{
			System.out.print(input);
			System.out.println();
			System.out.print("So there are 1 terms on the sequences. ");	//Print 1 term message as only 1 has been input.
		}
		else
		{
			System.out.print(input + ", ");
			int count = 1;	//Add a count as user has inputed a value so start on 1 not 0.	
			while(input != 1)	//Check whether the variable value become 1
			{
				if((input%2) == 0)	//Check whether the value is a even
				{
					input = input / 2;
					if(input == 1)	//Check whether the value is 1 if so then print without "," at the end then quit system
					{
						count = count + 1;
						System.out.print(input);
						System.out.println();
						System.out.print("So there are " + count + " terms on the sequences. ");
						System.exit(0);
					}
				}
				else
				{
					input = input * 3 + 1;		//If the value is odd, then do that step
				}
				count = count + 1;
				System.out.print(input + ", ");
			}
		}
	}

}
