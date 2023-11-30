/*This class introduces different writing forms of Lambda Expressions.*/
public class DifferentWritingFormsOfLambdaExpressions {
	
	public interface FunctionR2R {
	    double valueAt( double x );
	}
	
	public static void main(String[] args) {
		
		FunctionR2R sqr1 = (double x) -> { return x*x; }; // The full lambda expression syntax!
		FunctionR2R sqr2 = (x) -> { return x*x; };
		FunctionR2R sqr3 = x -> { return x*x; };
		FunctionR2R sqr4 = x -> x*x;
		FunctionR2R sqr5 = (double fred) -> fred*fred;
		FunctionR2R sqr6 = (z) -> z*z;
		
		System.out.println(sqr1.valueAt(2));
		System.out.println(sqr2.valueAt(2));
		System.out.println(sqr3.valueAt(2));
		System.out.println(sqr4.valueAt(2));
		System.out.println(sqr5.valueAt(2));
		System.out.println(sqr6.valueAt(2));

	}
}
