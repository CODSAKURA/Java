/*This class introduces different Lambda Expressions but in the same interfaces
 * This is the Example 2.
 * */
public class SameInterfaceDifferentLambdaExpressions2 {
	
	public interface FunctionR2R {
	    double valueAt( double x );
	}
	
	public static void main(String[] args) {
		
		FunctionR2R sqr = (x) -> { return x * x; };		
		
		FunctionR2R div = x -> {return x * 2;};
		
		System.out.println(sqr.valueAt(42));
		System.out.println(div.valueAt(42));
	}
}
