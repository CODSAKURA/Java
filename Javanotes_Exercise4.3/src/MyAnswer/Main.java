package MyAnswer;

import textio.TextIO;

/**This program is used to test the computer about the times that generating
 * two random numbers(1 - 6) and adding them together which equal to the user input.If the user
 * has input a value that is not within the 2 to 12, then print error message and end program.
 * */
public class Main {

	/**This function is used to test whether the user input is valid or not. If not valid, then
	 * throwing the exception message. Otherwise, return the times of generating two random numbers and adding them together
	 * which equal to the user input.
	 * @param number the user input value
	 * @return return the times of generating two random numbers and adding them together which equal to the user input.
	 * @throws throw the IllegalArgumentException if the input is not within 2 to 12
	 * */
	static int timesOfRolling( int number )
	{
		boolean valid = false;	//Check whether the input is within 2 to 12. If it is within, then set it to true.
		for(int i = 2; i <= 12; i++)
		{
			if( number == i)
			{
				valid = true;
			}
		}
		
		if(valid == true)
		{
			int count = 0;	//Count the number of times that need to be rolled
			while(true)
			{
				int firstRolling = (int)(6 * Math.random()) + 1;
				int secondRolling = (int)(6 * Math.random()) + 1;
				count++;
				
				int totalRollingNumber = firstRolling + secondRolling;
				if(totalRollingNumber == number)
				{
					return count;
				}
			}
		}
		else
		{
			throw new IllegalArgumentException ("Your input must be within 2 to 12.");
		}
		
	}
	
	public static void main(String[] args) {
		try {
			TextIO.put("Enter an integer:");
			int input = TextIO.getlnInt();	//Getting the user input
			System.out.println("The Number of times of rolling:" + timesOfRolling(input));
			
		}catch(IllegalArgumentException ex)		//Catching the exception
		{
			System.out.println("Your input must be within 2 to 12.");
			System.out.println("Try Again!!!");
		}

	}

}
