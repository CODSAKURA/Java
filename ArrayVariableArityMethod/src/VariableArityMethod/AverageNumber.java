package VariableArityMethod;

public class AverageNumber {
	
	//In a variable arity method, different calls to the method can have different numbers of parameters.
	public static double average( double... numbers ) 
	{
						 // Inside this method, numbers is of type double[].
		double sum;      // The sum of all the actual parameters.
		double average;  // The average of all the actual parameters.
		sum = 0;
		
		for (int i = 0; i < numbers.length; i++) 
		{
			sum = sum + numbers[i];  // Add one of the actual parameters to the sum.
		}
		average = sum / numbers.length;
		
		return average;
	}
	
	public static void main(String[] args) 
	{
		System.out.println(average(1.0,2.1));
		System.out.println(average(1.0,2.1,3.5));
		System.out.println(average(1.0,2.1,3.5,4.5));
		System.out.println();
		
		//actual parameters of type int can be passed to average. The integers will, as usual, be automatically converted to real numbers.
		System.out.println(average(1,21));
		System.out.println(average(1,21,35));
		System.out.println(average(1,21,35,45));
		System.out.println();
		
		System.out.println(average(0.375));		
		System.out.println();
		
		//it is possible to pass a single array to a variable arity method, instead of a list of individual values
		double[] data = { 1.0, 2.5, 4.0, 5.5, 7.0 };
		System.out.print(average(data));
	}
}
