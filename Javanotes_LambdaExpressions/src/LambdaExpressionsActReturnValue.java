/*This class shows how to use Lambda Expressions as a return value*/
public class LambdaExpressionsActReturnValue {

	public interface FunctionR2R {
	    double valueAt( double x );
	}
	
	static FunctionR2R makePowerFunction( int n ) {
		   return x -> Math.pow(x,n);
	}
	
	public static void main(String[] args) {
		System.out.println(makePowerFunction(2).valueAt(3));
		System.out.println(makePowerFunction(10).valueAt(2));

	}


}
