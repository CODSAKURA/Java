/*This class introduces a method reference skill for class in Lambda Expressions.
 * Using Math.sqrt as an example.
 * */
public class MethodReferenceForClassInLambdaExpression_SqrtMethod {
	
	public interface FunctionR2R {
	    double valueAt( double x );
	}
	
	/** 
	 *  For a function f, compute f(start) + f(start+1) + ... + f(end).
	 *  The value of end should be >= the value of start.
	 */
	static double sum( FunctionR2R f, int start, int end ) {
	    double total = 0;
	    for (int n = start; n <= end; n++) {
	        total = total + f.valueAt( n );
	    }
	    return total;
	}
	
	public static void main(String[] args) 
	{
		System.out.print("The sum of the square root of n for n from 1 to 100 is ");
		System.out.println( sum( x -> {return Math.sqrt(x);}, 1, 100 ) );
		
		System.out.print("The sum of the square root of n for n from 1 to 100 is ");
		System.out.println( sum( Math::sqrt, 1, 100 ) );
	}
}
