package MyAnswer;

/**This class defines a various public static members variables
 * of type ArrayProcessor and performs different functions.It also
 * defines an ArrayProcessor type function which can create ArrayProcessors
 * to find the occurrences of a value in an array.(Note: This program depends
 * on the interface ArrayProcessors)
 * */
public class Main {
	
	/**
	 * A functional interface that defines a function
	 * that has one parameter of type double[] and that
	 * returns a value of type double.
	 */
	public interface ArrayProcessor {
	    
	    double apply( double[] array );

	}

    /**
     * An ArrayProcessor that computes and returns the maximum
     * value of an array.  (The array must have length at least 1.)
     */
	public static final ArrayProcessor maxNumber  = (double[] array) -> {
		
		double maxNumber = array[0];
		
		for(int i = 1 ; i < array.length; i++)
		{
			if(maxNumber < array[i])
			{
				maxNumber = array[i];
			}
		}
		
		return maxNumber;
		
	};
	
	/**An ArrayProcessor that computes and return the minimum 
	 * value of an array. (The array must have length at least 1.)
	 * */
	public static final ArrayProcessor minNumber  = (double[] array) -> {
		
		double minNumber = array[0];
		
		for(int i = 1 ; i < array.length; i++)
		{
			if(minNumber > array[i])
			{
				minNumber = array[i];
			}
		}
		
		return minNumber;
		
	};
	
	/**An ArrayProcessor that computes and return the sum
	 * of the value in an array. (The array must have length at least 1.)
	 * */
	public static final ArrayProcessor sumOfArray = (double[] array) -> {
		
		double sum = array[0];
		
		for(int i = 1 ; i < array.length; i++)
		{
			sum += array[i];
		}
		
		return sum;
		
	};
	
	/**An ArrayProcessor that computes and return the average
	 * value of an array.(The array must have length at least 1.)
	 * */
	public static final ArrayProcessor averageOfArray = (double[] array) -> {
		
		return sumOfArray.apply(array) / array.length;
	
	};
	
    /**
     * This function returns an ArrayProcessor that counts
     * the number of times a certain value occurs in an array
     * of doubles.  The parameter specifies the value that is
     * to be counted.
     */
	public static ArrayProcessor counter( double value ) {
		
		return (double[] array) -> {
			
			double count = 0.0;
			
			for(int i = 0; i < array.length; i++)
			{
				if(array[i] == value)
				{
					count++;
				}
			}
			
			return count;
			
		};
		
	}

	
	/**A main subroutine used to test the other members in this class.
	 * */
	public static void main(String[] args) {
		
        double[] firstList = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        double[] secondList = { 17.0, 3.14, 17.0, -3.4, 17.0, 42.0, 29.2, 3.14 };
        
        System.out.println("Sum of first list (should be 55): " 
                                                 + sumOfArray.apply(firstList) );
        System.out.println("Average of first list (should be 5.5): " 
                                                 + averageOfArray.apply(firstList) );
        System.out.println("Minimum of second list (should be -3.4): " 
                                                 + minNumber.apply(secondList) );
        System.out.println("Maximum of second list (should be 42.0): " 
                                                 + maxNumber.apply(secondList) );
        
        System.out.println();
        
        System.out.println("Count of 17.0 in second list (should be 3): " 
                                                 + counter(17.0).apply(secondList) );
        System.out.println("Count of 20.0 in second list (should be 0): " 
                                                 + counter(20.0).apply(secondList) );
        System.out.println("Count of 5.0 in first list (should be 1): " 
                                                 + counter(5.0).apply(firstList) );

	}

}
