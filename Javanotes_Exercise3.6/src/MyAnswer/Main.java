package MyAnswer;

public class Main {

	public static void main(String[] args) 
	{				
		int numberOfDivisor = 0;	//Signing the divisors of the maximum number
		
		int[] numberOfDivisorOfArray = new int[10000];
		
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
			
			/*Because I start testing from 1 so I need to store the number of divisors of 1 to the array[0]
			 * NOT: array[1]!!!!!!
			 * */
			numberOfDivisorOfArray[i - 1] = count;	
			
			/* If the current number of divisors( count ) is greater than previous, 
			 * then store that value and the number of its divisors;
			 * If equal, then keep looping;
			 * If smaller, then keep looping.
			 * */
			if( count >= numberOfDivisor)		
			{
				numberOfDivisor = count;
			}			
		}
		System.out.println("Among integers between 1 and 10000,");
		System.out.println("The maximum number of divisors has " + numberOfDivisor);
		System.out.println("Numbers with that many divisors include:");
		
		
		/*Testing which number contain the maximum number of divisor
		 * If not, then add 1  to the variable of countNumber;
		 * If yes, then print that value and also add 1 to countNumber.
		 * */
		for(int i = 0 ; i < numberOfDivisorOfArray.length; i++)
		{
			if(numberOfDivisorOfArray[i] == numberOfDivisor)
			{
				/*Because we start from array 0 and the number of divisors of 1 is store in array 0
				 * So we need to add 1 after finding the value
				 * */
				System.out.printf("%10d\n" , i+1);	//Print value in a format
			}
		}

	}

}
