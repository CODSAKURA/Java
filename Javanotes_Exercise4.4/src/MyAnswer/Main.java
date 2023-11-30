package MyAnswer;

/**This program is used to generate two random number from 1 to 6 and add them together to 
 * find whether that equal to a given number.The given number is from 2 to 12 and program runs 10000 times.
 * If adding result is equal to the given number then after 10000 runs the program prints the average times 
 * that need to be taken from the given value 2 to 12.
 * */

public class Main {

	/**Using the rollFor method to roll a given number 10000 times and then return
	 * the average rolling times that need to reach the goal.
	 * @param N the given number that two random number need to be generated and added together that equal to
	 * @return the average times that the program is taken to reach that goal after 10000 times
	 * */
	public static double rollAverage( int N )
	{
		int totalTimes = 0;		//Adding all the times that taken to reach the result and store in that variable.
		for(int i = 0; i < 10000; i++)
		{
			int timesOfRolling = rollFor(N);
			totalTimes = totalTimes + timesOfRolling;
		}
		
		return (double)totalTimes/10000;	//Returning the averages times that taken
	}
	
	/**
	 * Simulates rolling a pair of dice until a given total comes up.
	 * Precondition:  The desired total is between 2 and 12, inclusive.
	 * @param N the total that we want to get on the dice
	 * @return the number of times the dice are rolled before the
	 *    desired total occurs
	 * @throws IllegalArgumentException if the parameter, N, is not a number
	 *    that could possibly come up on a pair of dice
	 */
	public static int rollFor( int N ) {
		if ( N < 2 || N > 12 )
			throw new IllegalArgumentException("Impossible total for a pair of dice.");
		int die1, die2;  // Numbers between 1 and 6 representing the dice.
		int roll;        // Total showing on dice.
		int rollCt;      // Number of rolls made.
		rollCt = 0;
		do {
			die1 = (int)(Math.random()*6) + 1;
			die2 = (int)(Math.random()*6) + 1;
			roll = die1 + die2;
			rollCt++;
		} while ( roll != N );
		return rollCt;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Total On Dice     Average Number of Rolls");
		System.out.println("-------------     -----------------------");
		
		for(int i = 2; i <= 12; i++)
		{
			System.out.printf("%10d%22.4f\n", i , rollAverage(i));	//Printing the value in a specific format.
            // Use 10 spaces to output dice, and use 22 spaces to output
            // average, with 4 digits after the decimal.
		}

	}

}
