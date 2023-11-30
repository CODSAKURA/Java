package MyAnswer;

/**This class uses to roll a pair of dice and adds them together to find whether it
 * equals to a given number or not. If not, keep rolling two dices. Otherwise, return
 * the times of rolling. The given numbers are 2 to 12 and this class will test each 
 * given number in described way in 10000 times. After that, it outputs the mean, 
 * standard deviation and maximum number of rolls after 10000 times of each given number.
 * This class depends on the PairOfDice and StatCalc class. 
 * */
public class Main {

	public static final int NUMBER_OF_EXPERIMENTS = 10000;
	
	private static double mean = 0.0;	//The mean value of rolls	
	private static double standardDeviation = 0.0;		//The standard deviation of rolls
	private static int maximum = 0;		//The maximum number of rolls
	
	public static void main(String[] args) 
	{
		System.out.println("Total On Dice     Average Number of Rolls     Standard Deviation of Rolls     Average Number of Rolls");
		System.out.println("-------------     -----------------------     ---------------------------     -----------------------");
		for ( int i = 2;  i <= 12;  i++ ) 
		{	
			roll(i);
			System.out.printf("%10d%22.4f%32.4f%28d\n", i, getMean(), getStandardDeviation(), getMaximum());
		}
	}	// end of main
	
	/**This subroutine generate a object of PairOfDice class and a object of
	 * StatCalc class. Then, using the inner method of PairOfDice class to roll
	 * two dices until it find the sum of two dices equal to given number. The
	 * number of rolls will be added to the StatCalc object to generate the data.
	 * This test will do 10000 times for each given number.
	 * @param goal which is the sum of two dices have to equal to.
	 * */
	private static void roll( int goal )
	{
		PairOfDice dice = new PairOfDice();
		StatCalc data = new StatCalc();
		for(int i = 0; i < NUMBER_OF_EXPERIMENTS; i++)
		{
			int count = 1;			
			
			do {				
				if(dice.getTotal() == goal)
					break;
				dice.roll();
				count++;
			}while(true);
			
			data.enter(count);	//After adding the count to the StatClac object,
								//we have to roll the dice. There are two reasons:
								//1.Before testing dice.getTotal, we have add 1 to count.
			dice.roll();		//2.We have assume count equal to 1 at this loop beginning.
			
		}		
		
		mean = data.getMean();	
		standardDeviation = data.getStandardDeviation();
		maximum = (int)data.getMax();	
	}
	
	/**Getter method which will return the private global
	 * variable called mean.
	 * @return mean the mean value of rolls
	 * */
	public static double getMean()
	{
		return mean;
	}
	
	/**Getter method which will return the private global
	 * variable called standardDeviation.
	 * @return standardDeviation the standard deviation of rolls
	 * */
	public static double getStandardDeviation()
	{
		return standardDeviation;
	}
	
	/**Getter method which will return the private global
	 * variable called maximum.
	 * @return maximum the maximum number of rolls
	 * */
	public static int getMaximum()
	{
		return maximum;
	}
}
