package MyAnswer;

public class Main {

	public static void main(String[] args) 
	{				
		int maximumNumber = 0;		//Signing the maximum number
		int numberOfDivisor = 0;	//Signing the divisors of the maximum number
		
		for ( int i = 1; i <= 10000 ; i++ )		//Loop the integer from 1 - 10000
		{
			int count = 0;		//Counting the current divisors
			for( int j = 1 ; j <= i ; j++)		// Checking the divisors from 1 - i
			{
				if( i % j == 0)
				{
					count++;
				}
			}
			
			/* If the current number of divisors( count ) is greater than previous, 
			 * then store that value and the number of its divisors;
			 * If equal, then keep looping;
			 * If smaller, then keep looping.
			 * */
			if( count > numberOfDivisor)		
			{
				maximumNumber = i;
				numberOfDivisor = count;
			}		
		}
		System.out.println("The interger that has the largest number of divisors is " + maximumNumber);
		System.out.print(maximumNumber + " has " + numberOfDivisor + " number of divisors.");

	}

}
